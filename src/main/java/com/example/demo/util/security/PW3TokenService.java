package com.example.demo.util.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class PW3TokenService {
    @Value("${pw3.senha.principal.geracao.token}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("DISCIPLINA PW3")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            JWTVerifier jwtv = JWT.require(algoritmo)
                    .withIssuer("DISCIPLINA PW3")
                    .build();
            return jwtv.verify(tokenJWT).getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
