package com.survey.service;

import java.util.List;

import com.survey.form.Answer;

public interface AnswerService {
	/**
	 * 根据答案id  查询
	 * @return 返回answer
	 */
	public Answer findById(Integer id);
	/**
	 * 根据问题id  question_id查询
	 * @return 返回List<Answer>
	 */
	public List<Answer> findByQuestion_id(Integer question_id);
	/**
	 * 查询表中所有答案
	 * @return 返回Answer集合
	 */
	public List<Answer> findAll();
	/**
	 * 保存答案信息
	 * @param Answer
	 * @return
	 */
	public int save(Answer answer);
	/**
	 * 修改答案信息
	 * @param Answer
	 * @return
	 */
	public int upate(Answer answer);
	/**
	 * 删除答案信息
	 * @param Answer
	 * @return
	 */
	public int delete(Integer id);
}
