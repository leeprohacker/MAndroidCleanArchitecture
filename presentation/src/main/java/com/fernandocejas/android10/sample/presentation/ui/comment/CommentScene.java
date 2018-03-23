package com.fernandocejas.android10.sample.presentation.ui.comment;

import com.fernandocejas.android10.sample.presentation.model.PComment;
import com.fernandocejas.android10.sample.presentation.ui.base.MvpView;

import java.util.List;

/**
 * Created by Leeprohacker on 3/22/18.
 */
public interface CommentScene extends MvpView {


    boolean isCommentEmpty();

    void onBindComment(List<PComment> transform);

    void addComment(PComment transform);


}
