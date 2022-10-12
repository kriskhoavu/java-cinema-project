package com.myproject.security;

import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	private final String HEADER_STRING = "Authorization";

	private final UserDetailsService userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsService customUserDetailsService) {
		super(authenticationManager);
		this.userDetailsService = customUserDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		final String header = request.getHeader(HEADER_STRING);
		if (!JWTUtil.verifyHeader(header)) {
			response.setStatus(401);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("Login failed");
			response.getWriter().close();
			return;
		}

		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request, header);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request, String header) {
		try {
			String token = JWTUtil.getTokenFromHeader(header);
			String username = JWTUtil.extractUsername(token);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (JWTUtil.validateToken(token, userDetails)) {
					return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				}
			}
			return null;

		} catch (SignatureException e) {
			System.out.println("Invalid JWT signature");
			e.printStackTrace();
			return null;
		}
	}
}