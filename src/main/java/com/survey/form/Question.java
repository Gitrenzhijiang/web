package com.survey.form;

/**
 * 对应tb_question表
 * 问题
 */
public class Question {
    private Integer id;
    private Integer no;
    private String text;
    //  1:单选  0：多选
    private int type;
    // 当前的问卷问题   一个问题对应一个问卷
    private Integer questionnaire_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int string) {
        this.type = string;
    }

	public Integer getQuestionnaire_id() {
		return questionnaire_id;
	}

	public void setQuestionnaire_id(Integer questionnaire_id) {
		this.questionnaire_id = questionnaire_id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", no=" + no + ", text=" + text + ", type=" + type + ", questionnaire_id="
				+ questionnaire_id + "]";
	}
    
}
