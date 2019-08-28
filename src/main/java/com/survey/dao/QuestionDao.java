package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.Question;

public interface QuestionDao {
	/**
	 * 通过问题id 查询
	 * @param id
	 * @return
	 */
	@Select("select * from tb_question where id=#{id}")
	public Question findById(Integer id);
	/**
	 * 通过问卷id 查询
	 * @param questionnaire_id
	 * @return
	 */
	@Select("select * from tb_question where questionnaire_id=#{questionnaire_id}")
	public List<Question> findByQuestionnaire_id(Integer questionnaire_id);
	/**
	 * 查询全部
	 * @return
	 */
	@Select("select * from tb_question")
	public List<Question> findAll();
	/**
	 * 保存问题
	 * @param question
	 * @return
	 */
	@Insert("insert into tb_question (text,type,questionnaire_id) value(#{text},#{type},#{questionnaire_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(Question question);
	/**
	 * 修改问题
	 * @param question
	 * @return
	 */
	@Update("update tb_question set text=#{text},type=#{type},questionnaire_id=#{questionnaire_id} where id=#{id}")
	public int update(Question question);
	/**
	 * 删除问题
	 * @param id
	 * @return
	 */
	@Delete("delete from tb_question where id=#{id}")
	public int delete(Integer id);
}
