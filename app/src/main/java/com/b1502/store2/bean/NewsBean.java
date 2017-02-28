package com.b1502.store2.bean;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/2/28
 */


public class NewsBean {


    /**
     * Id : 648cf203-16f0-4603-b291-40864c472356
     * Title : 全球最漂亮餐食
     * ImgUrl : /ueditor/net/upload/image/20150303/6356099710908496093909191_243_211.png
     * CreateDateTime : /Date(1425371823800)/
     */

    private String Id;
    private String Title;
    private String ImgUrl;
    private String CreateDateTime;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String CreateDateTime) {
        this.CreateDateTime = CreateDateTime;
    }
}
