package com.myproject.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myproject.dto.CustomUserDetails;
import com.myproject.entity.Role;
import com.myproject.entity.User;
import com.myproject.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServices implements UserDetailsService {

	@Autowired
	private UserRepository _userRepository;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		// Lấy ra user từ database có email trùng với email đăng nhập
		User user = _userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Không tìm thấy tài khoản!");
		}

		// Tạo đối tượng chứa danh sách quyền
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		// Lấy ra role của user
		Role role = user.getRole();
		// Thêm tên quyền vào danh sách
		authorities.add(new SimpleGrantedAuthority(role.getName()));

		// Tạo đối tượng CustoUserDetails để chứa thông tin người dùng
		// sau khi đăng nhập
		CustomUserDetails userDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
		userDetails.setFullname(user.getFullname());
		userDetails.setAvatar(user.getAvatar());
		userDetails.setId(user.getId());

		return userDetails;
	}

}
