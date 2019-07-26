/**
 * Servlet 通用父类
 * 如果需要上传, 不能使用这个父类, 应该继承HttpServlet
 * 
 * 通过传参KEY，调用相应处理方法
 * 
 * 继承这个抽象类的Servlet
 * 只需要写业务处理方法即可，用户访问时在参数中多加上method=xxx
 * 
 * 子类中的方法必须返回一个String
 * string:满足     r/R:path     重定向到path
 * f/F:path                 转发到 path
 * :path                    转发到 path
 * 
 * 路径以/ 开头, 相当于当前 http://localhost:8080/web
 */
package com.framework.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
    protected static String KEY = "method";

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 处理乱码问题
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        /**
         * 获取用户通过参数传过来的方法名 通过反射获取该方法 调用方法 如果方法的返回值满足要求，执行相应操作
         */
        String methodName = req.getParameter(KEY);
        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("传入的" + KEY + "参数出错");
        }
        Class c = this.getClass();
        Method m = null;
        try {
            m = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("方法:" + methodName + "(HttpServletRequest,HttpServletResponse)不存在");
        }
        String operate = null;
        try {
            operate = (String) m.invoke(this, req, res);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (operate == null || operate.trim().isEmpty())
            return;
        // 执行相应操作
        if (operate.contains(":")) {
            int index = operate.indexOf(":");
            String start = operate.substring(0, index);
            String end = operate.substring(index + 1);
            if (start.equalsIgnoreCase("") || start.equalsIgnoreCase("F")) {// 默认是转发
                req.getRequestDispatcher(end).forward(req, res);
            } else if (start.equalsIgnoreCase("r")) {// 重定向
                res.sendRedirect(req.getContextPath() + end);
            } else
                new RuntimeException("操作:" + start + "出错!");
        }
    }

}
