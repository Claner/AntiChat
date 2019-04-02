package com.clanner.antichat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author Clanner
 * jwt工具类
 */
public class JwtUtil {
    /**
     * @param id        用户id
     * @param issuer    签发者
     * @param subject   接收者
     * @param audience  备用
     * @param ttlMillis 过期时间
     * @return jwt
     */
    public static String createJWT(String id, String issuer, String subject, String audience, long ttlMillis, String key) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public static Claims getClaims(String jwt, String key) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();
    }

    public static int getId(String jwtToken) {
        jwtToken = jwtToken.substring("Bearer ".length());
        Claims claims = getClaims(jwtToken, Constants.LOGIN_KEY);
        return Integer.parseInt(claims.getId());
    }
}

