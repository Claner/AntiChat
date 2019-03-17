package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_parallel_card", schema = "anti_chat")
public class AntiParallelCard {
    private int id;
    private int userId;
    private String username;
    private String content;
    private int msgTypeId;
    private byte state;
    private String title;
    private Timestamp driftAt;
    private Integer pickUpId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    @Column(name = "msg_type_id")
    public int getMsgTypeId() {
        return msgTypeId;
    }

    public void setMsgTypeId(int msgTypeId) {
        this.msgTypeId = msgTypeId;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "drift_at")
    public Timestamp getDriftAt() {
        return driftAt;
    }

    public void setDriftAt(Timestamp driftAt) {
        this.driftAt = driftAt;
    }

    @Basic
    @Column(name = "pick_up_id")
    public Integer getPickUpId() {
        return pickUpId;
    }

    public void setPickUpId(Integer pickUpId) {
        this.pickUpId = pickUpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiParallelCard that = (AntiParallelCard) o;
        return id == that.id &&
                userId == that.userId &&
                msgTypeId == that.msgTypeId &&
                state == that.state &&
                Objects.equals(username, that.username) &&
                Objects.equals(content, that.content) &&
                Objects.equals(title, that.title) &&
                Objects.equals(driftAt, that.driftAt) &&
                Objects.equals(pickUpId, that.pickUpId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, username, content, msgTypeId, state, title, driftAt, pickUpId);
    }
}
