package com.fernandocejas.android10.sample.presentation.ui.comment;

import com.fernandocejas.android10.sample.domain.DComment;
import com.fernandocejas.android10.sample.domain.interactor.ActionLike;
import com.fernandocejas.android10.sample.domain.interactor.GetComment;
import com.fernandocejas.android10.sample.domain.interactor.GetGiphyTrend;
import com.fernandocejas.android10.sample.domain.interactor.PostComment;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.mapper.DModelDataMapper;
import com.fernandocejas.android10.sample.presentation.ui.base.MyBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Leeprohacker on 3/22/18.
 */
public class CommentPresenterImpl extends MyBasePresenter<CommentScene> implements CommentPresenter {


    private final PostComment postComment;
    private final GetComment getComment;
    private final DModelDataMapper userModelDataMapper;

    @Inject
    public CommentPresenterImpl(PostComment postComment, GetComment getComment,
                                DModelDataMapper userModelDataMapper) {
        this.postComment = postComment;
        this.getComment = getComment;
        this.userModelDataMapper = userModelDataMapper;
    }

    @Override
    public void onLoadAllComment(String idPost) {
        getComment.execute(new DisposableObserver<List<DComment>>() {
            @Override
            public void onNext(List<DComment> value) {
                if (isViewAttached()) {
                    if (value == null || value.isEmpty()) {
                        getMvpView().onEmpty(R.string.no_comment, false, "");
                    } else {
                        getMvpView().onBindComment(userModelDataMapper.transform(value));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                getMvpView().onError(R.string.some_error, true, "");
            }

            @Override
            public void onComplete() {

            }
        }, GetComment.Params.forParam(idPost));


    }

    @Override
    public void addComment(String idPost, String comment) {
        postComment.execute(new DisposableObserver<DComment>() {
            @Override
            public void onNext(DComment value) {
                if (isViewAttached()) {
                    if (value != null) {
                        getMvpView().addComment(userModelDataMapper.transform(value));
                    } else {
                        getMvpView().onToastMessage(R.string.comment_failure);

                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onToastMessage(R.string.comment_failure);
            }

            @Override
            public void onComplete() {

            }
        }, PostComment.Params.forParam(idPost, comment));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.postComment.dispose();
        this.getComment.dispose();
    }
}
