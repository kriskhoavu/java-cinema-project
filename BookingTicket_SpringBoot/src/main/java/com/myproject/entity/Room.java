package com.myproject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "room",
			fetch = FetchType.LAZY)
	private Set<Seat> seats;
	
	@OneToMany(mappedBy = "room",
			fetch = FetchType.LAZY)
	private Set<Showtime> showtimes;

	public Room() {
	}

	public Room(int id, String name, int seatCount, int cinemaId) {
		super();
		this.id = id;
		this.name = name;
		this.seatCount = seatCount;
		this.cinemaId = cinemaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Set<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Set<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
}
