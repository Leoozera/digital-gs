package com.fiap.gs.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fiap.gs.models.Credencial;
import com.fiap.gs.models.Token;
import com.fiap.gs.models.Usuario;
import com.fiap.gs.repository.UsuarioRepository;


@Service
public class TokenService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Value("jwt.secret")
    String secret;

    public Token generateToken( Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var token = JWT.create()
                    .withSubject(credencial.email())
                    .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                    .withIssuer("PiggyBank")
                    .sign(alg);

        return new Token(token, "JWT", "Bearer");
    }

    public Usuario valideAndGetUserBy(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var email =  JWT.require(alg)
            .withIssuer("PiggyBank")
            .build()
            .verify(token)
            .getSubject()
            ;

        return usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}