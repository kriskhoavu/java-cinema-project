package com.myproject.repository;

import java.util.List;

import com.myproject.entity.User;

public interface UserRepository {
	public List<User> findAll();

	public User findById(String id);

	public boolean save(User model);

	public boolean delete(String id);

	public User findByEmail(String email);
}
