package com.fernandocejas.android10.sample.presentation.ui.comment.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.model.PComment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class CommentViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.text)
    TextView text;

    public CommentViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindView(PComment item) {
        tvTitle.setText(item.getContent());
        text.setText(item.getTime());
    }
}
