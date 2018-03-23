/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android10.sample.data.repository;

import com.fernandocejas.android10.sample.data.db.AppDbHelper;
import com.fernandocejas.android10.sample.data.entity.DaoSession;
import com.fernandocejas.android10.sample.data.entity.mapper.UserEntityDataMapper;
import com.fernandocejas.android10.sample.data.repository.datasource.UserDataStore;
import com.fernandocejas.android10.sample.data.repository.datasource.UserDataStoreFactory;
import com.fernandocejas.android10.sample.domain.DComment;
import com.fernandocejas.android10.sample.domain.IHome;
import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.domain.giphy.DDataItem;
import com.fernandocejas.android10.sample.domain.repository.DRepository;

import io.reactivex.Observable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link DRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements DRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    private final AppDbHelper appDbHelper;


    /**
     * Constructs a {@link DRepository}.
     *
     * @param dataStoreFactory     A factory to construct different data source implementations.
     * @param userEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    UserDataRepository(UserDataStoreFactory dataStoreFactory,
                       UserEntityDataMapper userEntityDataMapper, AppDbHelper appDbHelper) {
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
        this.appDbHelper = appDbHelper;


    }

    @Override
    public Observable<List<User>> users() {
        //we always get all users from the cloud
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList().map(this.userEntityDataMapper::transform);
    }

    @Override
    public Observable<User> user(int userId) {
        final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId).map(this.userEntityDataMapper::transform);
    }

    @Override
    public Observable<IHome> getHome() {
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.getHome().map(this.userEntityDataMapper::transform);
    }

    @Override
    public Observable<List<DDataItem>> getGiphyTrend(int offset, int limit) {
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.getGiphyTrend(offset, limit).map(this.userEntityDataMapper::transform).map(this.appDbHelper::transform);
    }

    @Override
    public void onLiked(String idPost, boolean isLike) {
        appDbHelper.onLiked(idPost,isLike);
    }

    @Override
    public Observable<DComment> postComment(String content, String idPost) {
        return appDbHelper.postComment(content,idPost).map(this.userEntityDataMapper::transform);
    }

    @Override
    public Observable<List<DComment>> getComments(String idPost) {
        return appDbHelper.getComments(idPost).map(this.userEntityDataMapper::transform);
    }
}
