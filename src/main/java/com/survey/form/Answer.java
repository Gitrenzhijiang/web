package com.survey.form;

/**
 * 对应tb_answer表
 * 答案
 * @author 18757
 *
 */
public class Answer {
    private Integer id;
    private String text;
    private String path;
    private Integer total;
    // 一个答案对应一个问题
    private Integer question_id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", text=" + text + ", path=" + path + ", total=" + total + ", question_id="
				+ question_id + "]";
	}
    
}
