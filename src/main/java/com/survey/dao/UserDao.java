package com.survey.dao;

import java.util.List;

import com.ren.jdbc.core.SqlSession;
import com.survey.pojo.User;
import com.survey.utils.SqlSessionFactoryUtil;

public class UserDao {
    /**
     * 根据用户名查询 
     * 不存在返回null
     * @param name
     * @return
     */
    public User findByName(String name) {
        // 获得一个sqlsession 对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSessionFactory().openSession();
        // 中间的条件，格式是:
        // tb_user 的字段名称 = ? and 下一个字段 = ? 
        List<User> findUserList = sqlSession.selectList(User.class, "name= ? ", name);
        if (findUserList.isEmpty()) {
            return null;
        } else {
            return findUserList.get(0);
        }
    }
}
