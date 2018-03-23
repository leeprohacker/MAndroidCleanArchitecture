package com.fernandocejas.android10.sample.data.retrofit.support;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class InterceptorRefreshToken implements Interceptor {
    private static final String TAG = InterceptorRefreshToken.class.getSimpleName();
    public boolean isRefreshToken = false;


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
                .header(NetConstants.KEY_AUTHORIZATION, (true ? ("Bearer " + "Get Token ") : "Bearer default"))
                .method(original.method(), original.body())
                .build();
        Response response = chain.proceed(request);

        return response;
    }

    private Request onRefreshToken(Request request) {
        boolean isHaveToken = true;
        if (isHaveToken && !isRefreshToken) {
            isRefreshToken = true;
//            Request requestRefresh = MApplication.getInstance().getRetrofitService().refreshToken(request);
//            return requestRefresh;
            return null;
        }
        return null;
    }
}
