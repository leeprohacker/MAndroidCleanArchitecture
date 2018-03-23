package com.fernandocejas.android10.sample.data.retrofit;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;


import com.fernandocejas.android10.sample.data.entity.BaseRp;
import com.fernandocejas.android10.sample.data.entity.giphy.TrendRp;
import com.fernandocejas.android10.sample.data.retrofit.support.InterceptorRefreshToken;
import com.fernandocejas.android10.sample.data.retrofit.support.NetConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Singleton
public class RetrofitService implements ApiRetrofit {

    private static String TAG = RetrofitService.class.getSimpleName();
    public ApiService mApiService;
    public ApiSetting mApiSetting;

    @Inject
    public  RetrofitService(Context context) {
        Log.d(TAG,"xyz--RetrofitService-"+(mApiService ==null));
        if (mApiService == null) {
            init(context);
        }
    }

    private void init(Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);


        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        InterceptorRefreshToken interceptorRefreshToken = new InterceptorRefreshToken();
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptorRefreshToken)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetConstants.BASE_URL)
                .client(client)
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    @Inject
    public RetrofitService(ApiService mApiService, ApiSetting mApiSetting) {
        this.mApiService = mApiService;
        this.mApiSetting = mApiSetting;
    }

    public RetrofitService(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Request refreshToken(Request request) {
        return null;
    }


    @Override
    public Observable<BaseRp> getHome() {
        return mApiService.getHome();
    }

    @Override
    public Observable<TrendRp> getGiphyTrends(int offset, int limit) {
        return mApiService.getGiphyTrends(NetConstants.API_KEY_GIPHY, offset, limit, NetConstants.FORMAT_JSON);
    }

}
