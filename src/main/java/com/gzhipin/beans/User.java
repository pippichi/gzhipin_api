package com.gzhipin.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gzhipin.beans.base.BaseBean;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "g_user")
public class User extends BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 255, columnDefinition = "VARCHAR(255) NOT NULL DEFAULT '' COMMENT '姓名'")
    private String username;

    @Column(name = "password", length = 255, columnDefinition = "VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码'")
    private String password;

    @Column(columnDefinition = "TINYINT NOT NULL DEFAULT 1 COMMENT '类型'")
    private Integer type;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "skill_id", foreignKey = @ForeignKey(name = "FK_Reference_48"), columnDefinition = "INT COMMENT '外键skill_id'")
    private Skills skills;

    public User(Date createdAt, Date updatedAt, Integer id, String username, String password, Integer type, Skills skills) {
        super(createdAt, updatedAt);
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.skills = skills;
    }

    public User(){}

    public User(Integer id, String username, String password, Integer type, Skills skills) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.skills = skills;
    }

    public User(Date createdAt, Date updatedAt) {
        super(createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(type, user.type) &&
                Objects.equals(skills, user.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, type, skills);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @JsonIgnore
    public Skills getSkills() {
        return skills;
    }

    @JsonProperty(value = "skills_id")
    public Integer getSkillsId() {
        if (this.skills != null)
            return this.skills.getId();
        else
            return null;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
}
