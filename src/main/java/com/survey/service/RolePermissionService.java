package com.survey.service;

import java.util.List;

import com.survey.form.RolePermission;

public interface RolePermissionService {
	public int save(RolePermission rolePermission);
	/**
	 * 根据role_id查询
	 * @return 返回RolePermission
	 */
	public List<RolePermission> findById(Integer role_id);
	public List<RolePermission> findAll();
	public int update(RolePermission rolePermission);
	/**
	 * 根据role_id 删除关联信息
	 * @param RolePermission
	 * @return integer
	 */
	public int delete(Integer role_id);
}
