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
     * 登录过期时间(单位毫秒)
     */
    public static final long EXP_MILLIS = 3 * 24 * 60 * 60 * 1000;

    public static final String Authorization = "Authorization";

    public static final int PUB_KEY = 333;
    public static final int PRI_KEY = 444;

    public static final String separator = "-$$-";
}
