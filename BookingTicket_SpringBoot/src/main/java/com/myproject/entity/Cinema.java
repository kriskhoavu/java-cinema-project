package com.myproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
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

}
