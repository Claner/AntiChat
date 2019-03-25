package com.clanner.antichat.interceptors;

import com.clanner.antichat.entity.Response;
import com.clanner.antichat.service.dao.UserDao;
import com.clanner.antichat.utils.Constants;
import com.clanner.antichat.utils.JwtUtil;
import com.clanner.antichat.utils.ShadowUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Clanner
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.Authorization).substring("Bearer ".length());
        return parseToken(token, response);
    }

    private boolean parseToken(String token, HttpServletResponse response) throws IOException {
        if (token == null) {
            printJSON(response, "请携带token");
            return false;
        }
        Claims claims;
        try {
            claims = JwtUtil.getClaims(token, Constants.LOGIN_KEY);
        } catch (ExpiredJwtException e) {
            printJSON(response, "登陆已过期，请重新登录");
            return false;
        }
        if (!claims.getIssuer().equals(Constants.ISSUER)) {
            printJSON(response, "鉴权失败");
            return false;
        }
        String from = userDao.findTokenById(Integer.parseInt(claims.getId()));
        if (from == null || from.equals("")) {
            printJSON(response, "用户未登录");
            return false;
        }
        if (!ShadowUtil.MD5(claims.getSubject()).equals(from)) {
            printJSON(response, "账号已在别处登录");
            return false;
        }
        return true;
    }

    public static void printJSON(HttpServletResponse response, String note) throws IOException {
        Response message = new Response();
        message.setCode(4003);
        message.setMessage(note);
        response.setHeader("Content-Type", "application/json;charset = utf-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(message));
        response.flushBuffer();
    }
}
