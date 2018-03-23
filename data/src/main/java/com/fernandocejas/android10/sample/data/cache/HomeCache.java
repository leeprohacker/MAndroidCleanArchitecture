package com.fernandocejas.android10.sample.data.cache;

import com.fernandocejas.android10.sample.data.entity.UserEntity;

import io.reactivex.Observable;

/**
 * Created by Leeprohacker on 3/21/18.
 */

public interface HomeCache {

    Observable<UserEntity> get(final int userId);

    void put(UserEntity userEntity);

    boolean isCached(final int userId);

    boolean isExpired();

    void evictAll();


}
