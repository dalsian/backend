package edu.mum.cinema.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cinema.dao.IOrderDao;
import edu.mum.cinema.dao.ISeatOccupancyDao;
import edu.mum.cinema.dao.ISectionPriceDao;
import edu.mum.cinema.dao.ITicketDao;
import edu.mum.cinema.dao.TicketDao;
import edu.mum.cinema.model.TicketOrder;
import edu.mum.cinema.util.StringUtil;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.Ticket;

@Service
@Transactional(readOnly = true)
public class BookingService implements IBookingService {
	
	@Autowired
	private ISeatOccupancyDao seatOccupancyDao;
	
	@Autowired
	private ISectionPriceDao sectionPriceDao;
	
	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private ITicketDao ticketDao;

	@Transactional
	@Override
	public List<Long> toggleSeatStatus(Set<SeatOccupancy> seatOccupancies, Long userId) {
		//TODO do we really need a list of SeatOccupancy objects?
		List<Long> lockedList = new ArrayList<>();
		
		for(SeatOccupancy seatOccupancy : seatOccupancies) {
			//check for status
			SeatOccupancy recent = seatOccupancyDao.get(seatOccupancy.getId());
			if (recent.getStatus().equals(SeatOccupancy.STATUS_SELECTED)) {
				if (recent.getLockedBy() == userId) {
					changeStatus(seatOccupancy, userId);
					seatOccupancyDao.update(seatOccupancy.getId(), seatOccupancy);
				} else {
					lockedList.add(recent.getId());
				}
			} else {
				//update
				changeStatus(seatOccupancy, userId);
				seatOccupancyDao.update(seatOccupancy.getId(), seatOccupancy);
			}
			
		}
		return lockedList;
	}
	
	@Transactional
	@Override
	public List<Long> toggleSeatStatus(List<Long> selectedSeatIds, Long userId) {
	
		List<Long> lockedList = new ArrayList<>();
		
		for(Long selectedSeatId : selectedSeatIds) {
			//check for status
			SeatOccupancy recent = seatOccupancyDao.get(selectedSeatId);
			if (recent.getStatus().equals(SeatOccupancy.STATUS_SELECTED)) {
				if (recent.getLockedBy() == userId) {
					changeStatus(recent, userId);
					seatOccupancyDao.update(recent.getId(), recent);
				} else {
					lockedList.add(recent.getId());
				}
			} else {
				//update
				changeStatus(recent, userId);
				seatOccupancyDao.update(recent.getId(), recent);
			}
			
		}
		return lockedList;
	}
	
	private void changeStatus(SeatOccupancy seatOccupancy, Long userId) {
		if (seatOccupancy.getStatus().equals(SeatOccupancy.STATUS_FREE)) {
			seatOccupancy.setStatus(SeatOccupancy.STATUS_SELECTED);
			seatOccupancy.setLockedBy(userId);
			seatOccupancy.setLockedTime(new Date());
		} else if (seatOccupancy.getStatus().equals(SeatOccupancy.STATUS_SELECTED)) {
			seatOccupancy.setStatus(SeatOccupancy.STATUS_FREE);
			seatOccupancy.setLockedBy(null);
			seatOccupancy.setLockedTime(null);
		}
	}
	
	@Transactional
	@Override
	public int releaseAllSeatsByUser(Long userId) {
		return seatOccupancyDao.releaseSeatByUserId(userId);
	}

	@Transactional
	@Override
	public List<Ticket> orderTickets(List<SeatOccupancy> seatOccupancies, Long userId) {
		
		TicketOrder order = new TicketOrder();
		order.setOrderNumber(StringUtil.generateOrderNumber());
		order.setOrderDatetime(new Date());
		order.setTotalPrice(0);
		Long orderId = orderDao.save(order);
		order.setId(orderId);
		
		List<Ticket> ticketList = new ArrayList<>();
		
		for(SeatOccupancy seatOccupancy : seatOccupancies) {
			
//			if(seatOccupancy.getStatus().equals(SeatOccupancy.STATUS_SELECTED) && 
//											seatOccupancy.getLockedBy().equals(userId)) {
				
				//Mark as sold.
				seatOccupancy.setStatus(SeatOccupancy.STATUS_SOLD);
				seatOccupancyDao.update(seatOccupancy.getId(), seatOccupancy);
				
				SectionPrice sectionPrice = sectionPriceDao.get(seatOccupancy.getSectionPriceId());
				
				Ticket ticket = new Ticket();
				ticket.setTicketNumber(StringUtil.generateTicketNumber());
				ticket.setPrice(sectionPrice.getPrice());
				ticket.setSeatLabel(seatOccupancy.getSeatTemplate().getSeatLabel());
				ticket.setOrderId(orderId);
				ticket.setScheduleId(sectionPrice.getSchedule().getId());
				ticket.setSectionPriceId(sectionPrice.getId());
				ticket.setId(ticketDao.save(ticket));
		
				ticketList.add(ticket);
//			} 
			
			
		}
		
		//order.setTicketList(ticketList);
		orderDao.update(order.getId(), order);
		
		return ticketList;
	}

	@Override
	public List<SeatOccupancy> getSeatOccupanciesBySectionPrice(Long sectionPriceId) {
		return seatOccupancyDao.getBySectionPrice(sectionPriceId);
	}

	@Override
	public SeatOccupancy getSeatOccupancy(Long id) {
		return seatOccupancyDao.get(id);
	}


}
