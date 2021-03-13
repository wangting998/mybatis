package com.bh.mapper;

import com.bh.pojo.User;
import com.bh.vo.UserQueryVo;

import java.util.List;
import java.util.Map;

/**
 * @Description: 定义UserMapper接口, 用户管理mapper
 *          Mapper 接口方法名和 Mapper.xml 中定义的 statement 的 id 相同
 *          Mapper 接口方法的输入参数类型和 mapper.xml 中定义的 statement 的 parameterType 的类型相同
 *          Mapper 接口方法的输出参数类型和 mapper.xml 中定义的 statement 的 resultType 的类型相同
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 14:14
 */
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     */
    public User findUserById(int id);

    /**
     * 查询用户列表
     */
    public List<User> findUserByName(String username);

    /**
     * 传递pojo对象综合查询用户信息
     * @return
     */
    public List<User> findUserByUser(User user);

    /**
     * 传递 pojo 包装对象 用户综合信息查询用户列表
     */
    public List<UserQueryVo> findUserList(UserQueryVo userQueryVo);

    /**
     * 通过 pojo 传递 list
     * @param userQueryVo
     * @return
     */
    public List<User> selectUserByList(UserQueryVo userQueryVo);
    /**
     * 传递单个List
     */
    public List<User> selectUserByList1(List userlist);


    /**
     * 传递单个数组（数组中是 pojo）
     */
    public  List<User> selectUserByArray(Object[] userList);

    /**
     * 传递 HashMap 综合查询用户信息
     */
    public List<User> findUserByHashMap(Map map);

    /**
     * resultType(输出类型)
     * 输出简单类型
     */
    public int findUserByCount(User user);

    /**
     * 根据 id 查询用户信息，使用 resultMap 输出
     */
    public User findUserByIdResultMap(int id);


    /**
     * 添加用户信息
     */
    public void insertUser(User user);

    /**
     * 删除用户信息
     */
    public void deleteUserById(int id);

    /**
     * 修改用户信息
     */
    public void updateUser(User user);
}
