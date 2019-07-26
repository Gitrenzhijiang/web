package com.survey.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.web.BaseServlet;
import com.survey.pojo.User;
import com.survey.service.UserService;
import com.survey.utils.CommonUtils;
import com.survey.utils.Result;
/**
 * 用户相关 请求处理
 * @author REN
 *
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
    /**
     * 登录
     * 
     * web层做 类似表单字段限制的检查
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String dologin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 将表单的内容， 封装到对象 实例中, 根据 表单name字段 填充到对象对应属性中
        User loginInfoUser = CommonUtils.toBean(req.getParameterMap(), User.class);
        System.out.println(loginInfoUser);
        Result result = userService.login(loginInfoUser);
        if (result.code() != 0) {
            //出错了
            // 打印错误消息
            System.out.println("msg:" + result.msg());
            
            return "f:/login.jsp";
        }
        // 登录成功 存储到session
        req.getSession().setAttribute("user", result.data());
        //  /WEB-INF/view/index.jsp 只能转发过去. 
        return ":/WEB-INF/view/index.jsp";
//        return "r:/WEB-INF/view/index.jsp"; // 错误
    }
    
    private UserService userService = new UserService();
}
