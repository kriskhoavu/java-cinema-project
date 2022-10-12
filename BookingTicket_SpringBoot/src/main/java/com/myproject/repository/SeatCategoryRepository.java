package com.myproject.repository;

import com.myproject.model.entity.SeatCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatCategoryRepository extends JpaRepository<SeatCategory, Integer> {
	SeatCategory findByName(String name);
}
