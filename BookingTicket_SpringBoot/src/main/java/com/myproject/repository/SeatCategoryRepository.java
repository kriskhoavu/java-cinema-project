package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.entity.SeatCategory;

@Repository
public interface SeatCategoryRepository extends JpaRepository<SeatCategory, Integer>{
	public SeatCategory findByName(String name);
}
