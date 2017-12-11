package edu.mum.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cinema.dao.IMovieDao;
import edu.mum.cinema.model.Movie;

@Service
@Transactional(readOnly = true)
public class MovieService implements IMovieService {

	@Autowired
	private IMovieDao movieDao;
	
	@Transactional
	@Override
	public long save(Movie movie) {
		return movieDao.save(movie);
	}

	@Override
	public Movie get(long id) {
		return movieDao.get(id);
	}

	@Override
	public List<Movie> getAll() {
		return movieDao.getAll();
	}

	@Transactional
	@Override
	public void update(long id, Movie movie) {
		movieDao.update(id, movie);
	}

	@Transactional
	@Override
	public void delete(long id) {
		movieDao.delete(id);
	}


}
