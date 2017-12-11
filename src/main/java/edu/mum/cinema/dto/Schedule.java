package edu.mum.cinema.dto;

import java.util.List;

public class Schedule {
	
	private String id;
	private String date;
	private String time;
	private String movieId;
	private String movieTitle;
	private String templateId;
	private String templateName;
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
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieName) {
		this.movieTitle = movieName;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String layoutId) {
		this.templateId = layoutId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String layoutName) {
		this.templateName = layoutName;
	}
	
	
}
