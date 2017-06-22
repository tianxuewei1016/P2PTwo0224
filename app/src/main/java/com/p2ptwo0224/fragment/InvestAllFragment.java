package com.p2ptwo0224.fragment;

import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.p2ptwo0224.R;
import com.p2ptwo0224.adapter.InvestAllAdapter2;
import com.p2ptwo0224.base.BaseFragment;
import com.p2ptwo0224.bean.InvestAllBean;
import com.p2ptwo0224.common.AppNetConfig;

import butterknife.Bind;

/**
 * 作者：田学伟 on 2017/6/22 18:23
 * QQ：93226539
 * 作用：
 */

public class InvestAllFragment extends BaseFragment {
    @Bind(R.id.invest_all_lv)
    ListView investAllLv;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        InvestAllBean investAllBean = JSON.parseObject(json, InvestAllBean.class);
//        InvestAllAdapter adapter = new InvestAllAdapter(investAllBean.getData());
        InvestAllAdapter2 adapter = new InvestAllAdapter2(investAllBean.getData());
        investAllLv.setAdapter(adapter);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_invest_all;
    }

    @Override
    public String getChildUrl() {
        return AppNetConfig.PRODUCT;
    }

}
