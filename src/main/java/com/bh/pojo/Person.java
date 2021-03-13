package com.bh.pojo;

import java.util.Date;

/**
 * @Description: Person实体类，测试UUID
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 10:56
 */
public class Person {
    private String id; //用户id
    private String username; // 用户名
    private String sex; // 性别
    private String address; // 住址

    public Person() {

    }

    public Person(String id, String username, String sex, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
