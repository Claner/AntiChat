package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_memory", schema = "anti_chat")
public class AntiMemory {
    private int id;
    private int userId;
    private int friendId;
    private byte memoryType;
    private String content;
    private String photo;
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
    @Column(name = "memory_type")
    public byte getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(byte memoryType) {
        this.memoryType = memoryType;
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
        AntiMemory that = (AntiMemory) o;
        return id == that.id &&
                userId == that.userId &&
                friendId == that.friendId &&
                memoryType == that.memoryType &&
                Objects.equals(content, that.content) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(crtAt, that.crtAt) &&
                Objects.equals(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, friendId, memoryType, content, photo, crtAt, deletedAt);
    }
}
