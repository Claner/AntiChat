package com.clanner.antichat.utils;

/**
 * @author Clanner
 * 常量
 */
public class Constants {
    /**
     * JWT签发人
     */
    public static final String ISSUER = "Clanner";

    /**
     * 登录验证得jwt key
     */
    public static final String LOGIN_KEY = "login_Meiz";

    /**
     * 登录过期时间
     */
    public static final long EXP_MILLIS = 60 * 1000;

    public static final String separator = "-$$-";
}
