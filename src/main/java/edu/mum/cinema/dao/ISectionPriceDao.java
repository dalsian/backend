package edu.mum.cinema.dao;

import edu.mum.cinema.model.SectionPrice;

public interface ISectionPriceDao {
	Long save(SectionPrice sectionPrice);
	SectionPrice get(Long id);
}
