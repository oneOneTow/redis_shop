package com.vens.entitys.order;

import com.vens.enums.DeliverStatusType;

import java.math.BigDecimal;
import java.util.Date;

public class OrderGoods {
    private int id;
    private int orderId;
    private int skuId;
    private BigDecimal actualMoney;
    private DeliverStatusType deliverStatus;
    private String deliverMsg;
    private String elecInvoice;
    private String optioner;
    private Date dateUpdate;
    private Date dateCreate = new Date();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public DeliverStatusType getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(DeliverStatusType deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getDeliverMsg() {
        return deliverMsg;
    }

    public void setDeliverMsg(String deliverMsg) {
        this.deliverMsg = deliverMsg;
    }

    public String getElecInvoice() {
        return elecInvoice;
    }

    public void setElecInvoice(String elecInvoice) {
        this.elecInvoice = elecInvoice;
    }

    public String getOptioner() {
        return optioner;
    }

    public void setOptioner(String optioner) {
        this.optioner = optioner;
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
