package edu.mum.cinema.model;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.mum.cinema.model.template.LayoutTemplate;

@Entity(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datetime;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "layout_template_id")
	private LayoutTemplate layoutTemplate;
	
	@OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
	@JsonManagedReference
	private Set<SectionPrice> sectionPriceList; //had to change to set to avoid multi bag fetch error
	
	
	public Schedule() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public LayoutTemplate getLayoutTemplate() {
		return layoutTemplate;
	}
	public void setLayoutTemplate(LayoutTemplate layoutTemplate) {
		this.layoutTemplate = layoutTemplate;
	}
	public Set<SectionPrice> getSectionPriceList() {
		return sectionPriceList;
	}
	public void setSectionPriceList(Set<SectionPrice> sectionPriceList) {
		this.sectionPriceList = sectionPriceList;
	}
	
}
