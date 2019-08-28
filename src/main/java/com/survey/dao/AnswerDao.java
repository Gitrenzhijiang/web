package com.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.survey.form.Answer;

public interface AnswerDao {
	/**
	 * 根据答案id  查询
	 * @return 返回Answer
	 */
	@Select("select * from tb_answer where id=#{id}")
	public Answer findById(Integer id);
	/**
	 * 根据问题id  question_id查询
	 * @return 返回List<Answer>
	 */
	@Select("select * from tb_answer where question_id=#{question_id}")
	public List<Answer> findByQuestion_id(Integer question_id);
	/**
	 * 查询表中所有答案
	 * @return 返回Answer集合
	 */
	@Select("select * from tb_answer")
	public List<Answer> findAll();
	/**
	 * 保存答案信息
	 * @param Answer
	 * @return
	 */
	@Insert("insert into tb_answer (text,path,total,question_id) value(#{text},#{path},#{total},#{question_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public int save(Answer answer);
	/**
	 * 修改答案信息
	 * @param Answer
	 * @return
	 */
	@Update("update tb_answer set text=#{text},path=#{path},total=#{total} where id=#{id}")
	public int upate(Answer answer);
	/**
	 * 删除答案信息
	 * @param Answer
	 * @return
	 */
	@Delete("delete from tb_answer where id = #{id}")
	public int delete(Integer id);
}
