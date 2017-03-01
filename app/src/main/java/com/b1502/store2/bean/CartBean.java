package com.b1502.store2.bean;

/**
 * 项目名称：Store
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/2/28 8:20
 * 修改人：${丁江楠}
 * 修改时间：2017/2/28 8:20
 * 修改备注：
 */
public class CartBean {

    /**
     * Id : d364b422-6fd7-4c32-80e4-74c13cb71363
     * ProductId : 205338e7-33de-46aa-ad79-4ac56dfdc9ef
     * Count : 1
     * ImageUrl : /Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg
     * Name : 合禾果枇杷蜜
     * Price : 68.0
     * Unit : 300g
     * Amount : 68.0
     * Selected : true
     * IsGiven : false
     * Remark : null
     * Score : null
     */
    private int Id2;
    private String Id;
    private String ProductId;
    private int Count;
    private String ImageUrl;
    private String Name;
    private double Price;
    private String Unit;
    private double Amount;
    private boolean Selected;
    private boolean IsGiven;
    private Object Remark;
    private Object Score;
    private boolean isCheck;

    public int getId2() {
        return Id2;
    }

    public void setId2(int id2) {
        Id2 = id2;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public CartBean() {
    }

    public CartBean(String imageUrl, String name, double price) {
        ImageUrl = imageUrl;
        Name = name;
        Price = price;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "Id='" + Id + '\'' +
                ", ProductId='" + ProductId + '\'' +
                ", Count=" + Count +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Unit='" + Unit + '\'' +
                ", Amount=" + Amount +
                ", Selected=" + Selected +
                ", IsGiven=" + IsGiven +
                ", Remark=" + Remark +
                ", Score=" + Score +
                '}';
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
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

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean Selected) {
        this.Selected = Selected;
    }

    public boolean isIsGiven() {
        return IsGiven;
    }

    public void setIsGiven(boolean IsGiven) {
        this.IsGiven = IsGiven;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public Object getScore() {
        return Score;
    }

    public void setScore(Object Score) {
        this.Score = Score;
    }
}
