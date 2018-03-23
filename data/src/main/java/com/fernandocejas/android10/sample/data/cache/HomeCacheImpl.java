package com.fernandocejas.android10.sample.data.cache;

import com.fernandocejas.android10.sample.data.entity.UserEntity;

import io.reactivex.Observable;

/**
 * Created by Leeprohacker on 3/21/18.
 */

public class HomeCacheImpl  implements  HomeCache {


    @Override
    public Observable<UserEntity> get(int userId) {
        return null;
    }

    @Override
    public void put(UserEntity userEntity) {

    }

    @Override
    public boolean isCached(int userId) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }
}
