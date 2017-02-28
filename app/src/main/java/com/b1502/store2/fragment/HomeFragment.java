package com.b1502.store2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.b1502.store2.R;
import com.b1502.store2.model.AdvertItem;
import com.b1502.store2.util.GlideImageLoader;
import com.b1502.store2.util.GsonUtil;
import com.b1502.store2.util.HttpUtils;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

//首页
public class HomeFragment extends BaseFragment implements HttpUtils.RequestListener, View.OnClickListener {
    private List<String> mStrings;
    private View mView;
    private Banner mBanner;
    private XRecyclerView mXRecyclerView;
    private RadioButton mRb_collection;
    private RadioButton mRb_select;
    private RadioButton mRb_vip;
    private RadioButton mRb_integral;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //绑定接口
        getAdvertItems();
        initViews();
    }

    //初始化控件
    private void initViews() {
        mBanner = (Banner) mView.findViewById(R.id.banner);
        mXRecyclerView = (XRecyclerView) mView.findViewById(R.id.xrecyclerview);
        mXRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRb_collection = (RadioButton) mView.findViewById(R.id.rb_collection);
        mRb_select = (RadioButton) mView.findViewById(R.id.rb_select);
        mRb_vip = (RadioButton) mView.findViewById(R.id.rb_vip);
        mRb_integral = (RadioButton) mView.findViewById(R.id.rb_integral);
        mRb_collection.setOnClickListener(this);
        mRb_select.setOnClickListener(this);
        mRb_vip.setOnClickListener(this);
        mRb_integral.setOnClickListener(this);
    }

    private void getAdvertItems() {
        new HttpUtils(this);
        HttpUtils.getRequestData(UrlUtil.GetAdvertItems, 0);
        HttpUtils.getRequestData(UrlUtil.GetHomeProducts, 1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_collection:
                //我的收藏

                break;
            case R.id.rb_select:
                //订单查询

                break;
            case R.id.rb_vip:
                //会员充值

                break;
            case R.id.rb_integral:
                //积分兑换

                break;
            default:
                break;
        }
    }

    @Override
    public void getData(String result, int pageIndex) {
        if (pageIndex == 0) {
            mStrings = new ArrayList<>();
            List<AdvertItem> advertItems = GsonUtil.parseJsonToArray(result, new TypeToken<List<AdvertItem>>() {
            });
            LogUtil.i("TAG", "接口回调的数据" + advertItems.toString());
            for (int i = 0; i < advertItems.size(); i++) {
                String imgUrl = advertItems.get(i).getImgUrl();
                LogUtil.i("TAG", "解析的图片路径" + imgUrl);
                mStrings.add(imgUrl);
            }
            //图片加载器
            mBanner.setImageLoader(new GlideImageLoader());
            //修改图片集合
            mBanner.setImages(mStrings);
            mBanner.start();
        }
        if (pageIndex == 1) {

        }
    }

    @Override
    public void getDataOther(String result) {
    }
}
