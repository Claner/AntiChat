package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_moment_comment", schema = "anti_chat")
public class AntiMomentComment {
    private int id;
    private int momentId;
    private int userId;
    private int atId;
    private String content;
    private byte state;
    private Timestamp crtAt;
    private Timestamp deletedAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "moment_id")
    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "at_id")
    public int getAtId() {
        return atId;
    }

    public void setAtId(int atId) {
        this.atId = atId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
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
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiMomentComment that = (AntiMomentComment) o;
        return id == that.id &&
                momentId == that.momentId &&
                userId == that.userId &&
                atId == that.atId &&
                state == that.state &&
                Objects.equals(content, that.content) &&
                Objects.equals(crtAt, that.crtAt) &&
                Objects.equals(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, momentId, userId, atId, content, state, crtAt, deletedAt);
    }
}
