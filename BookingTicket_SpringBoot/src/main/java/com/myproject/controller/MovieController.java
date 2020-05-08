package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.entity.Movie;
import com.myproject.service.MovieService;

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
