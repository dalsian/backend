package edu.mum.cinema.dao;

import java.util.List;

import edu.mum.cinema.model.Ticket;

public interface ITicketDao {
	Long save(Ticket ticket);
	Ticket get(Long id);
//	List<Ticket> getAll();
//	void update(Long id, Ticket ticket);
	void delete(Long id);
}
