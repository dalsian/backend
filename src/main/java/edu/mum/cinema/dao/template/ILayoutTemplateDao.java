package edu.mum.cinema.dao.template;

import java.util.List;

import edu.mum.cinema.model.template.LayoutTemplate;

public interface ILayoutTemplateDao {
	LayoutTemplate get(Long id);
	List<LayoutTemplate> getAll();
}
