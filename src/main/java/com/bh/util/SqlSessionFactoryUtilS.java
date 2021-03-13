package com.bh.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: SqlSessionFactory封装类
 * @Author: WWT
 * @Date: 2021/3/10
 * @Time: 15:12
 */
public class SqlSessionFactoryUtilS {
    /**
     * 创建会话工厂
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建返回SqlSessionFactory
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
