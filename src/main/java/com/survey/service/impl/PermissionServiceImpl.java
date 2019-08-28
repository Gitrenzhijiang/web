package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.PermissionDao;
import com.survey.form.Permission;
import com.survey.service.PermissionService;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	@Resource(name = "permissionDao")
	private PermissionDao permissionDao;
	@Override
	public int save(Permission permission) {
		// TODO Auto-generated method stub
		return permissionDao.save(permission);
	}

	@Override
	public Permission findById(Integer id) {
		// TODO Auto-generated method stub
		return permissionDao.findById(id);
	}

	@Override
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return permissionDao.findAll();
	}

	@Override
	public int update(Permission permission) {
		// TODO Auto-generated method stub
		return permissionDao.upate(permission);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return permissionDao.delete(id);
	}

}
