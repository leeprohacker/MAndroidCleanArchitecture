package com.fernandocejas.android10.sample.presentation.ui.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.components.UserComponent;
import com.fernandocejas.android10.sample.presentation.model.giphy.PDataItem;
import com.fernandocejas.android10.sample.presentation.ui.base.MyBaseFragment;
import com.fernandocejas.android10.sample.presentation.ui.comment.CommentFragment;
import com.fernandocejas.android10.sample.presentation.ui.home.adapter.HomeAdapter;
import com.fernandocejas.android10.sample.presentation.ui.widget.CustomLoadMoreView;
import com.fernandocejas.android10.sample.presentation.ui.widget.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Leeprohacker on 3/22/18.
 */

public class HomeFragment extends MyBaseFragment implements HomeScene {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Inject
    HomePresenter mPresenter;

    private HomeAdapter mAdapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onRetry(String tag) {
        showLoading();
        mPresenter.getGiphyTrend();
    }

    @Override
    protected int getResLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initField() {
        this.getComponent(UserComponent.class).inject(this);
        mPresenter.onAttach(this);

    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(48));
        showLoading();
        mPresenter.getGiphyTrend();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDetach();
    }

    @Override
    public void onBindData(List<PDataItem> data) {
        if (mAdapter == null) {
            mAdapter = new HomeAdapter(R.layout.item_home, new ArrayList<>());
            mAdapter.setEnableLoadMore(true);
            mAdapter.setLoadMoreView(new CustomLoadMoreView());
            mAdapter.setOnLoadMoreListener(() -> mPresenter.getGiphyTrend(), recyclerView);
            mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                switch (view.getId()) {
                    case R.id.view_share:
                        mPresenter.onShare(getContext(),mAdapter.getItem(position));
                        break;
                    case R.id.view_comment:
                        start(CommentFragment.newInstance(mAdapter.getItem(position)),SINGLETASK);
                        break;
                    case R.id.view_like:
                        mPresenter.onLiked(mAdapter.getItem(position),position);
                        break;
                }

            });

            recyclerView.setAdapter(mAdapter);
        }
        mAdapter.addData(data);
        onLoadMoreComplete(data);
        showContent();
    }

    private void onLoadMoreComplete(List<PDataItem> data) {
        if (mAdapter != null && mAdapter.isLoading()) {
            if (data != null) {
                if (data.isEmpty()) {
                    mAdapter.loadMoreEnd();
                } else {
                    mAdapter.loadMoreComplete();
                }
            } else {
                mAdapter.loadMoreFail();
            }
        }
    }

    @Override
    public void getGetGiphyTrendFailure() {
        if (mAdapter == null) {
            onLoadMoreComplete(null);
        } else {
            onEmpty(R.string.some_error, true, "");
        }
    }

    @Override
    public void updateLike(int position, PDataItem item) {
        mAdapter.setData(position,item);

    }
}
