package com.cultfilminreview.requestApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cultfilminreview.requestApi.entity.Film;
import com.cultfilminreview.requestApi.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository repo;
	
	public Film createFilm(Film film) {
		return repo.save(film);
	}
	
	public void deleteFilm(Long filmId) {
		repo.delete(filmId);
	}

}
