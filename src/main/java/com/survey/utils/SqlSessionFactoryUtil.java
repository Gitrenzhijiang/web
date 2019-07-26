package com.survey.utils;

import com.ren.jdbc.core.SqlSessionFactory;
import com.ren.jdbc.core.SqlSessionFactoryBuilder;
/**
 * 单例工具类, 保证一个 应用  只有一个 SqlSessionFactory.
 * @author REN
 */
public class SqlSessionFactoryUtil {
    private SqlSessionFactoryUtil() {}
    /**
     * 获取 SqlSessionFactory 工厂对象, 用于创建 SqlSession 
     * 一个SqlSession 代表一个与数据库的 会话连接, 它提供了便捷的面向对象的方式访问数据库. 
     * @return
     */
    public static SqlSessionFactory getSessionFactory() {
        return Inner.ssf;
    }
    
    private static class Inner {
        @SuppressWarnings("static-access")
        final static SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                .build("MyRatis.properties");
    }
}
