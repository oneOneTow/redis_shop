package com.vens.shop.entitys.goods;

import java.util.Date;

public class GoodsSkuSpecValue {
    private int id;
    private int skuId;
    private int specValueId;
    private String operator;
    private Date dateUpdate;
    private Date dateCreate=new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(int specValueId) {
        this.specValueId = specValueId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
