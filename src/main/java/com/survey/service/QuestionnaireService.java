package com.survey.service;

import java.util.List;

import com.survey.form.Questionnaire;

public interface QuestionnaireService {
	/**
	 * 通过问卷id查询
	 * @param id
	 * @return
	 */
	public Questionnaire findById(Integer id);
	/**
	 * 通过问卷标题模糊查询
	 * @param title
	 * @return	List<Questionnaire>
	 */
	public List<Questionnaire> findByTitle(String title);
	/**
	 * 通过发布问卷人puser_id查询
	 * @param puser_id
	 * @return
	 */
	public List<Questionnaire> findByPuser_id(Integer puser_id);
	/**
	 * 通过状态查询
	 * @param publish
	 * @return
	 */
	public List<Questionnaire> findByPublish(Integer publish);
	/**
	 * 查询全部
	 * @return
	 */
	public List<Questionnaire> findAll();
	/**
	 * 保存问卷
	 * @param questionnaire
	 * @return
	 */
	public int save(Questionnaire questionnaire);
	/**
	 * 修改问卷
	 * @param questionnaire
	 * @return
	 */
	public int update(Questionnaire questionnaire);
	/**
	 * 删除问卷
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
