package com.fernandocejas.android10.sample.data.retrofit;

import com.fernandocejas.android10.sample.data.entity.BaseRp;
import com.fernandocejas.android10.sample.data.entity.giphy.TrendRp;
import com.fernandocejas.android10.sample.data.retrofit.support.NetConstants;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ApiService {

    @POST(NetConstants.API_HOME)
    Observable<BaseRp> getHome();


    @GET(NetConstants.API_TRENDS)
    Observable<TrendRp> getGiphyTrends(@Query("api_key") String apiKey, @Query("offset") int offset, @Query("limit") int limit, @Query("fmt") String  format);


}
