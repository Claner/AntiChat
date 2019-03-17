package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_friends", schema = "anti_chat")
public class AntiFriends {
    private int id;
    private int userId;
    private int friendId;
    private String alias;
    private String from;
    private String phone;
    private String description;
    private byte top;
    private String background;
    private Timestamp topAt;
    private Timestamp crtAt;
    private Timestamp updAt;
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
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "friend_id")
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "from")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "top")
    public byte getTop() {
        return top;
    }

    public void setTop(byte top) {
        this.top = top;
    }

    @Basic
    @Column(name = "background")
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Basic
    @Column(name = "top_at")
    public Timestamp getTopAt() {
        return topAt;
    }

    public void setTopAt(Timestamp topAt) {
        this.topAt = topAt;
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
        AntiFriends that = (AntiFriends) o;
        return id == that.id &&
                userId == that.userId &&
                friendId == that.friendId &&
                top == that.top &&
                Objects.equals(alias, that.alias) &&
                Objects.equals(from, that.from) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(description, that.description) &&
                Objects.equals(background, that.background) &&
                Objects.equals(topAt, that.topAt) &&
                Objects.equals(crtAt, that.crtAt) &&
                Objects.equals(updAt, that.updAt) &&
                Objects.equals(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, friendId, alias, from, phone, description, top, background, topAt, crtAt, updAt, deletedAt);
    }
}
