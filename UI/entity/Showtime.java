package com.myclass.entity;

import java.sql.Time;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "showtimes")
public class Showtime {
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "open_date")
	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	@Column(name = "open_hours")
	@Temporal(TemporalType.TIME)
	private Date openHours;
	
	private float price; 
	
	@Column(name = "movie_time")
	private int movieTime;
	
	@Column(name = "room_id")
	private int roomId;
	
	@Column(name = "movie_id")
	private int movieId;
	
	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", insertable = false, updatable = false)
	private Movie movie;
	
	@OneToMany(mappedBy = "showtime",
			fetch = FetchType.LAZY)
	private Set<Ticket> tickets;
	
	public Showtime() {}

	public Showtime(int id, Date openDate, Date openHours, float price, int movieTime, int roomId, int movieId) {
		super();
		this.id = id;
		this.openDate = openDate;
		this.openHours = openHours;
		this.price = price;
		this.movieTime = movieTime;
		this.roomId = roomId;
		this.movieId = movieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getOpenHours() {
		return openHours;
	}

	public void setOpenHours(Time openHours) {
		this.openHours = openHours;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
