package com.survey.form;

public class TreePermissionEle {
	private Integer id;

    private String type;

    private Integer pId;

    private String name;
    
    private Boolean checked = false;
    
    public TreePermissionEle (Permission p,boolean checked) {
    	this.id = p.getId();
    	this.name = p.getName();
    	this.pId = 0;
    	this.checked = checked;
    }
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TreePermissionEle [id=" + id + ", type=" + type + ", pId=" + pId + ", name=" + name + ", checked="
				+ checked + "]";
	}
    
}
