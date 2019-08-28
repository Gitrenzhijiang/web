package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.Permission;

public interface PermissionDao {
	/**
	 * 根据id查询
	 * @return 返回Permission
	 */
	@Select("select * from tb_permission where id=#{id}")
	public Permission findById(Integer id);
	/**
	 * 查询表中所有权限
	 * @return 返回Permission集合
	 */
	@Select("select * from tb_permission")
	public List<Permission> findAll();
	/**
	 * 保存权限信息
	 * @param Permission
	 * @return integer
	 */
	@Insert("insert into tb_permission (name) value(#{name})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(Permission permission);
	/**
	 * 修改权限信息
	 * @param Permission
	 * @return integer
	 */
	@Update("update tb_permission set name=#{name} where id=#{id}")
	public int upate(Permission permission);
	/**
	 * 删除权限信息
	 * @param Permission
	 * @return integer
	 */
	@Delete("delete from tb_permission where id = #{id}")
	public int delete(Integer id);
}
