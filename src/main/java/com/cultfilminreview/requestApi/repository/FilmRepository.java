package com.cultfilminreview.requestApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.cultfilminreview.requestApi.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

}
