package com.fernandocejas.android10.sample.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.HasComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.DaggerUserComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.UserComponent;
import com.fernandocejas.android10.sample.presentation.ui.base.MyBaseActivity;
import com.fernandocejas.android10.sample.presentation.ui.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyMainActivity extends MyBaseActivity  implements HasComponent<UserComponent> {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static void start(Context context) {
        Intent starter = new Intent(context, MyMainActivity.class);
        context.startActivity(starter);
    }

    private UserComponent userComponent;


    @Override
    public void onRetry(String tag) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_my_main;
    }

    @Override
    protected void initField() {
        initializeInjector();
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        setTitle(R.string.home);
        loadRootFragment(R.id.container, HomeFragment.newInstance());
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }




}
