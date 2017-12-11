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

import edu.mum.cinema.model.template.SectionTemplate;

@Repository
public class SectionTemplateDao implements ISectionTemplateDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SectionTemplate get(Long id) {
		return sessionFactory.getCurrentSession().get(SectionTemplate.class, id);
	}

	@Override
	public List<SectionTemplate> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<SectionTemplate> cq = cb.createQuery(SectionTemplate.class);
		Root<SectionTemplate> root = cq.from(SectionTemplate.class);
		cq.select(root);
		Query<SectionTemplate> query = session.createQuery(cq);
		
		return query.getResultList();
	}
}

