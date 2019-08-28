package com.survey.form;
/**
 * 对应数据库tb_permission表
 * @author 18757
 *
 */
public class Permission {
	private Integer id;
	private String name;
	public Integer getId() {
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
		return "Permission [id=" + id + ", name=" + name + "]";
	}
	
}
