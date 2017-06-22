package com.p2ptwo0224.fragment;

import android.graphics.Color;
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
    @Bind(R.id.tv_invest_all)
    TextView tvInvestAll;
    @Bind(R.id.tv_invest_recommend)
    TextView tvInvestRecommend;
    @Bind(R.id.tv_invest_hot)
    TextView tvInvestHot;

    @Override
    protected void initListener() {
        investVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //偏移理
            }

            @Override
            public void onPageSelected(int position) {
                selectText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tvInvestAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(0);
            }
        });
        tvInvestHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(2);
            }
        });
        tvInvestRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(1);
            }
        });
    }

    private void selectText(int id) {
        //把所有的背景色还原成默认值
        hiddenTextViewState();
        switch (id) {
            case 0:
                //改变当前的背景色
                tvInvestAll.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                tvInvestRecommend.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                tvInvestHot.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    /**
     * 回复默认状态
     */
    private void hiddenTextViewState() {
        tvInvestRecommend.setBackgroundColor(Color.WHITE);
        tvInvestHot.setBackgroundColor(Color.WHITE);
        tvInvestAll.setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void initData(String json) {
        //设置标题
        initTitle();
        //初始化Fragment
        initFragment();
        //初始化viewPager
        initViewPager();
        //设置默认选中的tab
        initTab();
    }

    private void initTab() {
        selectText(0);
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

