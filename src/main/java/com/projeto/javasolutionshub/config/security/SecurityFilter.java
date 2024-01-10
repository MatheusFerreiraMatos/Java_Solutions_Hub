package com.projeto.javasolutionshub.config.security;

import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.service.MemberService;
import com.projeto.javasolutionshub.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MemberService memberService;

    @Override // Função executada uma única vez por requisição
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recoverToken(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            Member member = memberService.getMember(subject);

            var authentication = new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response); // Chama o proximo filter
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        return authorizationHeader != null ? authorizationHeader.replace("Bearer ", "") : null;
    }

}
