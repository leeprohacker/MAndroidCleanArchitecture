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

/**
 * Created by Dieu on 22/02/2017.
 */

public interface ApiService {


    @FormUrlEncoded
    @POST(NetConstants.API_REFESH_TOKEN_AND_LOGIN)
    Call<BaseRp> requestRefreshToken(@Field("grant_type") String grant_type, @Field("refresh_token") String refreshToken,
                                     @Field("client_id") String client_id,
                                     @Field("client_secret") String client_secret);

    @FormUrlEncoded
    @POST(NetConstants.API_REFESH_TOKEN_AND_LOGIN)
    Call<BaseRp> getToken(@Field("grant_type") String grant_type, @Field("username") String username,
                          @Field("password") String password, @Field("facebook_token") String tokenFacebook, @Field("client_id") String client_id,
                          @Field("client_secret") String client_secret);


    @POST(NetConstants.API_HOME)
    Observable<BaseRp> getHome();


    @GET(NetConstants.API_TRENDS)
    Observable<TrendRp> getGiphyTrends(@Query("api_key") String apiKey, @Query("offset") int offset, @Query("limit") int limit, @Query("fmt") String  format);


}
