package com.p2ptwo0224.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p2ptwo0224.R;
import com.p2ptwo0224.adapter.InvesAdapter;
import com.p2ptwo0224.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 作者：田学伟 on 2017/6/20 19:01
 * QQ：93226539
 * 作用：
 */

public class InvestFragment extends BaseFragment {

    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.invest_vp)
    ViewPager investVp;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        //设置标题
        initTitle();
        //初始化Fragment
        initFragment();
        //初始化viewPager
        initViewPager();
    }

    private void initViewPager() {
        investVp.setAdapter(new InvesAdapter(getChildFragmentManager(), fragments));
    }

    private List<BaseFragment> fragments = new ArrayList<>();

    private void initFragment() {
        fragments.add(new InvestAllFragment());
        fragments.add(new InvestRecommendFragment());
        fragments.add(new InvestHotFragment());
    }

    private void initTitle() {
        baseSetting.setVisibility(View.GONE);
        baseTitle.setText("投资");
        baseBack.setVisibility(View.GONE);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_invest;
    }

    @Override
    public String getChildUrl() {
        return null;
    }
}

