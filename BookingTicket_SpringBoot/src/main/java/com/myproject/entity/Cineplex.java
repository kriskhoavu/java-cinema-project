package com.myproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity(name = "cineplex")
public class Cineplex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "para name is required.")
	private String name;

	@NotBlank(message = "para logo is required.")
	private String logo;

	@JsonIgnore
	@OneToMany(mappedBy = "cineplex", fetch = FetchType.LAZY)
	private Set<Cinema> cinemas;
}


