package com.fernandocejas.android10.sample.presentation.ui.comment;

import com.fernandocejas.android10.sample.presentation.ui.base.MvpPresenter;

/**
 * Created by Leeprohacker on 3/22/18.
 */
public interface CommentPresenter extends MvpPresenter<CommentScene> {

    void onLoadAllComment(String idPost);

    void addComment(String idPost,String comment);

}
