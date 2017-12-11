package edu.mum.cinema.dao.template;

import java.util.List;

import edu.mum.cinema.model.template.SectionTemplate;

public interface ISectionTemplateDao {
	SectionTemplate get(Long id);
	List<SectionTemplate> getAll();
}
