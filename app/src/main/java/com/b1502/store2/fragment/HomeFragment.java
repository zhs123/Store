package com.b1502.store2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.b1502.store2.R;
import com.b1502.store2.model.StoreParams;
import com.b1502.store2.util.HttpUtils;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;

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
        //绑定接口
        new HttpUtils(this);
        getAdvertItems();
        HttpUtils.getRequestData(UrlUtil.GetAdvertItems, 0);
    }

    private void getAdvertItems() {

    }


    @Override
    public void getData(String result) {
        LogUtil.i("TAG", "接口回调的数据" + result.toString());
        Toast.makeText(getContext(), "走了", Toast.LENGTH_SHORT).show();
    }
}
