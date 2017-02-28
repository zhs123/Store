package com.b1502.store2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.b1502.store2.R;
import com.b1502.store2.model.AdvertItem;
import com.b1502.store2.model.StoreParams;
import com.b1502.store2.util.GsonUtil;
import com.b1502.store2.util.HttpUtils;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.x;

//首页
public class HomeFragment extends BaseFragment implements HttpUtils.RequestListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String imageUrl = UrlUtil.getImageUrl("/Images/AD/676e9491b6ae40a0baffafa0abd80d34_720_322.jpg");
        //绑定接口
        getAdvertItems();
    }

    private void getAdvertItems() {
        new HttpUtils(this);
        HttpUtils.getRequestData(UrlUtil.GetAdvertItems, 0);
    }


    @Override
    public void getData(String result) {
        LogUtil.i("TAG", "接口回调的数据" + result.toString());
        AdvertItem[] advertItem = GsonUtil.parseJsonToArray(result, new TypeToken<AdvertItem>() {
        });
        for (AdvertItem adver : advertItem) {
            String imgUrl = adver.getImgUrl();
            LogUtil.i("TAG", imgUrl + "我是解析的图片路径");
        }
    }
}
