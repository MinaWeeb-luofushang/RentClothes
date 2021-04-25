package com.example.rentclothes.entity;

import org.litepal.crud.DataSupport;

public class SortRightItem extends DataSupport {
    private int id;
    private String imageUrl; //图片地址
    private String  sortId;//类型Id
    private String sortImgId;//该图片的详情
    private String sortLabel;//该图片的票签

    public SortRightItem(String imageUrl, String sortId,String sortImgId, String sortLabel){
        this.imageUrl= imageUrl;
        this.sortId= sortId;
        this.sortLabel= sortImgId;
        this.sortLabel= sortLabel;
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

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortImgId() {
        return sortImgId;
    }

    public void setSortImgId(String sortImgId) {
        this.sortImgId = sortImgId;
    }

    public String getSortLabel() {
        return sortLabel;
    }

    public void setSortLabel(String sortLabel) {
        this.sortLabel = sortLabel;
    }
}
