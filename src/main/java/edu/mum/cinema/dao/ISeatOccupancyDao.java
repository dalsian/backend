package edu.mum.cinema.dao;

import java.util.List;
import java.util.Set;

import edu.mum.cinema.model.SeatOccupancy;

public interface ISeatOccupancyDao {
	Long save(SeatOccupancy seatOccupancy);
	SeatOccupancy get(Long id);
	List<SeatOccupancy> getBySectionPrice(Long sectionPriceId);
	void update(Long id, SeatOccupancy seatOccupancy);
	void delete(Long id);
	String checkStatus(Long id);
	int releaseSeatByUserId(Long id);
}
