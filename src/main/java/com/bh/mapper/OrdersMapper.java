package com.bh.mapper;

import com.bh.pojo.Orderdetail;
import com.bh.pojo.Orders;
import com.bh.pojo.OrdersCustom;

import java.util.List;

/**
 * @Description: 定义OrdersMapper订单接口,
 * @Author: WWT
 * @Date: 2021/3/11
 * @Time: 16:18
 */
public interface OrdersMapper {
    /**
     * 一对一 查询所有订单
     */
    public List<OrdersCustom> findOrdersList();

    /**
     * 一对一 查询所有订单 使用 resultMap
     */
    public List<Orders> findOrderListResultMap();

    /**
     * 一对多查询 查询订单及订单下的详情信息
     */
    public List<Orderdetail> findOrdersDetailList();

    /**
     * 多对多查询 查询用户所有信息数据
     */
    public List<Orders> findUserOrderListResultMap();
}
