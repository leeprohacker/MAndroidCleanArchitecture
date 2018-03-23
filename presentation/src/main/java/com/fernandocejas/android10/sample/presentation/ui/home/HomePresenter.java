package com.fernandocejas.android10.sample.presentation.ui.home;

import android.content.Context;

import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.ui.base.MvpPresenter;

/**
 * Created by Leeprohacker on 3/22/18.
 */
public interface HomePresenter extends MvpPresenter<HomeScene> {

    void getGiphyTrend();

    void onShare(Context context, PDataItem item);

    void onLiked(PDataItem item , int position);
}
