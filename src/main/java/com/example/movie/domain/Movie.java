package com.example.movie.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String running_time;
	private Date production_year;
	private String country_of_origin;
	private String distributing_agency;
	private String cast;
	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRunningTime() {
		return running_time;
	}
	public void setRunningTime(String running_time) {
		this.running_time = running_time;
	}
	public Date getProdutionYear() {
		return production_year;
	}
	public void setProductionYear(Date production_year) {
		this.production_year = production_year;
	}
	public String getRunning_time() {
		return running_time;
	}
	public void setRunning_time(String running_time) {
		this.running_time = running_time;
	}
	public Date getProduction_year() {
		return production_year;
	}
	public void setProduction_year(Date production_year) {
		this.production_year = production_year;
	}
	public String getCountry_of_origin() {
		return country_of_origin;
	}
	public void setCountry_of_origin(String country_of_origin) {
		this.country_of_origin = country_of_origin;
	}
	public String getDistributing_agency() {
		return distributing_agency;
	}
	public void setDistributing_agency(String distributing_agency) {
		this.distributing_agency = distributing_agency;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + 
				", running_time=" + running_time + 
				", production_year=" + production_year + 
				", country_of_origin=" + country_of_origin + 
				", distributing_agency=" + distributing_agency +
				", cast=" + cast + ", image=" + image;
	}
}
