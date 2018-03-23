package com.fernandocejas.android10.sample.presentation.ui.comment.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fernandocejas.android10.sample.presentation.model.PComment;

import java.util.List;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class CommentAdapter extends BaseQuickAdapter<PComment,CommentViewHolder> {



    public CommentAdapter(int layoutResId, @Nullable List<PComment> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(CommentViewHolder helper, PComment item) {
        helper.bindView(item);

    }
}
