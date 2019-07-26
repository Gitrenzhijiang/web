package com.survey.service;

import com.survey.dao.UserDao;
import com.survey.pojo.User;
import com.survey.utils.Result;

public class UserService {
    
    private UserDao userDao = new UserDao();
    /**
     * 登录 
     * 
     * 服务层 做关于逻辑的检查, 即不存在的用户名等等
     * 
     * 返回的Result
     * code = 1 出错
     * code = 0, 成功
     * @param user
     * @return
     */
    public Result login(User user) {
        
        User find = userDao.findByName(user.getName());
        
        if (find == null) {
            return Result.of().code(1).message("不存在的用户名");
        }
        if (find.getPassword().equals(user.getPassword())) {
            // login success
            return Result.of().code(0).data(find);
        } else {
            return Result.of().code(1).message("密码错误");
        }
    }
}
