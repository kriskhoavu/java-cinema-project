package com.myproject.security;

import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";

    @Autowired
    private UserDetailsService _userDetailsService;

    @Autowired
    private JWTUtil _jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final String header = request.getHeader(HEADER_STRING);

        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationtoken(request, header);

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationtoken(HttpServletRequest request, String header) {
        try {
            String token = _jwtUtil.getTokenFromHeader(header);
            String username = _jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = _userDetailsService.loadUserByUsername(username);

                if (_jwtUtil.validateToken(token, userDetails)) {
                    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                }
            }
            return null;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature.");
            e.printStackTrace();
            return null;
        }
    }
}