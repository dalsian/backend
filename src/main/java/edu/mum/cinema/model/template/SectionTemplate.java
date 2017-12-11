package edu.mum.cinema.model.template;

import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo( 
//		generator = ObjectIdGenerators.PropertyGenerator.class, 
//		property = "id")
@Entity(name = "section_template")
public class SectionTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "section_label")
	private String sectionLabel;
	
	@Column(name = "pos_x")
	private int posX;
	
	@Column(name = "pos_y")
	private int posY;
	
	private int height;
	private int width;
	private String color;
	
	@OneToMany(mappedBy = "sectionTemplate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
	private List<SeatTemplate> seatTemplates;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "layout_template_id")
	@JsonBackReference
	private LayoutTemplate layoutTemplate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSectionLabel() {
		return sectionLabel;
	}
	public void setSectionLabel(String sectionLabel) {
		this.sectionLabel = sectionLabel;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LayoutTemplate getLayoutTemplate() {
		return layoutTemplate;
	}
	public void setLayoutTemplate(LayoutTemplate layoutTemplate) {
		this.layoutTemplate = layoutTemplate;
	}
	public List<SeatTemplate> getSeatTemplates() {
		return seatTemplates;
	}
	public void setSeatTemplates(List<SeatTemplate> seatTemplates) {
		this.seatTemplates = seatTemplates;
	}
	
}
