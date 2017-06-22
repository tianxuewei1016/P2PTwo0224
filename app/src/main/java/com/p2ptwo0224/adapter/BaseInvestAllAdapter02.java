package com.p2ptwo0224.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：田学伟 on 2017/6/22 19:45
 * QQ：93226539
 * 作用：
 */

public abstract class BaseInvestAllAdapter02<T> extends BaseAdapter {
    private List<T> list = new ArrayList<>();

    public BaseInvestAllAdapter02(List<T> list) {
        if (list != null && list.size() > 0) {
            this.list.clear();
            this.list.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = initView();//由子类实现view
            viewHolder = new ViewHolder(convertView);
            //convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        T t = list.get(position);
         /*
        * 第二层抽出
       * viewHolder 为了减少findviewbyID
        * */
        setData(t, convertView);
        return convertView;
    }

    protected abstract void setData(T t, View convertView);

    public abstract View initView();

    class ViewHolder {
        ViewHolder(View view) {
            view.setTag(this);
        }
    }

}
