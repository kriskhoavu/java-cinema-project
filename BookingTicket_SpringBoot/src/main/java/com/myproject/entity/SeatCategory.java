package com.myproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "seat_categories")
public class SeatCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Seat> seats;
}
