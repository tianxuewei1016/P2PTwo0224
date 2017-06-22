package com.p2ptwo0224.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;

/**
 * 作者：田学伟 on 2017/6/22 15:30
 * QQ：93226539
 * 作用：
 */

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayoutId() == 0) {
            TextView view = new TextView(getActivity());
            view.setText("没有设置布局呢");
            return view;
        }

        View view = View.inflate(getActivity(), getLayoutId(), null);
        ButterKnife.bind(this, view);

        initView();
        initTitle();
        initData();
        initListener();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected abstract void initTitle();

    /*
    * 重写
    * */
    private void initListener() {

    }

    protected abstract void initData();

    /*
    * 可以重写
    *
    * */
    private void initView() {

    }

    public abstract int getLayoutId();
}

