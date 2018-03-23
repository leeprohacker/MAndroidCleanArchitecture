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
package com.fernandocejas.android10.sample.presentation.mapper;

import com.fernandocejas.android10.sample.data.entity.Comment;
import com.fernandocejas.android10.sample.data.entity.giphy.DataItem;
import com.fernandocejas.android10.sample.data.entity.giphy.TrendRp;
import com.fernandocejas.android10.sample.domain.DComment;
import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.domain.giphy.DDataItem;
import com.fernandocejas.android10.sample.domain.giphy.DFixedHeightSmallStill;
import com.fernandocejas.android10.sample.domain.giphy.DFixedHeightStill;
import com.fernandocejas.android10.sample.domain.giphy.DFixedWidth;
import com.fernandocejas.android10.sample.domain.giphy.DImages;
import com.fernandocejas.android10.sample.domain.giphy.DOriginalStill;
import com.fernandocejas.android10.sample.domain.giphy.DUser;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.model.PComment;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.model.giphy.PFixedHeightSmallStill;
import com.fernandocejas.android10.sample.presentation.model.giphy.PFixedHeightStill;
import com.fernandocejas.android10.sample.presentation.model.giphy.PFixedWidth;
import com.fernandocejas.android10.sample.presentation.model.giphy.PImages;
import com.fernandocejas.android10.sample.presentation.model.giphy.POriginalStill;
import com.fernandocejas.android10.sample.presentation.model.giphy.PUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class DModelDataMapper {

    @Inject
    public DModelDataMapper() {
    }

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final UserModel userModel = new UserModel(user.getUserId());
        userModel.setCoverUrl(user.getCoverUrl());
        userModel.setFullName(user.getFullName());
        userModel.setEmail(user.getEmail());
        userModel.setDescription(user.getDescription());
        userModel.setFollowers(user.getFollowers());

        return userModel;
    }



    public Collection<UserModel> transformUser(Collection<User> usersCollection) {
        Collection<UserModel> userModelsCollection;

        if (usersCollection != null && !usersCollection.isEmpty()) {
            userModelsCollection = new ArrayList<>();
            for (User user : usersCollection) {
                userModelsCollection.add(transform(user));
            }
        } else {
            userModelsCollection = Collections.emptyList();
        }

        return userModelsCollection;
    }

    public List<PDataItem> transformPData(List<DDataItem> dDataItems) {
        List<PDataItem> pDataItems = new ArrayList();
        if (dDataItems != null && !dDataItems.isEmpty()) {
            for (DDataItem dataItem : dDataItems) {
                pDataItems.add(transform(dataItem));
            }
        }
        return pDataItems;
    }

    public PDataItem transform(DDataItem dataItem) {
        PDataItem dDataItem = new PDataItem();
        dDataItem.setId(dataItem.getId());
        dDataItem.setTitle(dataItem.getTitle());
        dDataItem.setUser(transform(dataItem.getUser()));
        dDataItem.setType(dataItem.getType());
        dDataItem.setUrl(dataItem.getUrl());
        dDataItem.setLike(dataItem.isLike());
        dDataItem.setImportDatetime(dataItem.getImportDatetime());
        dDataItem.setImages(transform(dataItem.getImages()));

        return dDataItem;
    }


    public PUser transform(DUser item) {
        PUser dUser = new PUser();
        dUser.setUsername(item.getUsername());
        dUser.setAvatarUrl(item.getAvatarUrl());
        dUser.setDisplayName(item.getDisplayName());
        dUser.setIsVerified(item.isIsVerified());
        return dUser;
    }


    public PImages transform(DImages dImages) {
        PImages pImages = new PImages();
        pImages.setFixedHeightStill(transform(dImages.getFixedHeightStill()));

        pImages.setOriginalStill(transform(dImages.getOriginalStill()));

        pImages.setFixedWidth(transform(dImages.getFixedWidth()));

        pImages.setFixedHeightSmallStill(transform(dImages.getFixedHeightSmallStill()));

        return pImages;
    }

    public PFixedHeightStill transform(DFixedHeightStill dFixedHeightStill) {
        PFixedHeightStill pFixedHeightStill = new PFixedHeightStill();
        pFixedHeightStill.setUrl(dFixedHeightStill.getUrl());
        pFixedHeightStill.setWidth(dFixedHeightStill.getWidth());
        pFixedHeightStill.setHeight(dFixedHeightStill.getHeight());
        pFixedHeightStill.setSize(dFixedHeightStill.getSize());
        return pFixedHeightStill;
    }

    public POriginalStill transform(DOriginalStill dOriginalStill) {
        POriginalStill x = new POriginalStill();
        x.setUrl(dOriginalStill.getUrl());
        x.setWidth(dOriginalStill.getWidth());
        x.setHeight(dOriginalStill.getHeight());
        x.setSize(dOriginalStill.getSize());
        return x;
    }


    public PFixedWidth transform(DFixedWidth dOriginalStill) {
        PFixedWidth x = new PFixedWidth();
        x.setUrl(dOriginalStill.getUrl());
        x.setWidth(dOriginalStill.getWidth());
        x.setHeight(dOriginalStill.getHeight());
        x.setSize(dOriginalStill.getSize());
        return x;
    }

    public PFixedHeightSmallStill transform(DFixedHeightSmallStill dOriginalStill) {
        PFixedHeightSmallStill x = new PFixedHeightSmallStill();
        x.setUrl(dOriginalStill.getUrl());
        x.setWidth(dOriginalStill.getWidth());
        x.setHeight(dOriginalStill.getHeight());
        x.setSize(dOriginalStill.getSize());
        return x;
    }


    public List<PComment> transform(List<DComment> commentList) {
        List<PComment> dComments = new ArrayList();
        if (commentList != null && !commentList.isEmpty()) {
            for (DComment item : commentList) {
                dComments.add(transform(item));
            }
        }
        return dComments;
    }

    public PComment transform(DComment dataItem) {
        return new PComment(dataItem.getId(),dataItem.getContent(),dataItem.getTime(),dataItem.getIdPost());
    }


}
