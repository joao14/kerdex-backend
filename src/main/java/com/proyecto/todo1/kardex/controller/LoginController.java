package com.proyecto.todo1.kardex.controller;

import com.proyecto.todo1.kardex.model.UserRequest;
import com.proyecto.todo1.kardex.services.KardexServices;
import com.proyecto.todo1.kardex.util.ApiResponse;
import com.proyecto.todo1.kardex.util.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    private static final String LOGGER_RESPONSE_FORMAT = "001-RES";
    private static final String LOGGER_REQUEST_FORMAT = "001-REQ";
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private KardexServices kardexService;

    @Value("${jwt.timeout}")
    private String timeout;

    @Value("${jwt.secret}")
    private String secret;

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody UserRequest userRequest) {
        System.out.println("Login...");
        ResponseEntity<Response> response = kardexService.login(userRequest.getUser(),userRequest.getPassword());
        String token = this.getJWTToken(userRequest.getUser(),userRequest.getPassword());
        response.getBody().getUser().setToken(token);
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    private String getJWTToken(String user, String password) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder().setId("softtekJWT").setSubject(user).setSubject(password)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Integer.valueOf(timeout)))// 6 minutos
                .signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
        logger.info("El token generado para el cliente " + user + " \t es" + token);
        return "Bearer " + token;
    }

}
