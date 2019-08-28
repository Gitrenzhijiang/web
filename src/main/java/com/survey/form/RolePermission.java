package com.survey.form;

/**
 * 对应 tb_role_permission 
 * 关联表
 * @author 18757
 *
 */
public class RolePermission {
	private Integer id;
	private Integer role_id ;
	private Integer permission_id ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", role_id=" + role_id + ", permission_id=" + permission_id + "]";
	}
	public RolePermission() {
		super();
	}
	public RolePermission(Integer role_id, Integer permission_id) {
		super();
		this.role_id = role_id;
		this.permission_id = permission_id;
	}
	
	
    
}
