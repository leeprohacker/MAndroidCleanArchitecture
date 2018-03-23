package com.fernandocejas.android10.sample.presentation.ui.home;

import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.ui.base.MvpView;

import java.util.List;
/**
 * Created by Leeprohacker on 3/22/18.
 */
public interface HomeScene extends MvpView {

    void onBindData(List<PDataItem> data);

    void getGetGiphyTrendFailure();

    void updateLike(int position, PDataItem item);
}
