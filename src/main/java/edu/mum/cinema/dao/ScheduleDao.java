package edu.mum.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.Movie;
import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;

@Repository
public class ScheduleDao implements IScheduleDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(Schedule t) {
		sessionFactory.getCurrentSession().save(t);
		return t.getId();
	}

	@Override
	public void update(Long id, Schedule t) {
		Session session = sessionFactory.getCurrentSession();
		Schedule existing = session.byId(Schedule.class).load(id);
		existing.setMovie(t.getMovie());
		existing.setDatetime(t.getDatetime());
		session.update(existing);
	}

	@Override
	public Schedule get(Long id) {
		return sessionFactory.getCurrentSession().get(Schedule.class, id);
	}

	@Override
	public List<Schedule> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Schedule> cq = cb.createQuery(Schedule.class);
		Root<Schedule> root = cq.from(Schedule.class);
		cq.select(root);
		Query<Schedule> query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Schedule schedule = session.byId(Schedule.class).load(id);
		session.delete(schedule);
	}

	@Override
	public List<Schedule> getByMovieId(Long movieId) {
		
		Session session = sessionFactory.getCurrentSession();
//
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Schedule> cq = cb.createQuery(Schedule.class);
		
		Metamodel metamodel = session.getMetamodel();
		EntityType<Schedule> schedule_ = metamodel.entity(Schedule.class);
		EntityType<Movie> movie_ = metamodel.entity(Movie.class);
		
		Root<Schedule> root = cq.from(schedule_);
		Join movie = root.join(schedule_.getSingularAttribute("movie"));
		movie.on(cb.equal(movie.get(movie_.getSingularAttribute("id")), movieId));
		
		List<Schedule> result = session.createQuery(cq).getResultList();
		
		return result;
	}

}
