package com.bh.test;

import static org.junit.Assert.assertTrue;

import com.bh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: 测试User类
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 11:02
 */
public class UserTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    //创建会话工厂
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 根据id查询用户信息
     */
    @Test
    public void testFindUserById() {
        //数据库连接对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //数据库对象实例化
            sqlSession=sqlSessionFactory.openSession();
            //查询单个记录 selectOne 查询一条记录，
            // 如果使用 selectOne 查询多条记录则抛出异常
            User user = sqlSession.selectOne("UserTest.findUserById",10);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                //关闭sqlSession
                sqlSession.close();
            }
        }
    }

    /**
     * 模糊查询--依赖用户名查询数据
     */
    @Test
    public void testFindUserByname() {
        //数据库查询对象
        SqlSession sqlSession = null;
        try {
            //对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //查询 selectList 可以查询一条或多条记录。
            List<User> list = sqlSession.selectList("UserTest.findUserByName","王");
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                //关闭sqlSession
                sqlSession.close();
            }
        }
    }

    /**
     * 添加用户信息
     */
    @Test
    public void testInsertUser() {
        //数据库查询对象
        SqlSession sqlSession = null;
        try {
            //对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //添加数据
            User user = new User();
            user.setUsername("杨新奇");
            user.setAddress("济南历城区");
            user.setSex("男");
            sqlSession.insert("UserTest.insertUser", user);
            //提交事物
            sqlSession.commit();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                //关闭sqlSession
                sqlSession.close();
            }
        }
    }


    /**
     * 删除用户信息
     */
    @Test
    public void testDelectUserById() {
        //数据库查询对象
        SqlSession sqlSession = null;
        try {
            //对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //删除用户
            sqlSession.delete("UserTest.deleteUserById",33);
            //提交事物
            sqlSession.commit();
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                //关闭sqlSession
                sqlSession.close();
            }
        }
    }

    /**
     * 修改用户信息
     */
    @Test
    public void testUpdateUser() {
        //数据库查询对象
        SqlSession sqlSession = null;
        try {
            //对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //修改数据
            User user = new User();
            user.setId(30);
            user.setUsername("李思思");
            sqlSession.update("UserTest.updateUser",user);
            //提交事物
            sqlSession.commit();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                //关闭sqlSession
                sqlSession.close();
            }
        }
    }
}
