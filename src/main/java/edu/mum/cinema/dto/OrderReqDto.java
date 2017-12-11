package edu.mum.cinema.dto;

import java.util.List;

import edu.mum.cinema.model.SeatOccupancy;

public class OrderReqDto {

	private Long userId;
	private List<SeatOccupancy> seatOccupancyList;
	
	public OrderReqDto() {
		
	}
	
	public OrderReqDto(Long userId, List<SeatOccupancy> seatOccupancyList) {
		super();
		this.userId = userId;
		this.seatOccupancyList = seatOccupancyList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<SeatOccupancy> getSeatOccupancyList() {
		return seatOccupancyList;
	}

	public void setSeatOccupancyList(List<SeatOccupancy> seatOccupancyList) {
		this.seatOccupancyList = seatOccupancyList;
	}
}
