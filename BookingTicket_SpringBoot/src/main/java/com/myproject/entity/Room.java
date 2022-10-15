package com.myproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(name = "seat_count")
	private int seatCount;
	@Column(name = "cinema_id")
	private int cinemaId;

	@ManyToOne
	@JoinColumn(name = "cinema_id", insertable = false, updatable = false)
	private Cinema cinema;

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private Set<Seat> seats;

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private Set<Showtime> showtimes;
}
