package com.fernandocejas.android10.sample.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Leeprohacker on 3/21/18.
 */

public class BaseRp implements Serializable {

    @SerializedName("msg")
    private String msg;

    @SerializedName("err")
    private int err;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setErr(int err){
        this.err = err;
    }

    public int getErr(){
        return err;
    }



}
