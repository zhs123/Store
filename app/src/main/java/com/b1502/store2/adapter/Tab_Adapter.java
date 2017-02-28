package com.b1502.store2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Pooh on 2017/2/28.
 */
public class Tab_Adapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private String[] mTitles;

    public Tab_Adapter(FragmentManager fm, List<Fragment> list, String[] mTitles) {
        super(fm);
        this.list = list;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
