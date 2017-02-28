package com.b1502.store2.util;

import android.text.TextUtils;

import com.b1502.store2.Config;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/26 13:30
 * <p>
 * 11111
 * 111111
 */

public class UrlUtil {

    /**
     * 获取图片地址
     *
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
     *
     * @param url
     * @return
     */
    public static String getAPIUrl(String url) {
        return String.format("%1$s%2$s?storeId=%3$s", Config.API_URL, url, Config.STORE_ID);
    }

    /**
     * 分页
     *
     * @param url
     * @param pageIndex
     * @return
     */
    public static String getAPIUrl(String url, int pageIndex) {
        return String.format("%1$s%2$s?storeId=%3$s&pageIndex=%4$s", Config.API_URL, url, Config.STORE_ID, pageIndex);
    }

    /**
     * @param url
     * @param params "newsId"
     * @param newsId "648cf203-16f0-4603-b291-40864c472356"
     * @return
     */
    public static String getAPIUrl(String url, String params, String newsId) {
        return String.format("%1$s%2$s?storeId=%3$s&%4$s=%5$s", Config.API_URL, url, Config.STORE_ID, params, newsId);
    }

    /**
     * 根据产品分类过滤
     *
     * @param url
     * @param id
     * @param startRowIndex 开始索引
     * @return
     */
    public static String getAPIUrl(String url, String id, int startRowIndex) {
        String filter = String.format("ProductCategoryId=Guid.Parse('%1$s')", id);
        return String.format("%1$s%2$s?storeId=%3$s&startRowIndex=%4$s&filter=%5$s", Config.API_URL, url, Config.STORE_ID, startRowIndex, filter);
    }

    /**
     * @param url
     * @param startRowIndex 开始索引
     * @param maximumRows   每次请求数目
     * @param status
     * @return
     */
    public static String getAPIUrl(String url, int startRowIndex, int maximumRows, String status) {
        if (TextUtils.isEmpty(status)) {
            return String.format("%1$s%2$s?storeId=%3$s&startRowIndex=%4$s&maximumRows=%5$s",
                    Config.API_URL, url, Config.STORE_ID, startRowIndex, maximumRows);
        } else {
            String filter = String.format("Status=\"%1$s\"", status);
            return String.format("%1$s%2$s?storeId=%3$s&startRowIndex=%4$s&maximumRows=%5$s&filter=%6$s",
                    Config.API_URL, url, Config.STORE_ID, startRowIndex, maximumRows, filter);
        }
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

    //根据分类ID过滤产品
    public static final String GetProducts = "/Shop/Product/GetProducts";

    //加入购物车 POST
    public static final String AddItem = "/Shop/ShoppingCart/AddItem";

    //购物车
    public static final String GetItems = "/Shop/ShoppingCart/GetItems";

    //微资讯
    public static final String GetNewsList = "/Site/Info/GetNewsList";

    //资讯详情
    public static final String GetNews = "/Site/Info/GetNews";
}
