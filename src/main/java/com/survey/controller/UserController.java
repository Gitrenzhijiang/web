package com.survey.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.survey.form.Role;
import com.survey.form.User;
import com.survey.service.RoleService;
import com.survey.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@RequestMapping("/toUser")
	public String toUser(HttpServletRequest request) {
		List<User> users = userService.findAll();
		List<Role> roles = roleService.findAll();
		request.setAttribute("users", users);
		request.setAttribute("roles", roles);
		return "sys/user";
	}
	
	@RequestMapping("/deleteUser")
	public void deleteUser(Integer id,HttpServletResponse response) throws Exception {
		int a=userService.delete(id);
		response.getWriter().println(a);
	}
	
	@RequestMapping("/setRole")
	public void setRole(Integer userid,Integer roleid,HttpServletResponse response) throws Exception {
		User user = userService.findById(userid);
		user.setRole_id(roleid);
		int a=userService.update(user);
		System.out.println(a);
		response.getWriter().println(a);
	}
	
}
