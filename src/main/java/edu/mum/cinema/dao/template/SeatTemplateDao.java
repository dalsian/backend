package edu.mum.cinema.dao.template;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.template.SeatTemplate;

@Repository
public class SeatTemplateDao implements ISeatTemplateDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SeatTemplate get(Long id) {
		return sessionFactory.getCurrentSession().get(SeatTemplate.class, id);
	}

	@Override
	public List<SeatTemplate> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<SeatTemplate> cq = cb.createQuery(SeatTemplate.class);
		Root<SeatTemplate> root = cq.from(SeatTemplate.class);
		cq.select(root);
		Query<SeatTemplate> query = session.createQuery(cq);
		
		return query.getResultList();
	}
}
