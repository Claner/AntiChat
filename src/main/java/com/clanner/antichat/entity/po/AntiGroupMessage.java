package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_group_message", schema = "anti_chat")
public class AntiGroupMessage {
    private int id;
    private int groupId;
    private int fromId;
    private int msgTypeId;
    private String content;
    private Timestamp sendAt;
    private String unReadRange;
    private String hasReadRange;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
    @Column(name = "un_read_range")
    public String getUnReadRange() {
        return unReadRange;
    }

    public void setUnReadRange(String unReadRange) {
        this.unReadRange = unReadRange;
    }

    @Basic
    @Column(name = "has_read_range")
    public String getHasReadRange() {
        return hasReadRange;
    }

    public void setHasReadRange(String hasReadRange) {
        this.hasReadRange = hasReadRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiGroupMessage that = (AntiGroupMessage) o;
        return id == that.id &&
                groupId == that.groupId &&
                fromId == that.fromId &&
                msgTypeId == that.msgTypeId &&
                Objects.equals(content, that.content) &&
                Objects.equals(sendAt, that.sendAt) &&
                Objects.equals(unReadRange, that.unReadRange) &&
                Objects.equals(hasReadRange, that.hasReadRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, fromId, msgTypeId, content, sendAt, unReadRange, hasReadRange);
    }
}
