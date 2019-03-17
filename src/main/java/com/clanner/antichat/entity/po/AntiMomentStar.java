package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_moment_star", schema = "anti_chat")
public class AntiMomentStar {
    private int id;
    private int momentId;
    private int userId;
    private byte state;
    private Timestamp starAt;
    private Timestamp cancelAt;

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
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "star_at")
    public Timestamp getStarAt() {
        return starAt;
    }

    public void setStarAt(Timestamp starAt) {
        this.starAt = starAt;
    }

    @Basic
    @Column(name = "cancel_at")
    public Timestamp getCancelAt() {
        return cancelAt;
    }

    public void setCancelAt(Timestamp cancelAt) {
        this.cancelAt = cancelAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AntiMomentStar that = (AntiMomentStar) o;
        return id == that.id &&
                momentId == that.momentId &&
                userId == that.userId &&
                state == that.state &&
                Objects.equals(starAt, that.starAt) &&
                Objects.equals(cancelAt, that.cancelAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, momentId, userId, state, starAt, cancelAt);
    }
}
