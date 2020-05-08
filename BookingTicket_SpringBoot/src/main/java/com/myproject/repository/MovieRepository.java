package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query("SELECT e FROM movies e WHERE e.isPlaying = :isPlaying")
	public List<Movie> findMoviePlaying(@Param("isPlaying") boolean isPlaying);
}
