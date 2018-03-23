package com.fernandocejas.android10.sample.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Leeprohacker on 3/22/18.
 */

@Entity
public class Comment {

    @Id(autoincrement = true)
    private Long id;

    private String content;

    private String time;

    private String idPost;


    @Generated(hash = 745837168)
    public Comment(Long id, String content, String time, String idPost) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.idPost = idPost;
    }

    @Generated(hash = 1669165771)
    public Comment() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }
}
