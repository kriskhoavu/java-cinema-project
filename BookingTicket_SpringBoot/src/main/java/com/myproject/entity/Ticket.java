package com.myproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float total;

	@Temporal(TemporalType.DATE)
	@Column(name = "booking_date")
	private Date bookingDate;

	@Column(name = "showtime_id")
	private int showtimeId;

	@Column(name = "seat_id")
	private int seatId;

	@Column(name = "user_id")
	private String userId;

	@ManyToOne
	@JoinColumn(name = "showtime_id", insertable = false, updatable = false)
	private Showtime showtime;

	@ManyToOne
	@JoinColumn(name = "seat_id", insertable = false, updatable = false)
	private Seat seat;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
}
