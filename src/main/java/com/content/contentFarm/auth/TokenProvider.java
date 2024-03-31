package com.content.contentFarm.auth;

import com.auth0.jwt.JWT;
import com.content.contentFarm.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static java.lang.System.currentTimeMillis;

public class TokenProvider {
    private static final long ACCESS_TOKEN_EXPIRATION_TIME = 432_000_000; //1_800_000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 432_000_000;

    private String secret = "topSecret";

    public String createAccessToken(User user) {
        return JWT.create()
                .withIssuedAt(new Date())
                .withSubject(String.valueOf(user.getId()))
                //.withArrayClaim(AUTHORITIES, getClaimsFromUser(userPrincipal))
                .withExpiresAt(new Date(currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME))
                .sign(HMAC512(secret.getBytes()));
    }
}
