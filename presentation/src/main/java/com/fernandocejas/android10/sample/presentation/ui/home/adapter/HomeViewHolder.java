package com.fernandocejas.android10.sample.presentation.ui.home.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class HomeViewHolder extends BaseViewHolder {

    @BindView(R.id.img_avatar)
    SimpleDraweeView imgAvatar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;
    @BindView(R.id.img_like)
    AppCompatImageView imgLike;
    @BindView(R.id.tv_like)
    TextView tvLike;
    @BindView(R.id.view_like)
    LinearLayout viewLike;
    @BindView(R.id.img_comment)
    AppCompatImageView imgComment;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.view_comment)
    LinearLayout viewComment;
    @BindView(R.id.img_share)
    AppCompatImageView imgShare;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.view_share)
    LinearLayout viewShare;

    public HomeViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);

    }

    public void bindView(PDataItem item) {
        tvTitle.setText(item.getUser().getDisplayName());
        tvContent.setText(item.getImportDatetime());
        imgAvatar.setImageURI(item.getUser().getAvatarUrl());
        myImageView.setImageURI(item.getImages().getOriginalStill().getUrl());

        addOnClickListener(viewLike.getId());
        addOnClickListener(viewComment.getId());
        addOnClickListener(viewShare.getId());

        if(item.isLike()){
            imgLike.setColorFilter(ContextCompat.getColor(itemView.getContext(),R.color.colorAccent));
        }else {
            imgLike.setColorFilter(ContextCompat.getColor(itemView.getContext(),R.color.grey_90));
        }

//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(item.getImages().getOriginalStill().getUrl())
//                .setAutoPlayAnimations(true)
//                .build();
//        imgAvatar.setController(controller);

    }
}
