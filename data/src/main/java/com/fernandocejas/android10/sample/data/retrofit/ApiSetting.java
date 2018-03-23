package com.fernandocejas.android10.sample.data.retrofit;

import javax.inject.Inject;

/**
 * Created by Dieu on 22/02/2017.
 */

public class ApiSetting {
    private static final String TAG = ApiSetting.class.getSimpleName();
    private String SEC_PARAM;

    @Inject
    public ApiSetting(String sec) {
        SEC_PARAM = sec;
    }

    public String getSEC_PARAM() {
        return SEC_PARAM;
    }

    public void setSEC_PARAM(String SEC_PARAM) {
        this.SEC_PARAM = SEC_PARAM;
    }
}
