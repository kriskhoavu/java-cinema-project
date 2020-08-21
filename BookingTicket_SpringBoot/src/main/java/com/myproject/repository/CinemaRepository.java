package com.myproject.repository;

import com.myproject.model.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{
	@Query("SELECT e FROM cinemas e")
	public Page<Cinema> findAllPaging(Pageable pageable);
}
