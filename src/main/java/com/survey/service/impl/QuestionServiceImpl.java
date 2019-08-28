package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.QuestionDao;
import com.survey.form.Question;
import com.survey.service.QuestionService;
@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	@Resource(name = "questionDao")
	private QuestionDao questionDao;

	@Override
	public List<Question> findByQuestionnaire_id(Integer questionnaire_id) {
		// TODO Auto-generated method stub
		return questionDao.findByQuestionnaire_id(questionnaire_id);
	}

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	@Override
	public int save(Question question) {
		// TODO Auto-generated method stub
		return questionDao.save(question);
	}

	@Override
	public int update(Question question) {
		// TODO Auto-generated method stub
		return questionDao.update(question);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return questionDao.delete(id);
	}

	@Override
	public Question findById(Integer id) {
		// TODO Auto-generated method stub
		return questionDao.findById(id);
	}
	
}
