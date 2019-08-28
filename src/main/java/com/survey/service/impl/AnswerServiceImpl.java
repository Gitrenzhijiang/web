package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.AnswerDao;
import com.survey.form.Answer;
import com.survey.service.AnswerService;
@Service("answerService")
public class AnswerServiceImpl implements AnswerService{
	@Resource(name = "answerDao")
	private AnswerDao answerDao;

	@Override
	public List<Answer> findByQuestion_id(Integer question_id) {
		return answerDao.findByQuestion_id(question_id);
	}

	@Override
	public List<Answer> findAll() {
		return answerDao.findAll();
	}

	@Override
	public int save(Answer answer) {
		return answerDao.save(answer);
	}

	@Override
	public int upate(Answer answer) {
		return answerDao.upate(answer);
	}

	@Override
	public int delete(Integer id) {
		return answerDao.delete(id);
	}

	@Override
	public Answer findById(Integer id) {
		// TODO Auto-generated method stub
		return answerDao.findById(id);
	}
	
}
