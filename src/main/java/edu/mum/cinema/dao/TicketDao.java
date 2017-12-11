package edu.mum.cinema.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.Ticket;

@Repository
public class TicketDao implements ITicketDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(Ticket t) {
		sessionFactory.getCurrentSession().save(t);
		return t.getId();
	}

//	@Override
//	public void update(Long id, Ticket t) {
//		Session session = sessionFactory.getCurrentSession();
//		Ticket existing = session.byId(Ticket.class).load(id);
//		existing.setTicketNumber(t.getTicketNumber());
//		session.update(existing);
//	}

	@Override
	public Ticket get(Long id) {
		return sessionFactory.getCurrentSession().get(Ticket.class, id);
	}

//	@Override
//	public List<Ticket> getAll() {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
//		Root<Ticket> root = cq.from(Ticket.class);
//		cq.select(root);
//		Query<Ticket> query = session.createQuery(cq);
//		
//		return query.getResultList();
//	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Ticket ticket = session.byId(Ticket.class).load(id);
		session.delete(ticket);
	}
}