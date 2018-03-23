package com.fernandocejas.android10.sample.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Leeprohacker on 3/22/18.
 */

@Entity
public class Like {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String idPost;

    private boolean isLike;

    @Generated(hash = 723236069)
    public Like(Long id, String idPost, boolean isLike) {
        this.id = id;
        this.idPost = idPost;
        this.isLike = isLike;
    }

    @Generated(hash = 763251169)
    public Like() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public boolean getIsLike() {
        return this.isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }
}
