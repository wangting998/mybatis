package com.bh.pojo;

/**
 * @Description: OrdersCustom 类继承 Orders 类后
 *              OrdersCustom 类包括了 Orders 类的所有字段，
 *              只需要定义用户的信息字段即可
 * @Author: WWT
 * @Date: 2021/3/11
 * @Time: 16:14
 */
public class OrdersCustom extends Orders{
    private String username; //用户名称
    private String address;; //用户地址


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                super.toString() +
                '}';
    }
}

