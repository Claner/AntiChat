package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_group", schema = "anti_chat")
public class AntiGroup {
    private int id;
    private int createId;
    private int ownerId;
    private int managerId;
    private String name;
    private String notice;
    private String cover;
    private short limit;
    private Timestamp noticeAt;
    private Timestamp crtAt;
    private Timestamp ownerChangeAt;
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
    @Column(name = "create_id")
    public int getCreateId() {
        return createId;
    }

    public void setCreateId(int createId) {
        this.createId = createId;
    }

    @Basic
    @Column(name = "owner_id")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "manager_id")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "limit")
    public short getLimit() {
        return limit;
    }

    public void setLimit(short limit) {
        this.limit = limit;
    }

    @Basic
    @Column(name = "notice_at")
    public Timestamp getNoticeAt() {
        return noticeAt;
    }

    public void setNoticeAt(Timestamp noticeAt) {
        this.noticeAt = noticeAt;
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
    @Column(name = "owner_change_at")
    public Timestamp getOwnerChangeAt() {
        return ownerChangeAt;
    }

    public void setOwnerChangeAt(Timestamp ownerChangeAt) {
        this.ownerChangeAt = ownerChangeAt;
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
        AntiGroup antiGroup = (AntiGroup) o;
        return id == antiGroup.id &&
                createId == antiGroup.createId &&
                ownerId == antiGroup.ownerId &&
                managerId == antiGroup.managerId &&
                limit == antiGroup.limit &&
                Objects.equals(name, antiGroup.name) &&
                Objects.equals(notice, antiGroup.notice) &&
                Objects.equals(cover, antiGroup.cover) &&
                Objects.equals(noticeAt, antiGroup.noticeAt) &&
                Objects.equals(crtAt, antiGroup.crtAt) &&
                Objects.equals(ownerChangeAt, antiGroup.ownerChangeAt) &&
                Objects.equals(deletedAt, antiGroup.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createId, ownerId, managerId, name, notice, cover, limit, noticeAt, crtAt, ownerChangeAt, deletedAt);
    }
}
