package com.myproject.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	public void onAuthenticationSuccess(HttpServletRequest request,
	                                    HttpServletResponse response, Authentication authentication)
		throws IOException, ServletException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("true");
		response.setHeader("Location", request.getContextPath() + "/");
		response.getWriter().flush();
		response.getWriter().close();
	}
}
