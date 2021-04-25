package com.example.rentclothes.entity;

public class ShopCartItem {
    private int id;
    private String imageUrl;
    private String money;
    private String goods;

    public ShopCartItem(String imageUrl,String money,String goods){
        this.imageUrl = imageUrl;
        this.money = money;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}
