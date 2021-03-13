package com.bh.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Description:用户类;类是 mybatis 进行 sql 映射，通常与数据库表中字段对应
 * @Author: WWT
 * @Date: 2021/3/9
 * @Time: 17:42
 */
public class User {
    private int id; //用户id
    private String username; // 用户名
    private String sex; // 性别
    private Date birthday; // 出生日期
    private String address; // 住址

    //注入Orders表
    private List<Orders> orders;

    public User() {
    }

    public User(int id, String username, String sex, Date birthday, String address, List<Orders> orders) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
