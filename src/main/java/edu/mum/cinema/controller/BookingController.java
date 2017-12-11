package edu.mum.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cinema.dto.OrderReqDto;
import edu.mum.cinema.dto.ToggleSeatReqDto;
import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.Ticket;
import edu.mum.cinema.service.IBookingService;

@RestController
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	@GetMapping("/seatoccupancybysectionprice/{id}")
	public ResponseEntity<List<SeatOccupancy>> getSeatOccupancyBySectionPriceId(@PathVariable("id") long id) {
		List<SeatOccupancy> seatOccupancy = bookingService.getSeatOccupanciesBySectionPrice(id);
		return ResponseEntity.ok().body(seatOccupancy);
	}
	
	@GetMapping("/seatoccupancy/{id}")
	public ResponseEntity<SeatOccupancy> getSeatOccupancy(@PathVariable("id") long id) {
		SeatOccupancy seatOccupancy = bookingService.getSeatOccupancy(id);
		return ResponseEntity.ok().body(seatOccupancy);
	}
	
	@PostMapping("/toggleSeatStatus")
	public ResponseEntity<List<Long>> save(@RequestBody ToggleSeatReqDto reqDto) {
		List<Long> lockedIds = bookingService.toggleSeatStatus(reqDto.getSelectedSeatOccupancyIds(), reqDto.getUserId());
		return ResponseEntity.ok().body(lockedIds);
	}
	
	@PutMapping("/releaseSeatByUserId/{userId}")
	public ResponseEntity<?> update(@PathVariable("userId") long userId) {
		int numReleased = bookingService.releaseAllSeatsByUser(userId);
		return ResponseEntity.ok().body(numReleased + " seats released for user id : " + userId);
	}
	
	@PostMapping("/orderTickets")
	public ResponseEntity<List<Ticket>> save(@RequestBody OrderReqDto reqDto) {
		
		List<Ticket> ticketList = bookingService.orderTickets(reqDto.getSeatOccupancyList(), reqDto.getUserId());
		
		return ResponseEntity.ok().body(ticketList);
	}
	
}
