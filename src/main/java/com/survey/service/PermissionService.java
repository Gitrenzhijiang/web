package com.survey.service;

import java.util.List;

import com.survey.form.Permission;

public interface PermissionService {
	public int save(Permission permission);
	public Permission findById(Integer id);
	public List<Permission> findAll();
	public int update(Permission permission);
	public int delete(Integer id);
}
