package edu.mum.cinema.service;

import java.util.List;
import java.util.Set;

import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.Ticket;

public interface IBookingService {

	/**
	 * Select/Release a list of seats.  Do not need to update status, locked by, locked time... etc.
	 * The service will take care of it.  
	 * 
	 * @return List of SeatOccupancy ids that are locked by other user.
	 */
	List<Long> toggleSeatStatus(Set<SeatOccupancy> seatOccupancies, Long userId);
	
	List<Long> toggleSeatStatus(List<Long> selectedSeatIds, Long userId);
	
	/**
	 * Release all seats selected by a user.
	 */
	int releaseAllSeatsByUser(Long userId);
	
	List<Ticket> orderTickets(List<SeatOccupancy> seatOccupancies, Long userId);
	
	List<SeatOccupancy> getSeatOccupanciesBySectionPrice(Long sectionPriceId);
	
	SeatOccupancy getSeatOccupancy(Long id);
	
}
