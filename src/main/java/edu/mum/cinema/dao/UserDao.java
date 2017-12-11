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

import edu.mum.cinema.model.User;

@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User get(Long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> getAll() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void update(Long id, User user) {
		Session session = sessionFactory.getCurrentSession();
		User userOld = session.byId(User.class).load(id);
		userOld.setFirstName(user.getFirstName());
		userOld.setLastName(user.getLastName());
		userOld.setDob(user.getDob());
		userOld.setPhone(user.getPhone());
		session.update(userOld);
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
	}
	
}
