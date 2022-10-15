package com.myproject.service.impl;

import com.myproject.entity.Cinema;
import com.myproject.repository.CinemaRepository;
import com.myproject.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
	private final CinemaRepository cinemaRepository;

	@Override
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}

	@Override
	public Cinema findById(int id) {
		return cinemaRepository.findById(id).orElse(null);

	}

	@Override
	public void insert(Cinema model) {
		cinemaRepository.save(model);
	}

	@Override
	public void update(Cinema model) {
		cinemaRepository.findById(model.getId()).ifPresent(cinemaRepository::save);
	}

	@Override
	public void delete(int id) {
		cinemaRepository.deleteById(id);
	}
}
