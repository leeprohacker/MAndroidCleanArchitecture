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



import com.fernandocejas.android10.sample.data.entity.Comment;
import com.fernandocejas.android10.sample.domain.giphy.DDataItem;

import java.util.List;

import io.reactivex.Observable;




public interface DbHelper {

    List<DDataItem> transform(List<DDataItem> dDataItems);

    void onLiked(String idPost , boolean isLike);

    Observable<Comment> postComment(String content,String idPost);

    Observable<List<Comment>> getComments(String idPost);


}
