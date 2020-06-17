
package com.myproject.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.SignatureException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String TOKEN_PREFIX = "Bearer ";
	private final String HEADER_STRING = "Authorization";

	@Autowired
	private UserDetailsService userdetDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final String header = request.getHeader(HEADER_STRING);

		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			UsernamePasswordAuthenticationToken authenticationToken = getauthenticationtoken(request, header);
			
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
		}
		
		//done authorization => continue for next step
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getauthenticationtoken(HttpServletRequest request, String header) {
		try {
			String token = jwtUtil.getTokenFromHeader(header);
			String username = jwtUtil.extractUsername(token);
			
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userdetDetailsService.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(token, userDetails)) {
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