package edu.mum.cinema.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cinema.model.SeatOccupancy;

@Repository
public class SeatOccupancyDao implements ISeatOccupancyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(SeatOccupancy t) {
		sessionFactory.getCurrentSession().save(t);
		return t.getId();
	}

	@Override
	public void update(Long id, SeatOccupancy t) {
		Session session = sessionFactory.getCurrentSession();
		SeatOccupancy existing = session.byId(SeatOccupancy.class).load(id);
		existing.setStatus(t.getStatus());
		existing.setLockedBy(t.getLockedBy());
		existing.setLockedTime(t.getLockedTime());
		session.update(existing);
		
		//No need to update seatTemplateId or sectionPriceId as it can mess up.
	}

	@Override
	public SeatOccupancy get(Long id) {
		return sessionFactory.getCurrentSession().get(SeatOccupancy.class, id);
	}

	@Override
	public List<SeatOccupancy> getBySectionPrice(Long sectionPriceId) {
		Session session = sessionFactory.getCurrentSession();
		
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<SeatOccupancy> cq = cb.createQuery(SeatOccupancy.class);
		
		Root<SeatOccupancy> root = cq.from(SeatOccupancy.class);
											//TODO sectionPriceId or section_price_id?
		cq.select(root).where(cb.equal(root.get("sectionPriceId"), sectionPriceId));
		Query<SeatOccupancy> query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		SeatOccupancy seatOccupancy = session.byId(SeatOccupancy.class).load(id);
		session.delete(seatOccupancy);
	}

	@Override
	public String checkStatus(Long id) {
		return sessionFactory.getCurrentSession().get(SeatOccupancy.class, id).getStatus();
	}

	@Override
	public int releaseSeatByUserId(Long userId) {
		Session session = sessionFactory.getCurrentSession();

		NativeQuery query = session.createNativeQuery("UPDATE seat_occupancy SET status = :status, " +
									"locked_by = NULL, locked_time = NULL WHERE locked_by = :userid");
		query.setParameter("status", SeatOccupancy.STATUS_FREE);
		query.setParameter("userid", 1);

		return query.executeUpdate();
	}

}
