package com.myproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
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
