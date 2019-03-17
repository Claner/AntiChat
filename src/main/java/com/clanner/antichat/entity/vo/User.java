package com.clanner.antichat.entity.vo;

import java.sql.Timestamp;

/**
 * @author Clanner
 */
public class User {
    private Integer userId;
    private String account;
    private String username;
    private String pubSalt;
    private short maxLimit;
    private String antiId;
    private Byte gender;
    private String sign;
    private String location;
    private String avatar;
    private String cover;
    private String music;
    private String qrCode;
    private Timestamp registerAt;
    private Timestamp updAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPubSalt() {
        return pubSalt;
    }

    public void setPubSalt(String pubSalt) {
        this.pubSalt = pubSalt;
    }

    public short getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(short maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getAntiId() {
        return antiId;
    }

    public void setAntiId(String antiId) {
        this.antiId = antiId;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Timestamp getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Timestamp registerAt) {
        this.registerAt = registerAt;
    }

    public Timestamp getUpdAt() {
        return updAt;
    }

    public void setUpdAt(Timestamp updAt) {
        this.updAt = updAt;
    }
}
