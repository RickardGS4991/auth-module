package com.example.tandapp.auth.infrastructure.security.filters;

import com.example.tandapp.auth.domain.ports.out.IAccessTokenMaker;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IAccessTokenMaker tokenMaker;

    public JwtAuthenticationFilter(IAccessTokenMaker tokenMaker) {
        this.tokenMaker = tokenMaker;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {
            tokenMaker.validateAccessToken(token);

            String email = tokenMaker.getEmailUser(token);
            UUID userId = tokenMaker.getUserId(token);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    email,
                    userId,
                    new ArrayList<>()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);
        } catch (Exception e) {
            System.out.println("Fallo en autenticación: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
