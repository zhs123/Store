package com.b1502.store2.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.fragment.CartFragment;
import com.b1502.store2.fragment.CategoryFragment;
import com.b1502.store2.fragment.HomeFragment;
import com.b1502.store2.fragment.NewsFragment;
import com.b1502.store2.fragment.UserInfoFragment;
import com.b1502.store2.widget.StoreFragmentTabHost;

public class MainActivity extends BaseActivity {

    // 标题
    private String tags[] = {
            "首页",
            "分类",
            "购物车",
            "资讯",
            "我的"
    };

    StoreFragmentTabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStoreBar("首页");
        storeBar.hideBackButton();
        initTab();
    }

    private void initTab() {
        tabHost = (StoreFragmentTabHost) findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.getTabWidget().setDividerDrawable(null); // 去掉分割线

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setStoreBarTitle(tabId);
            }
        });

        //初始化TAB
        Bundle bundle = null;

        for (int i = 0; i < tags.length; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tags[i]).setIndicator(getTabView(tags[i]));

            // 添加Fragment
            bundle = new Bundle();

            switch (i){
                case 0:
                    tabHost.addTab(tabSpec, HomeFragment.class, bundle);
                    break;
                case 1:
                    tabHost.addTab(tabSpec, CategoryFragment.class, bundle);
                    break;
                case 2:
                    tabHost.addTab(tabSpec, CartFragment.class, bundle);
                    break;
                case 3:
                    tabHost.addTab(tabSpec, NewsFragment.class, bundle);
                    break;
                case 4:
                    tabHost.addTab(tabSpec, UserInfoFragment.class, bundle);
                    break;
                default:
                    break;
            }
            // 设置Tab按钮的背景
            tabHost.getTabWidget().getChildAt(i).setBackgroundResource(android.R.color.white);
        }

    }

    // 获得图片资源 设置初始化指示器
    private View getTabView(String str) {
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);
        RelativeLayout layout=(RelativeLayout) view.findViewById(R.id.layout);
        TextView label=(TextView)view.findViewById(R.id.tab_label);
        label.setText(str);
        return view;
    }
}
