package edu.mum.cinema.service;

import java.util.Date;
import java.util.List;

import edu.mum.cinema.model.Movie;

public interface IMovieService {
	long save(Movie movie);
	Movie get(long id);
	List<Movie> getAll();
	void update(long id, Movie movie);
	void delete(long id);
}
