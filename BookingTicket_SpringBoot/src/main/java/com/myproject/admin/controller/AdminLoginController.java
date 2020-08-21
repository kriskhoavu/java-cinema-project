package com.myproject.admin.controller;

import com.myproject.model.common.AuthenticationRequest;
import com.myproject.model.common.AuthenticationResponse;
import com.myproject.security.CustomUserDetailsService;
import com.myproject.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("auth")
public class AdminLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userdetDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@GetMapping("login")
	public String login(@RequestParam(required = false) String error, Model model) {
		if (error != null && error.equals("true")) {
			model.addAttribute("message", "Wrong username or password.");
		}
		return "user/login";
	}

	@PostMapping("authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest auth) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(auth.getEmail(), auth.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userdetDetailsService.loadUserByUsername(auth.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
