package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.Questionnaire;

public interface QuestionnaireDao {
	/**
	 * 通过问卷id查询
	 * @param id
	 * @return
	 */
	@Select("select * from tb_questionnaire where id=#{id}")
	public Questionnaire findById(Integer id);
	/**
	 * 通过问卷标题模糊查询
	 * @param title
	 * @return	List<Questionnaire>
	 */
	@Select("select * from tb_questionnaire where title like CONCAT('%',#{username},'%')")
	public List<Questionnaire> findByTitle(String title);
	/**
	 * 通过发布问卷人puser_id查询
	 * @param puser_id
	 * @return
	 */
	@Select("select * from tb_questionnaire where puser_id=#{puser_id}")
	public List<Questionnaire> findByPuser_id(Integer puser_id);
	/**
	 * 通过状态查询
	 * @param publish
	 * @return
	 */
	@Select("select * from tb_questionnaire where publish=#{publish}")
	public List<Questionnaire> findByPublish(Integer publish);
	/**
	 * 查询全部
	 * @return
	 */
	@Select("select * from tb_questionnaire")
	public List<Questionnaire> findAll();
	/**
	 * 保存问卷
	 * @param questionnaire
	 * @return
	 */
	@Insert("insert into tb_questionnaire (title,ctime,dtime,publish,puser_id) value (#{title},#{ctime},#{dtime},#{publish},#{puser_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(Questionnaire questionnaire);
	/**
	 * 修改问卷
	 * @param questionnaire
	 * @return
	 */
	@Update("update tb_questionnaire set title=#{title},ctime=#{ctime},dtime=#{dtime},publish=#{publish},puser_id=#{puser_id} where id=#{id}")
	public int update(Questionnaire questionnaire);
	/**
	 * 删除问卷
	 * @param id
	 * @return
	 */
	@Delete("delete from tb_questionnaire where id=#{id}")
	public int delete(Integer id);
}
