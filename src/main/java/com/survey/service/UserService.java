package com.survey.service;

import java.util.List;

import com.survey.form.User;

public interface UserService {
	public int save(User user);
	public User findById(Integer id);
	public User findByName(String name);
	public List<User> findAll();
	public int update(User user);
	public int delete(Integer id);
}
