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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "cinemas")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;

	@Column(length = 20)
	private String phone;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "cineplex_id")
	private int cineplexId;

	private String image;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cineplex_id", insertable = false, updatable = false)
	private Cineplex cineplex;

	@JsonIgnore
	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	private Set<Room> rooms;

	public Cinema() {
	}

	public Cinema(int id, String name, String address, String phone, String description, int cineplexId, String image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
		this.cineplexId = cineplexId;
		this.image = image;
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

	public int getCineplexId() {
		return cineplexId;
	}

	public void setCineplexId(int cinemaId) {
		this.cineplexId = cinemaId;
	}

	public Cineplex getCineplex() {
		return cineplex;
	}

	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
