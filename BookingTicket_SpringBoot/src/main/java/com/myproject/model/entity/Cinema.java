package com.myproject.model.entity;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cinemas")
public class Cinema {

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
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
