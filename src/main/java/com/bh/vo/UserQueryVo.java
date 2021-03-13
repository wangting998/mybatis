package com.bh.vo;

import com.bh.pojo.User;
import com.bh.pojo.UserCustom;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @Description: 传递 pojo 包装对象
 *          首先先定义UserQueryVo包装对象
 *          定义包装对象将查询条件(pojo)以类组合的方式进行包
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 18:03
 */
public class UserQueryVo {
    //传入多个用户id
    private List<Integer> ids;
    private User user;

    //自定义用户扩展类   查询条件----包装所有的查询条件
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
