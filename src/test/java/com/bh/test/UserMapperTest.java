package com.bh.test;

import com.bh.mapper.UserMapper;
import com.bh.pojo.User;
import com.bh.pojo.UserCustom;
import com.bh.util.SqlSessionFactoryUtilS;
import com.bh.vo.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: UserMapper测试类
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 14:38
 */
public class UserMapperTest {
    /**
     * 根据id查询用户信息
     */
    @Test
    public void testFindUserById() {
        //获取session
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用代理对象方法
        User user = userMapper.findUserById(31);
        System.out.println(user);
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 模糊查询--依赖用户名查询数据
     */
    @Test
    public void testFindUserByname() {
        //数据库查询对象,对象实例化
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用代理对象方法 查询 selectList 可以查询一条或多条记录。
        //如果UserMapper sql语句查询中使用占位符号则必须人为在传参数中加%
        //List<User> list = userMapper.findUserByName("%王%");
        //如果使用${}原始符号则不用人为在参数中加%
        List<User> list = userMapper.findUserByName("王");
        System.out.println(list.size());
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 传递pojo对象综合查询用户信息
     */
    @Test
    public void testFindUserByUser() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //构造查询条件user对象
        User user = new User();
        user.setId(1);
        user.setUsername("王");
        //传递user对象查询用户列表
        List<User> list = userMapper.findUserByUser(user);
        System.out.println(list.size());
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 传递 pojo包装对象 用户综合信息查询用户列表
     * 用户信息综合查询即多条件查询
     */
    @Test
    public void testFindUserList(){
        //创建对象---获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        //在UserCustom类中继承User类
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("女");
        userCustom.setUsername("周涛");

        //传入多个id
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        ids.add(4);

        //将ids 通过UserQueryVo 传入statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        //调用方法完成多条件查询
        List<UserQueryVo> userList = userMapper.findUserList(userQueryVo);
        System.out.println(userList.size());
        System.out.println(userList);
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     *通过 pojo 传递 list
     */
    @Test
    public void testSelectUserByList() {
        //创建对象---获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);//查询id为1的用户
        ids.add(31);//查询id为31的用户
        //将ids 通过UserQueryVo 传入statement中
        userQueryVo.setIds(ids);

        //调用方法完成多条件查询
        List<User> list = userMapper.selectUserByList(userQueryVo);
        System.out.println(list);
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     *通过 pojo 传递单个 List
     */
    @Test
    public void testSelectUserByList1() {
        //创建对象---获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //构造查询条件
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        userList.add(user);
        user = new User();
        user.setId(2);
        userList.add(user);

        //传递userlist列表查询用户列表
        List<User> list = userMapper.selectUserByList1(userList);
        System.out.println(list);
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     *传递单个数组（数组中是 pojo）
     */
    @Test
    public void testSelectUserByArray() {
        //创建对象---获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //构造查询条件list
        Object[] userlist = new Object[2];
        /*User user = new User();
        user.setId(1);
        userlist[0]=user;
        user = new User();
        user.setId(2);
        userlist[1]=user;*/

        userlist[0]="1";
        userlist[1]="2";

        //传递User对象查询用户列表
        List<User> list = userMapper.selectUserByArray(userlist);
        System.out.println(list);
        //释放资源
        sqlSession.close();
    }


    /**
     * 传递 HashMap 综合查询用户信息
     */
    @Test
    public void testFindUserByHashMap() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //构造查询条件,即Map对象
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",31);
        map.put("username","周涛");

        //传递对象完成查询
        List<User> list = userMapper.findUserByHashMap(map);
        System.out.println(list.size());
        //释放资源,关闭sqlSession
        sqlSession.close();
    }

    /**
     * resultType(输出类型)
     * 输出简单类型
     */
    @Test
    public void testFindUserByCount() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper借口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //构造查询条件user对象
        User user = new User();
        user.setUsername("周涛");
        //传递对象完成查询
        int count = userMapper.findUserByCount(user);
        System.out.println(count);
        System.out.println(user);
        //释放sqlSession
        sqlSession.close();
    }

    /**
     * 根据 id 查询用户信息，使用 resultMap 输出
     */
    @Test
    public void testFindUserByIdResultMap() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper借口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法完成功能
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

    /**
     * 添加用户信息
     */
    @Test
    public void testInsertUser() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper借口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //要添加的数据
        User user = new User();
        user.setUsername("杨婷婷");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("济南市");
        //通过Mapper接口添加用户
        userMapper.insertUser(user);
        System.out.println(user);
        //提交
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }


    /**
     * 删除用户信息
     */
    @Test
    public void testDelectUserById() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper借口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //通过Mapper接口删除用户
        userMapper.deleteUserById(39);
        System.out.println("删除成功");
        //提交
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 修改用户信息
     */
    @Test
    public void testUpdateUser() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionFactoryUtilS.getSqlSessionFactory().openSession();
        //获取mapper借口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //要修改的数据
        User user = new User();
        user.setId(39);
        user.setUsername("杨文婷");
        //通过Mapper接口修改用户
        userMapper.updateUser(user);
        System.out.println(user);
        //提交事物
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }
}
