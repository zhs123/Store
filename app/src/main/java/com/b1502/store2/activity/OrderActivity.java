package com.b1502.store2.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.b1502.store2.R;
import com.b1502.store2.adapter.Tab_Adapter;
import com.b1502.store2.fragment.MyTabFragment;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ImageView order_return;
    private TabLayout order_tab;
    private ViewPager order_vp;
    private String[] mTitles = new String[]{"全部", "待付款", "待收货"};
    private ArrayList<Fragment> list;
    private Tab_Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        order_return = (ImageView) findViewById(R.id.order_return);
        order_tab = (TabLayout) findViewById(R.id.order_tab);
        order_vp = (ViewPager) findViewById(R.id.order_vp);
        initData();
        initView();

        OnClickListener();
    }

    private void OnClickListener() {
        order_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            MyTabFragment mFragment = new MyTabFragment();
            Bundle b = new Bundle();
            b.putInt("flag", i);
            mFragment.setArguments(b);
            list.add(mFragment);
        }
    }
        private void initView() {
            mAdapter = new Tab_Adapter(getSupportFragmentManager(),list,mTitles);
            //
            order_vp.setOffscreenPageLimit(3);
            order_vp.setAdapter(mAdapter);

            order_tab.setTabMode(TabLayout.MODE_FIXED);
            //与viewpager关联起来
            order_tab.setupWithViewPager(order_vp);
    }

}
