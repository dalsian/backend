package edu.mum.cinema.dto;

import java.util.List;

public class Schedule {
	
	private String id;
	private String date;
	private String time;
	private String movieId;
	private String movieName;
	private String layoutId;
	private String layoutName;
    private List<SectionPrice> sectionPrices;
	private List<Seat> seatList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<SectionPrice> getSectionPrices() {
		return sectionPrices;
	}
	public void setSectionPrices(List<SectionPrice> sectionPrices) {
		this.sectionPrices = sectionPrices;
	}
	public List<Seat> getSeatList() {
		return seatList;
	}
	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	
	
}
