package edu.mum.cinema.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.mum.cinema.model.template.SectionTemplate;

@Entity(name = "section_price")
public class SectionPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "section_label")
	private String sectionLabel;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id") 
	@JsonBackReference
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name = "section_template_id")
	private SectionTemplate sectionTemplate;
	
	@OneToMany(mappedBy = "sectionPriceId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Column(nullable = true)
	private Set<SeatOccupancy> seatOccupancySet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public SectionTemplate getSectionTemplate() {
		return sectionTemplate;
	}

	public void setSectionTemplate(SectionTemplate sectionTemplate) {
		this.sectionTemplate = sectionTemplate;
	}

	public Set<SeatOccupancy> getSeatOccupancySet() {
		return seatOccupancySet;
	}

	public void setSeatOccupancySet(Set<SeatOccupancy> seatOccupancyList) {
		this.seatOccupancySet = seatOccupancyList;
	}

	public String getSectionLabel() {
		return sectionLabel;
	}

	public void setSectionLabel(String sectionLabel) {
		this.sectionLabel = sectionLabel;
	}
	
	
}
