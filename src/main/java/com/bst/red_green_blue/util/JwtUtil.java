package com.bst.red_green_blue.util;

import com.bst.red_green_blue.common.Constant;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

    public static String getTokenHeader(String rawToken) {
        return AUTHORIZATION_HEADER_PREFIX + rawToken;
    }

    public static String getAuthorizationHeaderPrefix() {
        return AUTHORIZATION_HEADER_PREFIX;
    }

    /**
     * 创建token，带参数
     *
     * @param id
     * @param issuer
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JwtUtil.getAuthorizationHeaderPrefix());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    /**
     * 生成token，不带从参数
     *
     * @param id
     * @return
     */
    public static String createJWT(String id, String subject) {
        String token = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + Constant.Consts.JWT_EXPIRE)) //失效时间
                .signWith(SignatureAlgorithm.HS512, Constant.Consts.SECRET)
                .compact();
        return token;
    }

    /**
     * 简单点
     *
     * @param subject
     * @return
     */
    public static String createJWT(String subject) {
        String token = Jwts.builder()
                .setSubject(subject)
                .setId(Constant.Consts.STATUS_VALID)
                //失效时间
                .setExpiration(new Date(System.currentTimeMillis() + Constant.Consts.JWT_EXPIRE))
                .signWith(SignatureAlgorithm.HS512, Constant.Consts.SECRET)
                .compact();
        return token;
    }

    public static Claims parseJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(Constant.Consts.SECRET)
                .parseClaimsJws(jwt).getBody();
//        String phoneNumber = Jwts.parser().setSigningKey(Constant.Consts.SECRET).parseClaimsJws(token).getBody().getSubject();

        return claims;
    }
}