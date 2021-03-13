package com.bh.test;

import com.bh.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 测试Person类，UUID
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 11:02
 */
public class PersonTest {
    //会话工厂
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
     * 添加数据--uuid 生成主键
     */
    @Test
    public void testInsertPersonUUID() {
        //数据库查询对象
        SqlSession sqlSession = null;
        try {
            //对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //添加数据
            Person person = new Person();
            person.setUsername("杨新奇");
            person.setAddress("济南历城区");
            person.setSex("男");
            sqlSession.insert("PersonTest.insertPersonUUID", person);
            //提交事物
            sqlSession.commit();
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
