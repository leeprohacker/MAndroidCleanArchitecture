package com.fernandocejas.android10.sample.presentation.ui.comment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.components.UserComponent;
import com.fernandocejas.android10.sample.presentation.model.PComment;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.ui.base.MyBaseFragment;
import com.fernandocejas.android10.sample.presentation.ui.comment.adapter.CommentAdapter;
import com.fernandocejas.android10.sample.presentation.ui.widget.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class CommentFragment extends MyBaseFragment implements CommentScene {


    @Inject
    CommentPresenter mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private static final String EXTRA_DATA = "EXTRA_DATA";
    PDataItem pDataItem;
    @BindView(R.id.et_send)
    EditText etSend;
    @BindView(R.id.btn_send)
    AppCompatImageView btnSend;

    private CommentAdapter mAdapter;


    public static CommentFragment newInstance(PDataItem pDataItem) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATA, pDataItem);
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onRetry(String tag) {
        showLoading();
        mPresenter.onLoadAllComment(pDataItem.getId());


    }

    @Override
    protected int getResLayout() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initField() {
        this.getComponent(UserComponent.class).inject(this);
        mPresenter.onAttach(this);
        pDataItem = (PDataItem) getArguments().getSerializable(EXTRA_DATA);


    }

    @Override
    protected void initView() {
        setFragmentAnimator(new DefaultVerticalAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(3));
        showLoading();
        mPresenter.onLoadAllComment(pDataItem.getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }


    @Override
    public boolean isCommentEmpty() {
        return mAdapter == null;
    }

    @Override
    public void onBindComment(List<PComment> transform) {
        if (mAdapter == null) {
            initAdapter();
        }
        mAdapter.addData(transform);
        showContent();

    }

    private void initAdapter() {
        mAdapter = new CommentAdapter(R.layout.item_comment, new ArrayList());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void addComment(PComment transform) {
        if (mAdapter == null) {
            initAdapter();
        }
        mAdapter.addData(transform);
        showContent();

    }


    @OnClick(R.id.btn_send)
    public void onViewClicked() {
        String content = etSend.getText().toString().trim();
        if (TextUtils.isEmpty(content)){
                onToastMessage(R.string.no_content);
        }else {
            mPresenter.addComment(pDataItem.getId(),content);
            etSend.setText("");
        }
    }
}
