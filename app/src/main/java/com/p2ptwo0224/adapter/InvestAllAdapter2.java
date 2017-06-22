package com.p2ptwo0224.adapter;

import android.view.View;
import android.widget.TextView;

import com.p2ptwo0224.R;
import com.p2ptwo0224.bean.InvestAllBean;
import com.p2ptwo0224.utils.UIUtils;

import java.util.List;

/**
 * 作者：田学伟 on 2017/6/22 19:40
 * QQ：93226539
 * 作用：
 */

public class InvestAllAdapter2 extends BaseInvestAllAdapter02<InvestAllBean.DataBean> {
    public InvestAllAdapter2(List<InvestAllBean.DataBean> list) {
        super(list);
    }

    @Override
    public View initView() {
        return UIUtils.getView(R.layout.adapter_invest_all);
    }

    @Override
    protected void setData(InvestAllBean.DataBean dataBean, View view) {
        TextView pname = (TextView) view.findViewById(R.id.p_name);
        pname.setText(dataBean.getName());
    }


}
