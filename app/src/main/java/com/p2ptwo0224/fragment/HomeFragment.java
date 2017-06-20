package com.p2ptwo0224.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.p2ptwo0224.R;
import com.p2ptwo0224.common.AppNetConfig;
import com.p2ptwo0224.utils.LoadNet;
import com.p2ptwo0224.utils.LoadNetHttp;
import com.p2ptwo0224.utils.UIUtils;

/**
 * 作者：田学伟 on 2017/6/20 19:00
 * QQ：93226539
 * 作用：
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return UIUtils.inflate(R.layout.fragment_home);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        /*
        * 二次封装
        * 为什么要二次封装
        *
        * 第一  调用的方便
        * 第二  修改和维护方便
        * */
        LoadNet.getDataPost(AppNetConfig.INDEX, new LoadNetHttp() {
            @Override
            public void success(String content) {
                Log.i("http", "success: " + "context");
            }

            @Override
            public void failure(String error) {
                Log.i("http", "failure: " + error);
            }
        });

    }
}

