package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.Role;
public interface RoleDao {
	/**
	 * 根据id查询
	 * @return 返回Role
	 */
	@Select("select * from tb_role where id=#{id}")
	public Role findById(Integer id);
	/**
	 * 查询表中所有角色
	 * @return 返回Role集合
	 */
	@Select("select * from tb_role")
	public List<Role> findAll();
	/**
	 * 保存角色信息
	 * @param Role
	 * @return Integer
	 */
	@Insert("insert into tb_role (name) value(#{name})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(Role role);
	/**
	 * 修改角色信息
	 * @param Role
	 * @return Integer
	 */
	@Update("update tb_role set name=#{name} where id=#{id}")
	public int upate(Role role);
	/**
	 * 删除角色信息
	 * @param Role
	 * @return Integer
	 */
	@Delete("delete from tb_role where id = #{id}")
	public int delete(Integer id);
}
