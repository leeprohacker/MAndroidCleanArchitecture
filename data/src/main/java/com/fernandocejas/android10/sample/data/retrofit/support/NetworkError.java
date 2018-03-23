package com.fernandocejas.android10.sample.data.retrofit.support;

import android.content.Context;
import android.text.TextUtils;


import com.fernandocejas.android10.sample.data.R;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.HttpException;
import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;



public class NetworkError extends Throwable {

    private Throwable mError;

    public NetworkError(Throwable mError) {
        this.mError = mError;
    }

    public String getMessagge() {
        return mError.getMessage();
    }

    public boolean isAuthFailure() {
        return (mError instanceof HttpException &&
                ((HttpException) mError).code() == HTTP_UNAUTHORIZED);

    }

    public boolean isResponseNull() {
        return mError instanceof HttpException && ((HttpException) mError).response() == null;
    }


    public String getAppErrorMessage(Context context) {
        if (this.mError instanceof IOException)
            return "Internet no connection";
        if (!(this.mError instanceof HttpException))
            return "Exception of HttpException ";

        Response<?> response = ((HttpException) mError).response();
        String message = getJsonStringFromResponse(response);

        if (!TextUtils.isEmpty(message))
            return message;
        return "Some wrong";
    }


    protected String getJsonStringFromResponse(final Response<?> response) {
        return "";
    }

}
