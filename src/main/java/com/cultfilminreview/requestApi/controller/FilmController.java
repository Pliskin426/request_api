package com.cultfilminreview.requestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cultfilminreview.requestApi.entity.Film;
import com.cultfilminreview.requestApi.service.FilmService;

@RestController
@RequestMapping("/film/")
public class FilmController {

	@Autowired
	private FilmService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createFilm(@RequestBody Film film, @PathVariable Long requestId, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.createFilm(film), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/film/{filmId}/", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFilm(@PathVariable Long filmId) {
		service.deleteFilm(filmId);
		return new ResponseEntity<Object>("Deleted film with id:" + filmId, HttpStatus.OK);
	}
	
}
