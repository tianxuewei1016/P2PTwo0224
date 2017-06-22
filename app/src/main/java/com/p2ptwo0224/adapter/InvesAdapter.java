package com.p2ptwo0224.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.p2ptwo0224.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：田学伟 on 2017/6/22 18:24
 * QQ：93226539
 * 作用：FragmentPagerAdapter
 *      会在内存里进行保存 但是不适合fragment较多的情况下
 *      FragmentStatePagerAdapter
 *      在内存里会定期回收掉 所以适合较多的fragment
 */

public class InvesAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();

    public InvesAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        if (this.fragments != null && this.fragments.size() > 0) {
            this.fragments = fragments;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
