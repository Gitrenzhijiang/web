package com.survey.service;

import java.util.List;

import com.survey.form.Role;

public interface RoleService {
	public int save(Role role);
	public Role findById(Integer id);
	public List<Role> findAll();
	public int update(Role role);
	public int delete(Integer id);
}
