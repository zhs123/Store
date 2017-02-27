package com.b1502.store2.bean;

/**
 * 作者： 张贤伟
 * 时间： 2017/2/27 20:33
 * 类描述：商品分类bean类
 */
public class CategoryBean {

    /**
     * Id : 75d3a5d9-9915-4896-8dd8-935ca6c7045e
     * ImagePath : /Images/Shopping/d61dcf32552442b79b7c8e89558fbb74_100_100.jpeg
     * Name : 营养保健
     * Remark : 营养保健
     */

    private String Id;
    private String ImagePath;
    private String Name;
    private String Remark;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }
}
