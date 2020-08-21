package com.myproject.security;

import com.myproject.model.entity.User;
import com.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		
		CustomUserDetails userDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
		userDetails.setFullname(user.getFullname());
		userDetails.setAvatar(user.getAvatar());
		
		return userDetails;
	}
}
