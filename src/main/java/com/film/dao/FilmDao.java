package com.film.dao;

import java.util.List;

import com.film.model.Film;

public interface FilmDao {

	public void save(Film f);

	public List<Film> getByProducer(String producer);

	public void deleteFilm(Long id);

	public void updateFilm(Film film, Long id);

	public List<Film> getAllFilm();

}
