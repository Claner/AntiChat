package com.clanner.antichat.entity;

/**
 * @author Clanner
 * 提示类型
 */
public enum Tip {


    TEST(2000, "测试"),
    REGISTER_SUCCESS(2001, "注册成功"),
    HAS_REGISTER(2002, "该账户已注冊"),
    ACCOUNT_OR_PASSWORD_ERROR(2003, "用户名或密码错误"),
    LOGIN_SUCCESS(2004, "登录成功"),
    LACK_KEY(2005, "缺少密钥"),
    SYSTEM_ERROR(2006, "系统繁忙，请稍后重试"),
    ACCOUNT_HAS_FREEZE(2007, "账号已冻结"),
    LOGOUT_SUCCESS(2008, "退出登录成功"),
    MODIFY_PASSWORD_SUCCESS(2009, "修改密码成功"),
    MODIFY_PASSWORD_Fail(2010, "原密码错误"),
    MODIFY_USER_INFO_SUCCESS(2011, "修改用户信息成功"),
    MODIFY_USER_INFO_FAIL(2012, "修改用户信息失败"),
    USER_NOT_EXIST(2013, "用户不存在"),
    GET_USER_INFO_SUCCESS(2014, "获取用户信息成功"),
    MODIFY_ANTI_ID_SUCCESS(2015, "修改AntiId成功"),
    MODIFY_ANTI_ID_FAIL(2016, "修改AntiId失败");

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


