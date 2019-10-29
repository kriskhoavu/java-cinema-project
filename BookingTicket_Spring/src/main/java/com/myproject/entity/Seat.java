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
	
	public Seat() {
	}

	public Seat(int id, String name, String description, int roomId, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.roomId = roomId;
		this.categoryId = categoryId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public SeatCategory getCategory() {
		return category;
	}

	public void setCategory(SeatCategory category) {
		this.category = category;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
