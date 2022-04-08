package com.techtree.portal.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.techtree.common.api.ResultCode;
import com.techtree.common.exception.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: JwtUtil
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2820:53
 */


@Component
@Slf4j
public class JwtUtil {

    /**
     *
     * @param userId
     * @param userName
     * @return
     */
    public static String createToken(String userId, String userName) {


        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 30);
        Date expiresDate = nowTime.getTime();
        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("userName", userName)
                .sign(Algorithm.HMAC256(userId));
    }


    public static void verifyToken(String token, String secret) {
        DecodedJWT jwt = null;

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            Assert.fail(ResultCode.UNAUTHORIZED);
        }


    }

    public static String getAudience(String token) {
        String audience = null;
        audience = JWT.decode(token).getAudience().get(0);
        return audience;
    }

    public static Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }

}
