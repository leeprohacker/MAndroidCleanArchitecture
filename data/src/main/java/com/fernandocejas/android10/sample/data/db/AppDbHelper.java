/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.fernandocejas.android10.sample.data.db;


import android.util.Log;

import java.util.Calendar;

import com.fernandocejas.android10.sample.data.entity.Comment;
import com.fernandocejas.android10.sample.data.entity.CommentDao;
import com.fernandocejas.android10.sample.data.entity.DaoMaster;
import com.fernandocejas.android10.sample.data.entity.DaoSession;
import com.fernandocejas.android10.sample.data.entity.Like;
import com.fernandocejas.android10.sample.data.entity.LikeDao;
import com.fernandocejas.android10.sample.domain.giphy.DDataItem;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;
    public static final String TAG =  "AppDbHelper";

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public List<DDataItem> transform(List<DDataItem> dDataItems) {
        if (dDataItems != null && !dDataItems.isEmpty()) {
            for (DDataItem item : dDataItems) {
                Like like = mDaoSession.getLikeDao().queryBuilder().where(LikeDao.Properties.IdPost.eq(item.getId())).unique();
                if (like != null) {
                    item.setLike(like.isLike());
                } else {
                    item.setLike(false);
                }
            }

        }
        return dDataItems;
    }

    @Override
    public void onLiked(String idPost, boolean isLike) {
        Like like = mDaoSession.getLikeDao().queryBuilder().where(LikeDao.Properties.IdPost.eq(idPost)).unique();
        if (like != null) {
            like.setIsLike(isLike);
            mDaoSession.getLikeDao().update(like);
        } else {
            like = new Like();
            like.setIdPost(idPost);
            like.setIsLike(isLike);
            mDaoSession.getLikeDao().insertOrReplace(like);
        }
    }

    @Override
    public Observable<Comment> postComment(String content, String idPost) {
        return Observable.fromCallable(() -> {
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setIdPost(idPost);
            String timeStamp = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(Calendar.getInstance().getTime());
            comment.setTime(timeStamp);
            long id = mDaoSession.getCommentDao().insert(comment);
            return mDaoSession.getCommentDao().load(id);
        });
    }

    @Override
    public Observable<List<Comment>> getComments(String idPost) {
        return Observable.fromCallable(() -> {
            List<Comment> list = mDaoSession.getCommentDao()
                    .queryBuilder().where(CommentDao.Properties.IdPost.eq(idPost)).list();
            return list;
        });
    }


}
