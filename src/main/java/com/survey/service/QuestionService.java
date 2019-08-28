package com.survey.service;

import java.util.List;

import com.survey.form.Question;

public interface QuestionService {
	/**
	 * 通过问题id 查询
	 * @param id
	 * @return
	 */
	public Question findById(Integer id);
	/**
	 * 通过问卷id 查询
	 * @param questionnaire_id
	 * @return
	 */
	public List<Question> findByQuestionnaire_id(Integer questionnaire_id);
	/**
	 * 查询全部
	 * @return
	 */
	public List<Question> findAll();
	/**
	 * 保存问题
	 * @param question
	 * @return
	 */
	public int save(Question question);
	/**
	 * 修改问题
	 * @param question
	 * @return
	 */
	public int update(Question question);
	/**
	 * 删除问题
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
