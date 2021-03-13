package com.bh.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Description: 订单表 用来实现一对一查询
 * @Author: WWT
 * @Date: 2021/3/11
 * @Time: 16:08
 */
public class Orders {
    private int id; //订单id
    private int userId; //用户id
    private String number; // 订单数量
    private Date createtime; // 创建时间
    private String note; // 订单记录

    //注入User类
    private User user;

    private List<Orderdetail> orderdetails;

    public Orders() {

    }

    public Orders(int id, int userId, String number, Date createtime, String note, User user, List<Orderdetail> orderdetails) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.createtime = createtime;
        this.note = note;
        this.user = user;
        this.orderdetails = orderdetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", orderDetails=" + orderdetails +
                '}';
    }
}
