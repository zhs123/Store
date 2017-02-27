package com.b1502.store2.util;

import com.b1502.store2.Config;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/26 13:30
 *
 * 11111
 * 111111
 */

public class UrlUtil {

    /**
     * 获取图片地址
     * @param url
     * @return
     */
    public static String getImageUrl(String url) {
        return String.format("%1$s%2$s?application-token=%3$s&storeId=%4$s",
                Config.IMAGE_URL,
                url,
                Config.APP_TOKEN,
                Config.STORE_ID);
    }

    /**
     * 获取URL
     * @param url
     * @return
     */
    public static String getAPIUrl(String url) {
        return String.format("%1$s%2$s?storeId=%3$s", Config.API_URL, url, Config.STORE_ID);
    }

    /**
     * 分页
     * @param url
     * @param pageIndex
     * @return
     */
    public static String getAPIUrl(String url, int pageIndex) {
        return String.format("%1$s%2$s?storeId=%3$s&pageIndex=%4$s", Config.API_URL, url, Config.STORE_ID, pageIndex);
    }

    //首页广告轮播图
    public static final String GetAdvertItems = "/Site/Home/GetAdvertItems";

    //首页产品列表
    public static final String GetHomeProducts = "/Site/Home/GetHomeProducts";

    //产品信息
    public static final String GetProduct = "/Shop/Product/GetProduct";

    //分类列表
    public static final String GetCategories = "/Shop/Product/GetCategories";

    //分类信息
    public static final String GetCategory = "/Shop/Product/GetCategory";

    //购物车
    public static final String GetItems = "/Shop/ShoppingCart/GetItems";

    //微资讯
    public static final String GetNewsList = "/Site/Info/GetNewsList";

    //资讯详情
    public static final String GetNews = "/Site/Info/GetNews";
}
