package com.fernandocejas.android10.sample.presentation.ui.base;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.fernandocejas.android10.sample.presentation.R;
import com.kennyc.view.MultiStateView;

/**
 * Created by Leeprohacker on 5/10/17.
 */

public class MMultilStateView {

   private static MMultilStateView mInstance;

    public MMultilStateView() {
        if (mInstance != null)
            throw new RuntimeException("Use getInstance() method to get single instance of this class");
    }

    public static MMultilStateView getInstance(){
        if (mInstance == null) {
            synchronized (MMultilStateView.class){
                if (mInstance == null){
                    mInstance =  new MMultilStateView();
                }
            }
        }
        return mInstance;
    }


    public void showProgressBar(MultiStateView mMultiStateView) {
        if (mMultiStateView != null)
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }


    public  void showMessageError(MultiStateView mMultiStateView, String message, boolean isShowRetry, String tagRetry, OnRetryListener listener) {
        if (mMultiStateView != null) {
            View viewRetry = mMultiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.btn_retry);
            TextView tvMessage = (TextView) mMultiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_message);
            if (viewRetry != null && tvMessage != null) {
                if (!isShowRetry) {
                    viewRetry.setVisibility(View.GONE);
                } else {
                    viewRetry.setVisibility(View.VISIBLE);
                    viewRetry.setOnClickListener(view -> listener.onRetry(tagRetry));
                }
                tvMessage.setText(message);
            }
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
        }
    }


    public void showMessageError(MultiStateView mMultiStateView, Context context, int resId, boolean isShowRetry, String tagRetry, OnRetryListener listener) {
        if (mMultiStateView != null) {
            View viewRetry = mMultiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.btn_retry);
            TextView tvMessage = (TextView) mMultiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.tv_message);
            if (viewRetry != null && tvMessage != null) {
                if (!isShowRetry) {
                    viewRetry.setVisibility(View.GONE);
                } else {
                    viewRetry.setVisibility(View.VISIBLE);
                    viewRetry.setOnClickListener(view -> listener.onRetry(tagRetry));
                }
                tvMessage.setText(context.getString(resId));
            }
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
        }
    }

    public void showMessageByTagError(MultiStateView mMultiStateView, Context context, String tagError, boolean isShowRetry, String tagRetry, OnRetryListener listener) {
//        if (AppConstants.TAG_ERROR_INTERNET_NO_CONNECTION.equals(tagError)) {
//            showMessageError(mMultiStateView, context, R.string.internet_no_connection, isShowRetry, tagRetry,listener);
//        } else if (AppConstants.TAG_ERROR_CONNECTION_FAILURE.equals(tagError)) {
//            showMessageError(mMultiStateView, context,R.string.text_all_connection_failure, isShowRetry, tagRetry,listener);
//        } else showMessageError(mMultiStateView, context, R.string.text_all_connection_unknown, isShowRetry, tagRetry,listener);
        showMessageError(mMultiStateView, context, R.string.internet_no_connection, isShowRetry, tagRetry,listener);
    }

    public void showEmpty(MultiStateView mMultiStateView, String message, boolean isShowRetry, String tagRetry, OnRetryListener listener) {
        if (mMultiStateView != null) {
            if (TextUtils.isEmpty(message)) {
                TextView tvEmpty = (TextView) mMultiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.tv_empty);
                View viewRetry = mMultiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.img_retry);
                if (viewRetry != null) {
                    if (isShowRetry) {
                        viewRetry.setVisibility(View.VISIBLE);
                        viewRetry.setOnClickListener(v -> new Handler().postDelayed(() -> listener.onRetry(tagRetry), 200));
                    } else viewRetry.setVisibility(View.GONE);
                }
                if (tvEmpty != null)
                    tvEmpty.setText(message);
            }
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
        }
    }

    public void showEmpty(MultiStateView mMultiStateView, Context context, int resId, boolean isShowRetry, String tagRetry, OnRetryListener listener) {
        if (mMultiStateView != null) {
            TextView tvEmpty = (TextView) mMultiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.tv_empty);
            View viewRetry = mMultiStateView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.img_retry);
            if (viewRetry != null) {
                if (isShowRetry) {
                    viewRetry.setVisibility(View.VISIBLE);
                    viewRetry.setOnClickListener(v -> new Handler().postDelayed(() -> listener.onRetry(tagRetry), 200));
                } else viewRetry.setVisibility(View.GONE);
            }
            if (tvEmpty != null)
                tvEmpty.setText(context.getString(resId));
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
        }
    }

    public void showContent(MultiStateView mMultiStateView) {
        if (mMultiStateView != null)
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

}
