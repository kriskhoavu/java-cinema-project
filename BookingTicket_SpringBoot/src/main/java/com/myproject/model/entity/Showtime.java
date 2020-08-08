package com.myproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(mappedBy = "showtime", fetch = FetchType.LAZY)
	private Set<Ticket> tickets;
}
