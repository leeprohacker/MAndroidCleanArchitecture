package com.fernandocejas.android10.sample.presentation.ui.home;

import android.content.Context;
import android.content.Intent;

import com.fernandocejas.android10.sample.domain.giphy.DDataItem;
import com.fernandocejas.android10.sample.domain.interactor.ActionLike;
import com.fernandocejas.android10.sample.domain.interactor.DefaultObserver;
import com.fernandocejas.android10.sample.domain.interactor.GetGiphyTrend;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.mapper.DModelDataMapper;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.ui.base.MyBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Leeprohacker on 3/22/18.
 */
@PerActivity
public class HomePresenterImpl extends MyBasePresenter<HomeScene> implements HomePresenter {

    private int offset = 0;
    private int limit = 10;

    private boolean isRequest = false;

    private final GetGiphyTrend getGiphyTrend;
    private final DModelDataMapper userModelDataMapper;
    private final ActionLike actionLike;

    @Inject
    public HomePresenterImpl(GetGiphyTrend getGiphyTrend, ActionLike actionLike,
                             DModelDataMapper userModelDataMapper) {
        this.getGiphyTrend = getGiphyTrend;
        this.userModelDataMapper = userModelDataMapper;
        this.actionLike = actionLike;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.getGiphyTrend.dispose();
        this.actionLike.dispose();
    }

    @Override
    public void getGiphyTrend() {
        if (isRequest) {
            return;
        }
        isRequest = true;
        this.getGiphyTrend.execute(new HomeObserver(), GetGiphyTrend.Params.forParam(limit, offset));
    }

    @Override
    public void onShare(Context context, PDataItem item) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, item.getTitle());
        i.putExtra(Intent.EXTRA_TEXT, item.getUrl());
        context.startActivity(Intent.createChooser(i, item.getUrl()));
    }

    @Override
    public void onLiked(PDataItem item , int position) {
        boolean isLike = !item.isLike();
        item.setLike(isLike);
        actionLike.execute(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean value) {
                if (isViewAttached()){
                    getMvpView().updateLike(position,item);
                }
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        },ActionLike.Params.forParam(item.getId(),isLike));
    }

    private final class HomeObserver extends DefaultObserver<List<DDataItem>> {
        @Override
        public void onComplete() {
            isRequest = false;
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            if (isViewAttached()) {
                getMvpView().getGetGiphyTrendFailure();
                isRequest = false;
            }
        }

        @Override
        public void onNext(List<DDataItem> data) {
            if (isViewAttached()) {
                if (data != null) {
                    if (data.size() > 0) {
                        offset += limit;
                    }
                    getMvpView().onBindData(userModelDataMapper.transformPData(data));
                } else {
                    getMvpView().getGetGiphyTrendFailure();
                }
            }
            isRequest = false;
        }
    }
}
