package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.entity.Movie;
import com.myproject.service.IMovieService;

@RestController
@RequestMapping("api/movie")
@CrossOrigin("*")
public class MovieController {

	@Autowired
	IMovieService _movieService;

	@GetMapping("")
	public Object index(ModelMap model) {
		List<Movie> movies = _movieService.findAll();

		if (movies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	@GetMapping("playing/{isPlaying}")
	public Object playing(ModelMap model, @PathVariable boolean isPlaying) {
		List<Movie> movies = _movieService.findIsPlaying(isPlaying);

		if (movies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
}
