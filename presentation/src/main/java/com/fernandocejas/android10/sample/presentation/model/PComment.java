package com.fernandocejas.android10.sample.presentation.model;


/**
 * Created by Leeprohacker on 3/22/18.
 */

public class PComment {

    private Long id;

    private String content;

    private String time;

    private  String idPost;

    public PComment(Long id, String content, String time, String idPost) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.idPost = idPost;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
