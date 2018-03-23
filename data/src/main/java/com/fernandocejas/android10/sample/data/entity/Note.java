package com.fernandocejas.android10.sample.data.entity;

import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class Note {
    @Id(autoincrement = true)
    private Long id;
    private String text;
    private long date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}