/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.presentation.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.HasComponent;
import com.kennyc.view.MultiStateView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class MyBaseFragment extends SupportFragment implements MvpView, OnRetryListener {

    protected View mRootView;
    private MyBaseActivity mActivity;
    private Unbinder mUnBinder;

    @Nullable
    @BindView(R.id.multiStateView)
    MultiStateView mStateView;


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        mActivity = (MyBaseActivity) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initField();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getResLayout(), container, false);
        setUnBinder(ButterKnife.bind(this, mRootView));
        return mRootView;
    }


    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }


    //end
    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }


    public MyBaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }


    @Override
    public void showLoading() {
        MMultilStateView.getInstance().showProgressBar(mStateView);

    }

    @Override
    public void showContent() {
        MMultilStateView.getInstance().showContent(mStateView);
    }

    @Override
    public void onEmpty(String message, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showEmpty(mStateView, message, isRetry, tagRetry, this);
    }

    @Override
    public void onEmpty(@StringRes int resString, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showEmpty(mStateView, getContext(), resString, isRetry, tagRetry, this);
    }

    @Override
    public void onError(String message, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageError(mStateView, message, isRetry, tagRetry, this);

    }


    @Override
    public void onError(@StringRes int resId, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageError(mStateView, getContext(), resId, isRetry, tagRetry, this);
    }


    @Override
    public void onErrorByTag(String tagError, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageByTagError(mStateView, getContext(), tagError, isRetry, tagRetry, this);
    }

    @Override
    public void onToastMessage(String message) {
        if (mActivity != null) {
            mActivity.onToastMessage(message);
        }

    }

    @Override
    public void onToastMessage(@StringRes int redString) {
        if (mActivity != null) {
            mActivity.onToastMessage(redString);
        }
    }

    @Override
    public void onShowMessageSnackBar(String message) {
        if (mActivity != null) {
            mActivity.onShowMessageSnackBar(message);
        }

    }

    @Override
    public void onShowMessageSnackBar(@StringRes int resString) {
        if (mActivity != null) {
            mActivity.onShowMessageSnackBar(resString);
        }
    }

    //    abstract

    protected abstract int getResLayout();

    protected abstract void initField();

    protected abstract void initView();


}
