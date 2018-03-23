package com.fernandocejas.android10.sample.presentation.ui.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;

import java.util.List;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class HomeAdapter extends BaseQuickAdapter<PDataItem,HomeViewHolder> {


    public HomeAdapter(int layoutResId, @Nullable List<PDataItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(HomeViewHolder helper, PDataItem item) {
        helper.bindView(item);

    }
}
