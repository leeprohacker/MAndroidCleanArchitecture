package com.fernandocejas.android10.sample.data.retrofit;


import com.fernandocejas.android10.sample.data.entity.BaseRp;
import com.fernandocejas.android10.sample.data.entity.giphy.TrendRp;

import io.reactivex.Observable;
import okhttp3.Request;
import retrofit2.http.Query;



public interface ApiRetrofit {

    Request refreshToken(Request request);

    Observable<BaseRp> getHome();

    Observable<TrendRp> getGiphyTrends(int offset, int limit);


}

