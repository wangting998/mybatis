package com.bh.pojo;

import java.util.Date;

/**
 * @Description: 订单详情类
 * @Author: WWT
 * @Date: 2021/3/11
 * @Time: 17:12
 */
public class Orderdetail {
    private int id; //订单详情id
    private int ordersId; //订单id
    private int itemsId; // 物品id
    private int itemsNum; // 物品数量

    private Items items;

    public Orderdetail() {

    }

    public Orderdetail(int id, int ordersId, int itemsId, int itemsNum, Items items) {
        this.id = id;
        this.ordersId = ordersId;
        this.itemsId = itemsId;
        this.itemsNum = itemsNum;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public int getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(int itemsNum) {
        this.itemsNum = itemsNum;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                ", items=" + items +
                '}';
    }
}
