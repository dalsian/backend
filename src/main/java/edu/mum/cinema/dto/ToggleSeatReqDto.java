package edu.mum.cinema.dto;

import java.util.List;

public class ToggleSeatReqDto {
	private Long userId;
	private List<Long> selectedSeatOccupancyIds;
	
	public ToggleSeatReqDto() {
	}
	
	public ToggleSeatReqDto(Long userId, List<Long> selectedSeatOccupancyIds) {
		super();
		this.userId = userId;
		this.selectedSeatOccupancyIds = selectedSeatOccupancyIds;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getSelectedSeatOccupancyIds() {
		return selectedSeatOccupancyIds;
	}
	public void setSelectedSeatOccupancyIds(List<Long> selectedSeatOccupancyIds) {
		this.selectedSeatOccupancyIds = selectedSeatOccupancyIds;
	}
	
	
}
