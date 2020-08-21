package com.myproject.repository;

import com.myproject.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT e FROM movies e WHERE e.isPlaying = :isPlaying")
    public List<Movie> findMoviePlaying(@Param("isPlaying") boolean isPlaying);
}
