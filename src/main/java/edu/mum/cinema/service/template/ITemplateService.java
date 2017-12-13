package edu.mum.cinema.service.template;

import java.util.List;

import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.template.LayoutTemplate;
import edu.mum.cinema.model.template.SeatTemplate;
import edu.mum.cinema.model.template.SectionTemplate;

public interface ITemplateService {
	
	LayoutTemplate getLayoutTemplate(long id);
	List<LayoutTemplate> getAllLayoutTemplate();
	
	SectionTemplate getSectionTemplate(long id);
	List<SectionTemplate> getAllSectionTemplate();
	
	SeatTemplate getSeatTemplate(long id);
	List<SeatTemplate> getAllSeatTemplate();
}
