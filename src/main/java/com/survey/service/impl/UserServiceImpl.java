package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.UserDao;
import com.survey.form.User;
import com.survey.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;
	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	@Override
	public int save(User user) {
		return userDao.save(user);
	}
	@Override
	public int update(User user) {
		return userDao.upate(user);
	}
	@Override
	public int delete(Integer id) {
		return userDao.delete(id);
	}

}
