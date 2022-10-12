package com.myproject.repository;

import com.myproject.model.entity.Cineplex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CineplexRepository extends JpaRepository<Cineplex, Integer> {

	// Pagination
	@Query("SELECT c FROM cineplex c")
	Page<Cineplex> findAllPaging(Pageable pageable);
}
