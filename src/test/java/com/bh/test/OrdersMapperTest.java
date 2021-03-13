package com.bh.test;

import com.bh.mapper.OrdersMapper;
import com.bh.mapper.UserMapper;
import com.bh.pojo.Orderdetail;
import com.bh.pojo.Orders;
import com.bh.pojo.OrdersCustom;
import com.bh.pojo.User;
import com.bh.util.SqlSessionFactoryUtilS;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description: 订单接口测试类
 * @Author: WWT
 * @Date: 2021/3/11
 * @Time: 16:25
 */
public class OrdersMapperTest {
    /**
     * 一对一查询 查询所有订单
     */
    @Test
    public void testFindOrdersList() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        //调用方法完成功能
        List<OrdersCustom> ordersList = ordersMapper.findOrdersList();
        System.out.println(ordersList);
        //释放资源
        sqlSession.close();
    }




    /**
     * 一对一查询 查询所有订单 使用 resultMap
     */
    @Test
    public void testFindOrderListResultMap() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        //调用方法完成功能
        List<Orders> ordersListResultMap = ordersMapper.findOrderListResultMap();
        System.out.println(ordersListResultMap.size());
        System.out.println(ordersListResultMap);
        //释放资源
        sqlSession.close();
    }

    /**
     * 一对多查询 查询订单及订单下的详情信息
     */
    @Test
    public void testFindOrdersDetailList() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        //调用方法完成功能
        List<Orderdetail> ordersDetailList = mapper.findOrdersDetailList();
        System.out.println(ordersDetailList.size());
        System.out.println(ordersDetailList);
        //释放资源
        sqlSession.close();
    }

    /**
     * 多对多查询 查询用户所有信息数据
     */
    @Test
    public void testFindUserOrderListResultMap() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        //调用方法完成功能
        List<Orders> ordersList = mapper.findUserOrderListResultMap();
        System.out.println(ordersList.size());
        System.out.println(ordersList);
        //释放资源
        sqlSession.close();
    }


    /**
     * 一级缓存  测试 1
     */
    /*@Test
    public void testFindUserById() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次查询
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);
        //第二次查询，由于是同一个sqlSession则不再向数据发出语句直接从缓存取出
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);
        //释放资源
        sqlSession.close();
    }*/

    /**
     * 一级缓存  测试 2
     */
    @Test
    public void testFindUserById() {
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次查询
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);
        //在同一个sqlSession执行更新
        User user_update = new User();
        user_update.setId(1);
        user_update.setUsername("李四");
        System.out.println(user_update);
        sqlSession.commit();

        /**
         * 第二次查询，虽然是同一个sqlSession
         * 但是由于执行了更新操作session的缓存被清空，
         * 这里重新发出sql操作
         */
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);
        //释放资源
        sqlSession.close();
    }

    // 一对一查询延迟加载
    @Test
    public void testFindOrderUserListLazyLoading(){
        //获取sqlsession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取接口对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> list = ordersMapper.findOrderListResultMap();
        User user = list.get(0).getUser();
        System.out.println(user);
    }
}
