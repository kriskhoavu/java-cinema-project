package com.myproject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myproject.model.entity.Cineplex;
import com.myproject.model.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {
	private int id;
	private String name;
	private String address;
	private String phone;
	private String description;
	private int cineplexId;
	private String image;
	private Cineplex cineplex;
	private Set<Room> rooms;
}
