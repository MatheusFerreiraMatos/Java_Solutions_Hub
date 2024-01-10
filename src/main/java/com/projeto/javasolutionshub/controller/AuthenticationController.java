package com.projeto.javasolutionshub.controller;

import com.projeto.javasolutionshub.controller.dto.request.AuthenticationRequest;
import com.projeto.javasolutionshub.controller.dto.response.TokenJWTResponse;
import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity logIn(@RequestBody @Valid AuthenticationRequest authRequest) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((Member) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTResponse(tokenJWT));
    }

}
