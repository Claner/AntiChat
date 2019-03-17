package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_user_group", schema = "anti_chat")
public class AntiUserGroup {
    private int id;
    private int userId;
    private int groupId;
    private byte save;
    private byte top;
    private byte mute;
    private Timestamp saveAt;
    private Timestamp topAt;
    private Timestamp kickAt;
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
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "save")
    public byte getSave() {
        return save;
    }

    public void setSave(byte save) {
        this.save = save;
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
    @Column(name = "mute")
    public byte getMute() {
        return mute;
    }

    public void setMute(byte mute) {
        this.mute = mute;
    }

    @Basic
    @Column(name = "save_at")
    public Timestamp getSaveAt() {
        return saveAt;
    }

    public void setSaveAt(Timestamp saveAt) {
        this.saveAt = saveAt;
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
    @Column(name = "kick_at")
    public Timestamp getKickAt() {
        return kickAt;
    }

    public void setKickAt(Timestamp kickAt) {
        this.kickAt = kickAt;
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
        AntiUserGroup that = (AntiUserGroup) o;
        return id == that.id &&
                userId == that.userId &&
                groupId == that.groupId &&
                save == that.save &&
                top == that.top &&
                mute == that.mute &&
                Objects.equals(saveAt, that.saveAt) &&
                Objects.equals(topAt, that.topAt) &&
                Objects.equals(kickAt, that.kickAt) &&
                Objects.equals(deletedAt, that.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, groupId, save, top, mute, saveAt, topAt, kickAt, deletedAt);
    }
}
