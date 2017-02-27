package com.b1502.store2.model;

import com.b1502.store2.Config;
import com.b1502.store2.util.UrlUtil;

import org.xutils.http.RequestParams;

/**
 * 1. 网络请求参数
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 13:20
 */

public class StoreParams extends RequestParams {

    public StoreParams(String uri, int pageIndex){
        super(UrlUtil.getAPIUrl(uri,pageIndex));
        init();
    }

    public StoreParams(String uri) {
        super(UrlUtil.getAPIUrl(uri));
        init();
    }

    private void init(){
        setConnectTimeout(1000 * 60);
        setHeader("application-token", Config.APP_TOKEN);
        setHeader("user-token", Config.USER_TOKEN);
        setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36");

    }
}
