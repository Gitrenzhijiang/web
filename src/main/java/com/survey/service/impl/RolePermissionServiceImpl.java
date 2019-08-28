package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.RolePermissionDao;
import com.survey.form.RolePermission;
import com.survey.service.RolePermissionService;
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService{
	@Resource(name = "rolePermissionDao")
	private RolePermissionDao rolePermissionDao;
	@Override
	public int save(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return rolePermissionDao.save(rolePermission);
	}

	@Override
	public List<RolePermission> findById(Integer role_id) {
		// TODO Auto-generated method stub
		return rolePermissionDao.findById(role_id);
	}

	@Override
	public List<RolePermission> findAll() {
		// TODO Auto-generated method stub
		return rolePermissionDao.findAll();
	}

	@Override
	public int update(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return rolePermissionDao.upate(rolePermission);
	}

	@Override
	public int delete(Integer role_id) {
		// TODO Auto-generated method stub
		return rolePermissionDao.delete(role_id);
	}

}
