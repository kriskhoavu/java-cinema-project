package com.myproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
