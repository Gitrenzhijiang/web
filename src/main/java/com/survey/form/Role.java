package com.survey.form;

/**
 * 对应数据库 tb_role表 
 * @author 18757
 *
 */

public class Role {
	private Integer  id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
}
