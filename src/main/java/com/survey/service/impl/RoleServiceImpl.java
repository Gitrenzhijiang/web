package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.RoleDao;
import com.survey.form.Role;
import com.survey.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	@Override
	public int save(Role role) {
		// TODO Auto-generated method stub
		return roleDao.save(role);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public int update(Role role) {
		// TODO Auto-generated method stub
		return roleDao.upate(role);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.delete(id);
	}

}
