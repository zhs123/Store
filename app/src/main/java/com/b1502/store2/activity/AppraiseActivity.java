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

public class AppraiseActivity extends AppCompatActivity {

    private ImageView appraise_return;
    private TabLayout appraise_tab;
    private ViewPager appraise_vp;
    private String[] mTitles = new String[]{"待评价", "已评价"};
    private ArrayList<Fragment> list;
    private Tab_Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appraise);
        appraise_return = (ImageView) findViewById(R.id.appraise_return);
        appraise_tab = (TabLayout) findViewById(R.id.appraise_tab);
        appraise_vp = (ViewPager) findViewById(R.id.appraise_vp);
        initData();
        initView();

        OnClickListener();
    }
    private void OnClickListener() {
        appraise_return.setOnClickListener(new View.OnClickListener() {
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
        appraise_vp.setOffscreenPageLimit(2);
        appraise_vp.setAdapter(mAdapter);

        appraise_tab.setTabMode(TabLayout.MODE_FIXED);
        //与viewpager关联起来
        appraise_tab.setupWithViewPager(appraise_vp);
    }
}
