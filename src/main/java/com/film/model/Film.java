package com.film.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private int productionYear;
	private String producer;
	private String genre;
	private String boxOfficeReceipts;

	/****************** getters e setters *******************/
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public String getProducer() {
		return producer;
	}

	public String getGenre() {
		return genre;
	}

	public String getboxOfficeReceipts() {
		return boxOfficeReceipts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setBoxOfficeReceipts(String boxOfficeReceipts) {
		this.boxOfficeReceipts = boxOfficeReceipts;
	}

}
