package edu.mum.cinema.dao;

import java.util.Date;
import java.util.List;

import edu.mum.cinema.model.Movie;

public interface IMovieDao {
	Long save(Movie movie);
	Movie get(Long id);
	List<Movie> getAll();
	void update(Long id, Movie movie);
	void delete(Long id);
}
