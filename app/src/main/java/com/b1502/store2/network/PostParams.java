package com.b1502.store2.network;

/**
 * 1. POST参数
 * 2. @author：liqingyi
 * 3. @date：2017/2/28 10:46
 */

public class PostParams {
    //产品ID
    public String productId;

    //购买商品数量
    public int count;

    public String[] productIds;
    public int[] quantities;

    public String orderId;
    public String remark;
    public String invoice;

    public PostParams() {

    }

    public PostParams(String[] productIds) {
        this.productIds = productIds;
    }

    public PostParams(String[] productIds, int[] quantities) {
        this.productIds = productIds;
        this.quantities = quantities;
    }

    public PostParams(int count, String productId) {
        this.count = count;
        this.productId = productId;
    }

    public PostParams(String orderId, String remark, String invoice) {
        this.remark = remark;
        this.invoice = invoice;
        this.orderId = orderId;
    }
}
