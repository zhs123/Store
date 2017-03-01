package com.b1502.store2.model;

import com.b1502.store2.util.UrlUtil;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 14:25
 */

public class Product {

    private String ApplicationId;
    private String CreateDateTime;
    private String Id;
    private String ImagePath;
    private double MemberPrice;
    private String Name;
    private double Price;
    private String ProductId;
    private String PromotionLabel;
    private String Unit;

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String ApplicationId) {
        this.ApplicationId = ApplicationId;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String CreateDateTime) {
        this.CreateDateTime = CreateDateTime;
    }

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

    public double getMemberPrice() {
        return MemberPrice;
    }

    public void setMemberPrice(double MemberPrice) {
        this.MemberPrice = MemberPrice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getPromotionLabel() {
        return PromotionLabel;
    }

    public void setPromotionLabel(String PromotionLabel) {
        this.PromotionLabel = PromotionLabel;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getImgUrl() {
        return UrlUtil.getImageUrl(ImagePath);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ApplicationId='" + ApplicationId + '\'' +
                ", CreateDateTime='" + CreateDateTime + '\'' +
                ", Id='" + Id + '\'' +
                ", ImagePath='" + ImagePath + '\'' +
                ", MemberPrice=" + MemberPrice +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", ProductId='" + ProductId + '\'' +
                ", PromotionLabel='" + PromotionLabel + '\'' +
                ", Unit='" + Unit + '\'' +
                '}';
    }
}

