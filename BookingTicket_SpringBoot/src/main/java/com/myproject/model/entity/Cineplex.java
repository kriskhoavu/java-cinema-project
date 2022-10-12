package com.myproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


