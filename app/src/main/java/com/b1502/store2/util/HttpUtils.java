package com.b1502.store2.util;


import com.b1502.store2.model.StoreParams;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * 作者：郭传沛
 * 时间：2017/2/27:20:10
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class HttpUtils {
    public static RequestListener mRequestListener;

    public HttpUtils(RequestListener requestListener) {
        mRequestListener = requestListener;
    }

    //首页网络请求所用方法
    public static void getRequestData(String path, int pageIndex) {
        StoreParams params = new StoreParams(path, pageIndex);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(Callback.CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                LogUtil.i("TAG", result.toString());
                mRequestListener.getData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //其他网络请求所用方法
    public static void getRequestDataOther(String path) {
        StoreParams params = new StoreParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(Callback.CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                LogUtil.i("TAG", result.toString());
                mRequestListener.getData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public interface RequestListener {
        void getData(String result);
    }
}
