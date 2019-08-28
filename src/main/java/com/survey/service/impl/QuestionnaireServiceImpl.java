package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.QuestionnaireDao;
import com.survey.form.Questionnaire;
import com.survey.service.QuestionnaireService;
@Service("questionnaireService")
public class QuestionnaireServiceImpl implements QuestionnaireService{
	@Resource(name = "questionnaireDao")
	private QuestionnaireDao questionnaireDao;

	@Override
	public List<Questionnaire> findByPuser_id(Integer puser_id) {
		return questionnaireDao.findByPuser_id(puser_id);
	}

	@Override
	public List<Questionnaire> findByPublish(Integer publish) {
		return questionnaireDao.findByPublish(publish);
	}

	@Override
	public List<Questionnaire> findAll() {
		return questionnaireDao.findAll();
	}

	@Override
	public int save(Questionnaire questionnaire) {
		return questionnaireDao.save(questionnaire);
	}

	@Override
	public int update(Questionnaire questionnaire) {
		return questionnaireDao.update(questionnaire);
	}

	@Override
	public int delete(Integer id) {
		return questionnaireDao.delete(id);
	}

	@Override
	public Questionnaire findById(Integer id) {
		// TODO Auto-generated method stub
		return questionnaireDao.findById(id);
	}

	@Override
	public List<Questionnaire> findByTitle(String title) {
		// TODO Auto-generated method stub
		return questionnaireDao.findByTitle(title);
	}
	
}
