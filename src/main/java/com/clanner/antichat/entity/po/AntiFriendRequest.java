package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_friend_request", schema = "anti_chat")
public class AntiFriendRequest {
    private int id;
    private int fromId;
    private int toId;
    private String source;
    private Byte state;
    private String content;
    private Timestamp requestAt;
    private Timestamp operateAt;
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
    @Column(name = "from_id")
    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "to_id")
    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "request_at")
    public Timestamp getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Timestamp requestAt) {
        this.requestAt = requestAt;
    }

    @Basic
    @Column(name = "operate_at")
    public Timestamp getOperateAt() {
        return operateAt;
    }

    public void setOperateAt(Timestamp operateAt) {
        this.operateAt = operateAt;
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
        AntiFriendRequest that = (AntiFriendRequest) o;
        return id == that.id &&
                fromId == that.fromId &&
                toId == that.toId &&
                Objects.equals(source, that.source) &&
                Objects.equals(state, that.state) &&
                Objects.equals(content, that.content) &&
                Objects.equals(requestAt, that.requestAt) &&
                Objects.equals(operateAt, that.operateAt) &&
                Objects.equals(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromId, toId, source, state, content, requestAt, operateAt, deletedAt);
    }
}
