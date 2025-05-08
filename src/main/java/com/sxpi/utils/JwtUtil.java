package com.sxpi.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author happy
 * @create 2024-01-05-{TIME}
 */
@Slf4j
public class JwtUtil {

    // 有效期
    public static final Long JWT_TTL = 60 * 60 * 24 * 1000L * 24 * 30;     // 30天

    // 设置密钥铭文
    public static final String JWT_KEY = "sxpi@examizaiton";

    // 这里用 Set 作为示例，实际应用中可能使用 Redis 等
    private static Set<String> blacklistedTokens = new HashSet<>();

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw
     * @param subject   token要存放的数据，（json格式）
     * @return
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());       // 设置过期时间
        return builder.compact();
    }

    /**
     * 生成jtw
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis     token超时时间
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    /**
     *
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);     // 设置过期时间
        return builder.compact();
    }

    /**
     * 生成SecretKey
     * @param secret
     * @return
     */
    private static SecretKey generateKey(String secret) {
        byte[] encodedKey = Base64.decodeBase64(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generateKey("jinan_20220511jinan_20220511jinan_20220511jinan_20220511");
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)                                // 唯一的ID
                .setSubject(subject)                        // 主题 可以是json数据
                .setIssuer("sxpi")                            // 签发者
                .setIssuedAt(now)                           // 签发时间
//                .signWith(signatureAlgorithm, secretKey)    // 使用HS256对称加密算法签名，第二个参数时密钥
                .signWith(secretKey, signatureAlgorithm)    // 使用HS256对称加密算法签名，第二个参数时密钥
                .setExpiration(expDate);
    }



    public static void main(String[] args) throws Exception {
//        Claims claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1Zjk2YTA1OTIxYWQ0YTc5YmJhOGE5MTk3NDhjMGE5YSIsInN1YiI6IjM1IiwiaXNzIjoic2ciLCJpYXQiOjE3MDcxMjQ1MzYsImV4cCI6MTcwNzIxMDkzNn0.lL1OyxeOEeFOIXzr6v4pJq63hihEc35xzYFeJNHLfxE");
//        String subject = claims.getSubject();
//        System.out.println(subject);

        String jwt = createJWT(String.valueOf(3));
        System.out.println(jwt);

//        Claims claims1 = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YmU0Y2NmM2ZmYzQ0YTkzODE4YTNjYmUyZDQxYTdlZiIsInN1YiI6IjM1IiwiaXNzIjoic2ciLCJpYXQiOjE3MDcxMzI4NDgsImV4cCI6MTcwNzEzMjg0OH0.h0xb3uvOoaWR6e1dKCcobbTDis_d6Z9kopmBGpIdqG4");
//        String subject1 = claims1.getSubject();
//        System.out.println(subject1);
    }

    /**
     * 解析
     * @param jwt
     * @return
     * @throws Exception
     */
//    public static Claims parseJWT(String jwt) throws Exception{
////        SecretKey secretKey = generateKey("jinan_20220511jinan_20220511jinan_20220511jinan_20220511");
////        return Jwts.parser()
////                .setSigningKey(secretKey)
////                .parseClaimsJws(jwt)
////                .getBody();
//
//    }

    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generateKey("jinan_20220511jinan_20220511jinan_20220511jinan_20220511");
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();

        // 从 JWT 中获取 `jti`
        String jti = claims.getId();

        // 检查 `jti` 是否在黑名单中
        if (isBlacklisted(jti)) {
            throw new Exception("Token is blacklisted");
        }

        return claims;
    }

    public static void blacklistToken(String jti) {
        blacklistedTokens.add(jti);
    }

    public static boolean isBlacklisted(String jti) {
        return blacklistedTokens.contains(jti);
    }

    // 将 token 加入黑名单
//    public static void blacklistToken(String jti, long duration, TimeUnit timeUnit) {
////        redisTemplate.opsForValue().set(jti, "blacklisted", duration, timeUnit);
//        redisCache.setCacheObject(jti, "blacklisted", (int) duration, timeUnit);
//    }
//
//    // 检查 token 是否在黑名单中
//    public static boolean isBlacklisted(String jti) {
//        return redisCache.hasKey(jti);
//    }
}

