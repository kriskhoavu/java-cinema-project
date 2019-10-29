package com.myproject.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String image;
	private String trailer;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "open_date")
	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	private int ratting;
	
	@OneToMany(mappedBy = "movie",
			fetch = FetchType.LAZY)
	private Set<Showtime> showtimes;
	
	@Column(name="is_playing")
	private boolean isPlaying;
	
	public Movie() {
	}

	public Movie(int id, String name, String image, String trailer, String description, Date openDate, int ratting, boolean isPlaying) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.trailer = trailer;
		this.description = description;
		this.openDate = openDate;
		this.ratting = ratting;
		this.isPlaying = isPlaying;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getRatting() {
		return ratting;
	}

	public void setRatting(int ratting) {
		this.ratting = ratting;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public Set<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Set<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
}
