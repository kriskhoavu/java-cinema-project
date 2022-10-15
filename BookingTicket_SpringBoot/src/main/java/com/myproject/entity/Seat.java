package com.myproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "room_id")
	private int roomId;
	@Column(name = "category_id")
	private int categoryId;

	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private SeatCategory category;

	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	private Room room;

	@OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
	private Set<Ticket> tickets;
}
