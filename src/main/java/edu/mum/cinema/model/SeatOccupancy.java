package edu.mum.cinema.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.cinema.model.template.SeatTemplate;

@Entity(name = "seat_occupancy")
public class SeatOccupancy {
	
    public final static String STATUS_FREE = "0";
    public final static String STATUS_SOLD = "1";
    public final static String STATUS_SELECTED = "2";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "locked_time")
	private Date lockedTime;

	@Column(name = "locked_by")
	private Long lockedBy;
	
	@ManyToOne
	@JoinColumn(name = "seat_template_id")
	private SeatTemplate seatTemplate;

//  Note : this will create circular dependency and stack overflow
//	@ManyToOne
//	@JoinColumn(name = "section_price_id")
//	private SectionPrice sectionPrice;
	
	@Column(name = "section_price_id")
	private Long sectionPriceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLockedTime() {
		return lockedTime;
	}

	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	public Long getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(Long lockedBy) {
		this.lockedBy = lockedBy;
	}

	public SeatTemplate getSeatTemplate() {
		return seatTemplate;
	}

	public void setSeatTemplate(SeatTemplate seatTemplate) {
		this.seatTemplate = seatTemplate;
	}

	public Long getSectionPriceId() {
		return sectionPriceId;
	}

	public void setSectionPriceId(Long sectionPriceId) {
		this.sectionPriceId = sectionPriceId;
	}

}
