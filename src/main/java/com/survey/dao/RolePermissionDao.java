package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.RolePermission;

public interface RolePermissionDao {
	/**
	 * 根据role_id查询
	 * @return 返回List<RolePermission>
	 */
	@Select("select * from tb_role_permission where role_id=#{role_id}")
	public List<RolePermission> findById(Integer role_id);
	/**
	 * 查询表中所有关联信息
	 * @return 返回RolePermission集合
	 */
	@Select("select * from tb_role_permission")
	public List<RolePermission> findAll();
	/**
	 * 保存关联信息
	 * @param RolePermission
	 * @return integer
	 */
	@Insert("insert into tb_role_permission (role_id,permission_id) value(#{role_id},#{permission_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(RolePermission rolePermission);
	/**
	 * 修改关联信息
	 * @param RolePermission
	 * @return integer
	 */
	@Update("update tb_role_permission set name=#{name},permission_id=#{permission_id} where id=#{id}")
	public int upate(RolePermission rolePermission);
	/**
	 * 根据role_id 删除关联信息
	 * @param role_id
	 * @return integer
	 */
	@Delete("delete from tb_role_permission where role_id = #{role_id}")
	public int delete(Integer role_id);
}
