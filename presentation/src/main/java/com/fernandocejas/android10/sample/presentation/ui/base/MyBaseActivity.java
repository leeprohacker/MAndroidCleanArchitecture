package com.fernandocejas.android10.sample.presentation.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.fernandocejas.android10.sample.presentation.AndroidApplication;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.components.ApplicationComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.modules.ActivityModule;
import com.fernandocejas.android10.sample.presentation.navigation.Navigator;
import com.kennyc.view.MultiStateView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Base {@link Activity} class for every Activity in this application.
 */
public abstract class MyBaseActivity extends SupportActivity implements MvpView , OnRetryListener {

    @Inject
    Navigator navigator;

    private Unbinder mUnBinder;

    @Nullable
    @BindView(R.id.multiStateView)
    MultiStateView mStateView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getApplicationComponent().inject(this);

        super.onCreate(savedInstanceState);

        setContentView(getResLayout());
        setUnBinder(ButterKnife.bind(this));
        initField();

        initView();
    }


    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder!= null){
            mUnBinder.unbind();
        }
    }

    private void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    /**
     * ----View Sate
     */

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
        MMultilStateView.getInstance().showEmpty(mStateView,message,isRetry,tagRetry,this);
    }

    @Override
    public void onEmpty(@StringRes int resString, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showEmpty(mStateView,this,resString,isRetry,tagRetry,this);
    }

    @Override
    public void onError(String message, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageError(mStateView,message,isRetry,tagRetry,this);

    }

    @Override
    public void onError(@StringRes int resId, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageError(mStateView,this,resId,isRetry,tagRetry,this);
    }



    @Override
    public void onErrorByTag(String tagError, boolean isRetry, String tagRetry) {
        MMultilStateView.getInstance().showMessageByTagError(mStateView,this,tagError,isRetry,tagRetry,this);
    }

    @Override
    public void onToastMessage( String message) {

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onToastMessage( @StringRes int redString) {
        Toast.makeText(this,redString,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onShowMessageSnackBar(String message) {
        showSnackBar(message);
    }

    @Override
    public void onShowMessageSnackBar(@StringRes int resString) {
        showSnackBar(getString(resString));
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected abstract int getResLayout();

    protected abstract void initField();

    protected abstract void initView();

}
