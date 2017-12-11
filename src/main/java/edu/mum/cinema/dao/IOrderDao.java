package edu.mum.cinema.dao;

import java.util.List;

import edu.mum.cinema.model.TicketOrder;

public interface IOrderDao {
	Long save(TicketOrder order);
	TicketOrder get(Long id);
	List<TicketOrder> getAll();
	void update(Long id, TicketOrder order);
	void delete(Long id);
}
