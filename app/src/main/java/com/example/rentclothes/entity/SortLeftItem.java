package com.example.rentclothes.entity;

public class SortLeftItem {
    private int id;
    private String showTx;//显示的文本
    private String typeName;//类型名称
    private String typeId;//类型id

    public SortLeftItem(String showTx, String typeName,String typeId){
        this.showTx= showTx;
        this.typeName= typeName;
        this.typeId= typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowTx() {
        return showTx;
    }

    public void setShowTx(String showTx) {
        this.showTx = showTx;
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
