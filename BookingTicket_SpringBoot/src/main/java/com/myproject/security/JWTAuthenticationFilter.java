package com.myproject.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final String SECRET = "KHOA";
	private final String TOKEN_PREFIX = "Bearer ";
	private final String HEADER_STRING = "Authorization";
	private final long EXPIRATION_TIME = 864_000_000;

	private final AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		UserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();
		String token = Jwts.builder()
			.setSubject(userDetails.getUsername())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, SECRET)
			.compact();

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		response.getWriter().write(TOKEN_PREFIX + token);
		response.getWriter().close();
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
	                                          AuthenticationException failed) throws IOException {
		response.setStatus(401);
		response.setContentType("authentication/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("unsuccessfulAuthentication");
		response.getWriter().flush();
		response.getWriter().close();
	}
}