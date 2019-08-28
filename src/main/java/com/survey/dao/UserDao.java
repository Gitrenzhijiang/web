package com.survey.dao;
/**
 * user数据库持久层
 * 
 * @author 18757
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.survey.form.User;
@Repository("userDao")
public interface UserDao {
	/**
	 * 根据id查询
	 * @return 返回user
	 */
	@Select("select * from tb_user where id=#{id}")
	public User findById(Integer id);
	/**
	 * 根据name查询
	 * @return 返回user
	 */
	@Select("select * from tb_user where name=#{name}")
	public User findByName(String name);
	/**
	 * 查询表中所有用户
	 * @return 返回user集合
	 */
	@Select("select * from tb_user")
	public List<User> findAll();
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	@Insert("insert into tb_user (name,password,email,real_name,role_id) value(#{name},#{password},#{email},#{real_name},#{role_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(User user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@Update("update tb_user set name=#{name},password=#{password},email=#{email},real_name=#{real_name},role_id=#{role_id} where id=#{id}")
	public int upate(User user);
	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	@Delete("delete from tb_user where id = #{id}")
	public int delete(Integer id);
}
