package com.clanner.antichat.entity.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_user_info", schema = "anti_chat")
public class AntiUserInfo {
    private int userId;
    private String username;
    private Byte gender;
    private String sign;
    private String location;
    private String avatar;
    private String cover;
    private String music;
    private String qrCode;
    private String lastAvatar;
    private String historyAvatarPath;
    private Timestamp updAt;

    public AntiUserInfo() {
    }

    public AntiUserInfo(int userId, String username, Timestamp updAt) {
        this.userId = userId;
        this.username = username;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "gender")
    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "sign")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
    @Column(name = "music")
    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Basic
    @Column(name = "qr_code")
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "last_avatar")
    public String getLastAvatar() {
        return lastAvatar;
    }

    public void setLastAvatar(String lastAvatar) {
        this.lastAvatar = lastAvatar;
    }

    @Basic
    @Column(name = "history_avatar_path")
    public String getHistoryAvatarPath() {
        return historyAvatarPath;
    }

    public void setHistoryAvatarPath(String historyAvatarPath) {
        this.historyAvatarPath = historyAvatarPath;
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
        AntiUserInfo that = (AntiUserInfo) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(location, that.location) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(cover, that.cover) &&
                Objects.equals(music, that.music) &&
                Objects.equals(qrCode, that.qrCode) &&
                Objects.equals(lastAvatar, that.lastAvatar) &&
                Objects.equals(historyAvatarPath, that.historyAvatarPath) &&
                Objects.equals(updAt, that.updAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, gender, sign, location, avatar, cover, music, qrCode, lastAvatar, historyAvatarPath, updAt);
    }
}
