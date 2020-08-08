package com.myproject.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cineplex")
@SuppressWarnings("deprecation")
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


