package edu.mum.cinema.service.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cinema.dao.template.ILayoutTemplateDao;
import edu.mum.cinema.dao.template.ISeatTemplateDao;
import edu.mum.cinema.dao.template.ISectionTemplateDao;
import edu.mum.cinema.model.template.LayoutTemplate;
import edu.mum.cinema.model.template.SeatTemplate;
import edu.mum.cinema.model.template.SectionTemplate;

@Service
@Transactional(readOnly = true)
public class TemplateService implements ITemplateService {
	
	@Autowired
	private ILayoutTemplateDao layoutTemplateDao;
	
	@Autowired
	private ISectionTemplateDao sectionTemplateDao;
	
	@Autowired
	private ISeatTemplateDao seatTemplateDao;

	@Override
	public LayoutTemplate getLayoutTemplate(long id) {
		return layoutTemplateDao.get(id);
	}

	@Override
	public List<LayoutTemplate> getAllLayoutTemplate() {
		
		return layoutTemplateDao.getAll();
	}

	@Override
	public SectionTemplate getSectionTemplate(long id) {
		
		return sectionTemplateDao.get(id);
	}

	@Override
	public List<SectionTemplate> getAllSectionTemplate() {
		
		return sectionTemplateDao.getAll();
	}

	@Override
	public SeatTemplate getSeatTemplate(long id) {
		return seatTemplateDao.get(id);
	}

	@Override
	public List<SeatTemplate> getAllSeatTemplate() {
		return seatTemplateDao.getAll();
	}

}
