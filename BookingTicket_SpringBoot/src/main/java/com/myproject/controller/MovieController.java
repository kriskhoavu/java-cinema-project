package com.myproject.controller;

import com.myproject.model.entity.Movie;
import com.myproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("playing/{isPlaying}")
	public Object playing(@PathVariable boolean isPlaying) {
		return new ResponseEntity<List<Movie>>(
			movieService.findMoviePlaying(isPlaying), HttpStatus.OK);
	}
}
