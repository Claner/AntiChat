package com.clanner.antichat.interceptors;

import com.clanner.antichat.utils.Constants;
import com.clanner.antichat.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Clanner
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        return parseToken(token);
    }

    private boolean parseToken(String token) {
        Claims claims = JwtUtil.getClaims(token, Constants.LOGIN_KEY);
        return true;
    }
}
