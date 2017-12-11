package edu.mum.cinema.dao.template;

import java.util.List;

import edu.mum.cinema.model.template.SeatTemplate;

public interface ISeatTemplateDao {
	SeatTemplate get(Long id);
	List<SeatTemplate> getAll();
}
