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

import edu.mum.cinema.dao.template.ILayoutTemplateDao;
import edu.mum.cinema.model.template.LayoutTemplate;

@Repository
public class LayoutTemplateDao implements ILayoutTemplateDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public LayoutTemplate get(Long id) {
		return sessionFactory.getCurrentSession().get(LayoutTemplate.class, id);
	}

	@Override
	public List<LayoutTemplate> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<LayoutTemplate> cq = cb.createQuery(LayoutTemplate.class);
		Root<LayoutTemplate> root = cq.from(LayoutTemplate.class);
		cq.select(root);
		Query<LayoutTemplate> query = session.createQuery(cq);
		
		return query.getResultList();
	}
}
