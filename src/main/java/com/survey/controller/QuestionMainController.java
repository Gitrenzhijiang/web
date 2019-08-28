package com.survey.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.form.Answer;
import com.survey.form.Question;
import com.survey.form.QuestionAnswer;
import com.survey.form.Questionnaire;
import com.survey.form.User;
import com.survey.service.AnswerService;
import com.survey.service.QuestionService;
import com.survey.service.QuestionnaireService;
import com.survey.service.UserService;

@Controller
@RequestMapping("/quesMain")
public class QuestionMainController {
	
	@Resource(name = "questionnaireService")
	private QuestionnaireService questionnaireService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "questionService")
	private QuestionService questionService;
	
	@Resource(name = "answerService")
	private AnswerService answerService;
	
	@RequestMapping("/toQuesMain")
	public String toQuesMain(Model model,String title) {
		List<User> users = userService.findAll();
		List<Questionnaire> questionnaires;
		if (title==null) {
			questionnaires = questionnaireService.findAll();
		}else {
			title = title.trim();
			questionnaires = questionnaireService.findByTitle(title);
		}
		model.addAttribute("userList", users);
		model.addAttribute("mainList", questionnaires);
		return "questionMe";
	}
	
	@RequestMapping("/quesDeleOne")
	public void quesDeleOne(Integer id,HttpServletResponse response) throws Exception {
		questionnaireService.delete(id);
		response.getWriter().append("sss");
		return;
	}
	
	@RequestMapping("/quesStart")
	public void quesStart(Integer id,HttpServletResponse response) throws Exception {
		Questionnaire questionnaire = questionnaireService.findById(id);
		questionnaire.setPublish(1);
		questionnaireService.update(questionnaire);
		response.getWriter().append("sss");
		return;
	}
	
	@RequestMapping("/quesStop")
	public void quesStop(Integer id,HttpServletResponse response) throws Exception {
		Questionnaire questionnaire = questionnaireService.findById(id);
		questionnaire.setPublish(0);
		questionnaireService.update(questionnaire);
		response.getWriter().append("sss");
		return;
	}
	
	@RequestMapping("/quesFindByName")
	public String quesFindByName(String title,Model model) throws Exception {
		List<Questionnaire> questionnaires = questionnaireService.findByTitle(title);
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);
		model.addAttribute("mainList", questionnaires);
		model.addAttribute("title", title);
		return "questionMe";
	}
	
	@RequestMapping("/toQuesNaire")
	public String toQuesNaire(Integer id,Model model) {
		Questionnaire questionnaire = questionnaireService.findById(id);
		List<Question> questions = questionService.findByQuestionnaire_id(id);
		List<Answer> answers = answerService.findAll();
		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("questions", questions);
		model.addAttribute("answers", answers);
		return "editQuestionnaire";
	}
	
	@RequestMapping("/editQuesNatre")
	public String editQuesNatre(Integer id,String title, Date dtime) {
		System.out.println(id+"------------"+title+"----------------"+dtime);
		return "";
	}
	
	@RequestMapping("/questionDele")
	public void questionDele(Integer id,HttpServletResponse response) throws Exception {
		questionService.delete(id);
		response.getWriter().append("555");
		return;
	}
	
	@RequestMapping("/showQuestion")
	@ResponseBody
	public Object showQuestion(Integer id) {
		Question question = questionService.findById(id);
		List<Answer> answers = answerService.findByQuestion_id(id);
		return new QuestionAnswer(question, answers);
	}
	
	@RequestMapping("/editQuestion")
	public void editQuestion(Question question,String answerid,String answertext,String answerpath) {
		
		System.out.println("-----------------------------------------");
		System.out.println(question);
		System.out.println(answerid);
		System.out.println(answertext);
//		 JSONArray jsonArray = JSONArray.fromObject(string);
//		          for (Object o : jsonArray) {
//		              JSONObject jo = (JSONObject)o;
//		              System.out.println(jo.getString("parent"));
//		          }
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		return;
	}
}
