package edu.mum.cinema.service;

import java.util.List;

import edu.mum.cinema.model.Schedule;

public interface IScheduleService {
	
	/**
	 * Create a new schedule.
	 * Layout must be selected.
	 * Must contain a list of SectionPrice.
	 * No need to add SeatOccupancy list to SectionPrice... they will be generated automatically.
	 * @param schedule
	 * @return
	 */
	long save(Schedule schedule);
	Schedule get(long id);
	List<Schedule> getAll();
	List<Schedule> getSchedulesByMovieId(Long movieId);
	void update(long id, Schedule schedule);
	void delete(long id);
}
