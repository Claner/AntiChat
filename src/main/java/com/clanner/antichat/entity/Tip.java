package com.clanner.antichat.entity;

/**
 * @author Clanner
 * 错误类型
 */
public enum Tip {


    TEST(2000,"测试"),
    REGISTER_SUCCESS(2001, "注册成功"),
    HAS_REGISTER(2002, "该账户已注冊"),
    ACCOUNT_OR_PASSWORD_ERROR(2003, "用户名或密码错误"),
    LOGIN_SUCCESS(2004, "登录成功"),
    LACK_KEY(2005, "缺少密钥"),
    SYSTEM_ERROR(2006, "系統錯誤");

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    Tip(int code, String name) {
        this.code = code;
        this.name = name;
    }}


