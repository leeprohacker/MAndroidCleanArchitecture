package com.fernandocejas.android10.sample.data.retrofit.support;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Dieu on 22/02/2017.
 */

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
//        DebugLog.d("xyz--responseCode--" + response.code());
//        if (response.code() != 401)
//        else {
//            String bodyRp = response.body().string();
//            DebugLog.d("xyz--responseBody" + bodyRp);
//            OnResponse onResponse = new Gson().fromJson(bodyRp, OnResponse.class);
//            if (response.code() == 401 && onResponse != null && onResponse.getErrors() != null && onResponse.getErrors().getCode() != null) {
//                DebugLog.d("xyz--OnResponseCode-code-" + onResponse.getCode());
//                DebugLog.d("xyz--OnResponseCode-codeError-" + onResponse.getErrors().getCode());
//                if (onResponse.getErrors().getCode().equals(NetConstants.ERROR_TOKEN_EXPIRE)) {
//                    Request newRequest = onRefreshToken(request);
//                    isRefreshToken = false;
//                    if (newRequest != null)
//                        return chain.proceed(newRequest);
//                }
//            }
//            return response.newBuilder()
//                    .body(ResponseBody.create(response.body().contentType(), bodyRp))
//                    .build();
//        }
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
