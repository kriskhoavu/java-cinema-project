package com.myproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String image;
	private String trailer;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "open_date")
	@Temporal(TemporalType.DATE)
	private Date openDate;

	@Column(name = "is_playing")
	private boolean isPlaying;

	private int ratting;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
	private Set<Showtime> showtimes;
}
