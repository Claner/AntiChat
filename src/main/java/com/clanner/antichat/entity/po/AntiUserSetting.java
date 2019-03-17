package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_user_setting", schema = "anti_chat")
public class AntiUserSetting {
    private int userId;
    private byte addByPhone;
    private byte addByAntiId;
    private byte addByQrCode;
    private byte addByGroup;
    private byte addByCard;
    private Timestamp updAt;

    public AntiUserSetting() {
    }

    public AntiUserSetting(int userId, Timestamp updAt) {
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
    @Column(name = "add_by_phone")
    public byte getAddByPhone() {
        return addByPhone;
    }

    public void setAddByPhone(byte addByPhone) {
        this.addByPhone = addByPhone;
    }

    @Basic
    @Column(name = "add_by_anti_id")
    public byte getAddByAntiId() {
        return addByAntiId;
    }

    public void setAddByAntiId(byte addByAntiId) {
        this.addByAntiId = addByAntiId;
    }

    @Basic
    @Column(name = "add_by_qr_code")
    public byte getAddByQrCode() {
        return addByQrCode;
    }

    public void setAddByQrCode(byte addByQrCode) {
        this.addByQrCode = addByQrCode;
    }

    @Basic
    @Column(name = "add_by_group")
    public byte getAddByGroup() {
        return addByGroup;
    }

    public void setAddByGroup(byte addByGroup) {
        this.addByGroup = addByGroup;
    }

    @Basic
    @Column(name = "add_by_card")
    public byte getAddByCard() {
        return addByCard;
    }

    public void setAddByCard(byte addByCard) {
        this.addByCard = addByCard;
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
        AntiUserSetting that = (AntiUserSetting) o;
        return userId == that.userId &&
                addByPhone == that.addByPhone &&
                addByAntiId == that.addByAntiId &&
                addByQrCode == that.addByQrCode &&
                addByGroup == that.addByGroup &&
                addByCard == that.addByCard &&
                Objects.equals(updAt, that.updAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, addByPhone, addByAntiId, addByQrCode, addByGroup, addByCard, updAt);
    }
}
