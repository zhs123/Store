package com.b1502.store2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b1502.store2.R;
import com.b1502.store2.model.AdvertItem;
import com.b1502.store2.util.GsonUtil;
import com.b1502.store2.util.HttpUtils;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;

//首页
public class HomeFragment extends BaseFragment implements HttpUtils.RequestListener {

    private Gson mGson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String imageUrl = UrlUtil.getImageUrl("/Images/AD/676e9491b6ae40a0baffafa0abd80d34_720_322.jpg");
        LogUtil.i("TAG", "图片路径" + imageUrl);
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
        List<AdvertItem> advertItems = GsonUtil.parseJsonToArray(result, new TypeToken<List<AdvertItem>>() {
        });
        LogUtil.i("TAG", "哈哈哈" + advertItems.toString());
    }
}
