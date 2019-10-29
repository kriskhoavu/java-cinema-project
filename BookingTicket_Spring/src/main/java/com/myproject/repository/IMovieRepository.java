package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

	@Query("SELECT M FROM movies M WHERE M.isPlaying = :isPlaying")
	List<Movie> findByIsPlaying(@Param("isPlaying") boolean isPlaying);
}
