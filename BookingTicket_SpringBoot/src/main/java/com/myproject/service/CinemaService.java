package com.myproject.service;

import com.myproject.entity.Cinema;

import java.util.List;

public interface CinemaService {
	List<Cinema> findAll();

	Cinema findById(int id);

	void insert(Cinema model);

	void update(Cinema model);

	void delete(int id);
}
