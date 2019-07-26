package com.survey.pojo;

import com.ren.jdbc.annotation.Column;
import com.ren.jdbc.annotation.Generatekey;
import com.ren.jdbc.annotation.Id;
import com.ren.jdbc.annotation.POJO;

/**
 * 对应物理表 tb_role
 * @author REN
 *
 */
@POJO("tb_role")
@Generatekey(true) // 使用自增主键
public class Role {
    @Id("id")
    private int id;
    @Column("name")
    private String name;
    @Column("desc")
    private String desc;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", desc=" + desc + "]";
    }
}
