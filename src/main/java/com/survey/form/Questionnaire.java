package com.survey.form;

import java.util.Date;

public class Questionnaire {
    private int id;
    private String title;
    private Date ctime;
    private Date dtime;
    //  1:发布  0：未发布
    private int publish;
    // 当前问卷的发布人 ，一个问卷一个发布人
    private int puser_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

	public int getPuser_id() {
		return puser_id;
	}

	public void setPuser_id(int puser_id) {
		this.puser_id = puser_id;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", title=" + title + ", ctime=" + ctime + ", dtime=" + dtime + ", publish="
				+ publish + ", puser_id=" + puser_id + "]";
	}
	
}
