package com.myproject.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final String SECRET = "KHOA";
	private final String TOKEN_PREFIX = "Bearer ";
	private final String HEADER_STRING = "Authorization";
	private final long EXPIRATION_TIME = 864_000_000;

	private AuthenticationManager _authenticationManager;

	// Su dung constructor de inject
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this._authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		// request.getInputStream() sử dụng để lấy thông tin email, password từ request(
		// dạng chuỗi JSON)
		// ObjectMapper().readValue() sử dụng để chuyển chuổi JSON thành đối tượng Java
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			Authentication authentication = _authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			return authentication;
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
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		response.getWriter().write(TOKEN_PREFIX + token);
		response.getWriter().close();
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(401);
		response.setContentType("authentication/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("unsuccessfulAuthentication");
		response.getWriter().flush();
		response.getWriter().close();
	}
}