package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	Film findFilmByID(int filmID);

	List<Film> findFilmByKeyword(String keyword);

	List<Actor> findActorsByFilmID(int filmID);

	Actor findActorByID(int actorID);
	
	Film createFilm(Film film);
	
	boolean deleteFilm(Film film); 

	Film updateFilm( Film film);
	
	Film findCreatedFilmById(int filmID);
}
