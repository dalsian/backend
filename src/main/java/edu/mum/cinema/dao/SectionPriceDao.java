package edu.mum.cinema.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.SectionPrice;

@Repository
public class SectionPriceDao implements ISectionPriceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SectionPrice get(Long id) {
		return sessionFactory.getCurrentSession().get(SectionPrice.class, id);
	}
}
