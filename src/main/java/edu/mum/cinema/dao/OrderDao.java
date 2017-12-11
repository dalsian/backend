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

import edu.mum.cinema.model.TicketOrder;

@Repository
public class OrderDao implements IOrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(TicketOrder t) {
		sessionFactory.getCurrentSession().save(t);
		return t.getId();
	}

	@Override
	public void update(Long id, TicketOrder t) {
		Session session = sessionFactory.getCurrentSession();
		TicketOrder existing = session.byId(TicketOrder.class).load(id);
		existing.setOrderNumber(t.getOrderNumber());
		existing.setOrderDatetime(t.getOrderDatetime());
		existing.setTicketList(t.getTicketList());
		session.update(existing);
	}

	@Override
	public TicketOrder get(Long id) {
		return sessionFactory.getCurrentSession().get(TicketOrder.class, id);
	}

	@Override
	public List<TicketOrder> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TicketOrder> cq = cb.createQuery(TicketOrder.class);
		Root<TicketOrder> root = cq.from(TicketOrder.class);
		cq.select(root);
		Query<TicketOrder> query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		TicketOrder order = session.byId(TicketOrder.class).load(id);
		session.delete(order);
	}

}
