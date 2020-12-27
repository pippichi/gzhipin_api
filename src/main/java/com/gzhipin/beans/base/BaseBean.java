package com.gzhipin.beans.base;


import com.gzhipin.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class BaseBean {

    @Column(name = "created_at", columnDefinition = "DATETIME COMMENT '创建时间'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME COMMENT '更新时间'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void prePersist() {
        Date now = DateUtils.now();
        if (this.createdAt == null) {
            this.createdAt = now;
        }

        if (this.updatedAt == null) {
            this.updatedAt = now;
        }
    }

    @PreUpdate
    protected void preUpdate() { this.updatedAt = new Date(); }

    @PreRemove
    protected void preRemove() { this.updatedAt = new Date(); }

    public BaseBean(Date createdAt, Date updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseBean() {
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBean baseBean = (BaseBean) o;
        return Objects.equals(createdAt, baseBean.createdAt) &&
                Objects.equals(updatedAt, baseBean.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt);
    }
}
