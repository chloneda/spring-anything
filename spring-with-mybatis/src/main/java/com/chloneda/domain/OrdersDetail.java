package com.chloneda.domain;

/**
 * Created by chloneda
 * Description:订单详情
 */
public class OrdersDetail {
    private int id;
    private int orderId;
    private int itemsId;
    private Items items;//一条订单明细包括一条商品信息

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

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

}
