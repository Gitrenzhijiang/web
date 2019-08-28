package com.dao.demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.survey.dao.QuestionnaireDao;
import com.survey.form.Questionnaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class QuestionnaireDaoTest {
	@Resource(name = "questionnaireDao")
	QuestionnaireDao  questionnaireDao;
	@Test
	public void testName() throws Exception {
		List<Questionnaire> questionnaires = questionnaireDao.findByTitle("vvvvvvv");
		System.out.println(questionnaireDao);
		System.out.println("----------------------------------------------------");
		for (Questionnaire questionnaire : questionnaires) {
			System.out.println(questionnaire);
		}
		System.out.println("----------------------------------------------------");
	}
}
