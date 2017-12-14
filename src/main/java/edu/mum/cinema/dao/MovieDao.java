package edu.mum.cinema.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.Movie;
import edu.mum.cinema.model.User;

@Repository
public class MovieDao implements IMovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(Movie t) {
		sessionFactory.getCurrentSession().save(t);
		return t.getId();
	}

	@Override
	public void update(Long id, Movie t) {
		Session session = sessionFactory.getCurrentSession();
		Movie existing = session.byId(Movie.class).load(id);
		existing.setName(t.getName());
		existing.setGenre(t.getGenre());
		existing.setDescription(t.getDescription());
		existing.setLength(t.getLength());
		existing.setImageurl(t.getImageurl());
		session.update(existing);
	}

	@Override
	public Movie get(Long id) {
		return sessionFactory.getCurrentSession().get(Movie.class, id);
	}

	@Override
	public List<Movie> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		Query<Movie> query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Movie movie = session.byId(Movie.class).load(id);
		session.delete(movie);
	}

}
