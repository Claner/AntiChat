package com.clanner.antichat.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Clanner
 */
@Entity
@Table(name = "anti_user", schema = "anti_chat")
public class AntiUser {
    private int id;
    private String account;
    @JsonIgnore
    private String shadow;
    private String pubSalt;
    @JsonIgnore
    private String priSalt;
    @JsonIgnore
    private String mvDevice;
    @JsonIgnore
    private String pcDevice;
    @JsonIgnore
    private String token;
    private short maxLimit;
    @JsonIgnore
    private byte freeze;
    private String antiId;
    @JsonIgnore
    private byte modifyNum;
    private Timestamp registerAt;
    @JsonIgnore
    private Timestamp deletedAt;

    public AntiUser() {
    }

    public AntiUser(String pubSalt, String priSalt) {
        this.pubSalt = pubSalt;
        this.priSalt = priSalt;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "shadow")
    public String getShadow() {
        return shadow;
    }

    public void setShadow(String shadow) {
        this.shadow = shadow;
    }

    @Basic
    @Column(name = "pub_salt")
    public String getPubSalt() {
        return pubSalt;
    }

    public void setPubSalt(String pubSalt) {
        this.pubSalt = pubSalt;
    }

    @Basic
    @Column(name = "pri_salt")
    public String getPriSalt() {
        return priSalt;
    }

    public void setPriSalt(String priSalt) {
        this.priSalt = priSalt;
    }

    @Basic
    @Column(name = "mv_device")
    public String getMvDevice() {
        return mvDevice;
    }

    public void setMvDevice(String mvDevice) {
        this.mvDevice = mvDevice;
    }

    @Basic
    @Column(name = "pc_device")
    public String getPcDevice() {
        return pcDevice;
    }

    public void setPcDevice(String pcDevice) {
        this.pcDevice = pcDevice;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "max_limit")
    public short getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(short limit) {
        this.maxLimit = limit;
    }

    @Basic
    @Column(name = "freeze")
    public byte getFreeze() {
        return freeze;
    }

    public void setFreeze(byte freeze) {
        this.freeze = freeze;
    }

    @Basic
    @Column(name = "anti_id")
    public String getAntiId() {
        return antiId;
    }

    public void setAntiId(String antiId) {
        this.antiId = antiId;
    }

    @Basic
    @Column(name = "modify_num")
    public byte getModifyNum() {
        return modifyNum;
    }

    public void setModifyNum(byte modifyNum) {
        this.modifyNum = modifyNum;
    }

    @Basic
    @Column(name = "register_at")
    public Timestamp getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Timestamp registerAt) {
        this.registerAt = registerAt;
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
        AntiUser antiUser = (AntiUser) o;
        return id == antiUser.id &&
                maxLimit == antiUser.maxLimit &&
                freeze == antiUser.freeze &&
                modifyNum == antiUser.modifyNum &&
                Objects.equals(account, antiUser.account) &&
                Objects.equals(shadow, antiUser.shadow) &&
                Objects.equals(pubSalt, antiUser.pubSalt) &&
                Objects.equals(priSalt, antiUser.priSalt) &&
                Objects.equals(mvDevice, antiUser.mvDevice) &&
                Objects.equals(pcDevice, antiUser.pcDevice) &&
                Objects.equals(token, antiUser.token) &&
                Objects.equals(antiId, antiUser.antiId) &&
                Objects.equals(registerAt, antiUser.registerAt) &&
                Objects.equals(deletedAt, antiUser.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, shadow, pubSalt, priSalt, mvDevice, pcDevice, token, maxLimit, freeze, antiId, modifyNum, registerAt, deletedAt);
    }

    @Override
    public String toString() {
        return "AntiUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", shadow='" + shadow + '\'' +
                ", pubSalt='" + pubSalt + '\'' +
                ", priSalt='" + priSalt + '\'' +
                ", mvDevice='" + mvDevice + '\'' +
                ", pcDevice='" + pcDevice + '\'' +
                ", token='" + token + '\'' +
                ", maxLimit=" + maxLimit +
                ", freeze=" + freeze +
                ", antiId='" + antiId + '\'' +
                ", modifyNum=" + modifyNum +
                ", registerAt=" + registerAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
