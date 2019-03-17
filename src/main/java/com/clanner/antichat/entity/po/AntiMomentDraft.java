package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_moment_draft", schema = "anti_chat")
public class AntiMomentDraft {
    private int userId;
    private Byte momentType;
    private String content;
    private String photo;
    private String address;
    private Byte state;
    private Timestamp updAt;

    public AntiMomentDraft() {
    }

    public AntiMomentDraft(int userId, Timestamp updAt) {
        this.userId = userId;
        this.updAt = updAt;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "moment_type")
    public Byte getMomentType() {
        return momentType;
    }

    public void setMomentType(Byte momentType) {
        this.momentType = momentType;
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
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "upd_at")
    public Timestamp getUpdAt() {
        return updAt;
    }

    public void setUpdAt(Timestamp updAt) {
        this.updAt = updAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiMomentDraft that = (AntiMomentDraft) o;
        return userId == that.userId &&
                Objects.equals(momentType, that.momentType) &&
                Objects.equals(content, that.content) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(address, that.address) &&
                Objects.equals(state, that.state) &&
                Objects.equals(updAt, that.updAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, momentType, content, photo, address, state, updAt);
    }
}
