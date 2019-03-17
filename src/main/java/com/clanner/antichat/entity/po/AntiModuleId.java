package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_module_id", schema = "anti_chat")
public class AntiModuleId {
    private int id;
    private Integer curId;
    private Timestamp crtAt;
    private Timestamp updAt;
    private String description;

    public AntiModuleId() {
    }

    public AntiModuleId(Integer curId, Timestamp updAt) {
        this.curId = curId;
        this.updAt = updAt;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cur_id")
    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    @Basic
    @Column(name = "crt_at")
    public Timestamp getCrtAt() {
        return crtAt;
    }

    public void setCrtAt(Timestamp crtAt) {
        this.crtAt = crtAt;
    }

    @Basic
    @Column(name = "upd_at")
    public Timestamp getUpdAt() {
        return updAt;
    }

    public void setUpdAt(Timestamp updAt) {
        this.updAt = updAt;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiModuleId that = (AntiModuleId) o;
        return id == that.id &&
                Objects.equals(curId, that.curId) &&
                Objects.equals(crtAt, that.crtAt) &&
                Objects.equals(updAt, that.updAt) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curId, crtAt, updAt, description);
    }
}
