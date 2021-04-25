package com.example.rentclothes.entity;

import org.litepal.crud.DataSupport;

public class HomeMvItem  extends DataSupport{
    private int id;
    private String imageUrl;//还没有点击时候显示的图片地址
    private String mvUrl;//视频地址
    private int lookNumber;//点击人数
    private String typeName;//类型名称
    private String typeId;//类型id
    private String mvLabel;//视频标签

    public String getMvLabel() {
        return mvLabel;
    }

    public void setMvLabel(String mvLabel) {
        this.mvLabel = mvLabel;
    }

    public HomeMvItem(String imageUrl, String mvUrl, int lookNumber, String typeName, String typeId,String mvLabel){
        this.imageUrl= imageUrl;
        this.mvUrl= mvUrl;
        this.lookNumber= lookNumber;
        this.typeName= typeName;
        this.typeId= typeId;
        this.mvLabel = mvLabel;
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

    public String getMvUrl() {
        return mvUrl;
    }

    public void setMvUrl(String mvUrl) {
        this.mvUrl = mvUrl;
    }

    public int getLookNumber() {
        return lookNumber;
    }

    public void setLookNumber(int lookNumber) {
        this.lookNumber = lookNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }


}
