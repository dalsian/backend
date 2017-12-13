package edu.mum.cinema.service;

import java.util.List;

import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;

public interface IScheduleService {
	
	/**
	 * Create a new schedule.
	 * Layout must be selected.
	 * @param schedule
	 * @return
	 */
	long save(Schedule schedule);
	Schedule get(long id);
	List<Schedule> getAll();
	List<Schedule> getSchedulesByMovieId(Long movieId);
	void update(long id, Schedule schedule);
	void delete(long id);
	List<SeatOccupancy> getSeatOccupanciesBySchedule(long id);
	void createSeatOccupancies(Schedule schedule);
	void saveSectionPrice(SectionPrice secPrice);
}
