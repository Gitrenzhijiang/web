package com.survey.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.survey.form.Questionnaire;
import com.survey.form.User;
import com.survey.service.QuestionnaireService;
import com.survey.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "questionnaireService")
	private QuestionnaireService questionnaireService;
	
	@RequestMapping("/check")
	public String check(String name,String password,HttpServletRequest request) {
		User user = userService.findByName(name);
		if (user!=null&&password.equals(user.getPassword())) {
			List<Questionnaire> questionnaires = questionnaireService.findByPublish(1);
			request.setAttribute("mainList", questionnaires);
			request.getSession().setAttribute("user", user);
			return "index";
		}
		request.setAttribute("msg","用户名或密码输入错误");
		return "forward:/login.jsp";
	}
	
	@RequestMapping("/register")
	public String register(User user,HttpServletRequest request) {
		int a=userService.save(user);
		if (a==1) {
			request.setAttribute("msg","注册成功请登录");
			return "forward:/login.jsp";
		}else {
			request.setAttribute("msg","注册失败");
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("toIndex")
	public String toIndex(HttpServletRequest request) {
		List<Questionnaire> questionnaires = questionnaireService.findByPublish(1);
		request.setAttribute("mainList", questionnaires);
		return "index";
	}
}
