package com.gzhipin.beans;

import com.gzhipin.beans.base.BaseBean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "g_skills")
public class Skills extends BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255, columnDefinition = "VARCHAR(255) NOT NULL DEFAULT '' COMMENT '技能名称'")
    private String skill_name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "introduce", length = 255, columnDefinition = "TEXT COMMENT '技能介绍'")
    private String introduce;

    public Skills() {
    }

    public Skills(Integer id, String skill_name, String introduce) {
        this.id = id;
        this.skill_name = skill_name;
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return Objects.equals(id, skills.id) &&
                Objects.equals(skill_name, skills.skill_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill_name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
