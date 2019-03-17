package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_chat_message", schema = "anti_chat")
public class AntiChatMessage {
    private int id;
    private int fromId;
    private int toId;
    private int msgTypeId;
    private String content;
    private Timestamp sendAt;
    private byte state;

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
    @Column(name = "msg_type_id")
    public int getMsgTypeId() {
        return msgTypeId;
    }

    public void setMsgTypeId(int msgTypeId) {
        this.msgTypeId = msgTypeId;
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
    @Column(name = "send_at")
    public Timestamp getSendAt() {
        return sendAt;
    }

    public void setSendAt(Timestamp sendAt) {
        this.sendAt = sendAt;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiChatMessage that = (AntiChatMessage) o;
        return id == that.id &&
                fromId == that.fromId &&
                toId == that.toId &&
                msgTypeId == that.msgTypeId &&
                state == that.state &&
                Objects.equals(content, that.content) &&
                Objects.equals(sendAt, that.sendAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromId, toId, msgTypeId, content, sendAt, state);
    }
}
