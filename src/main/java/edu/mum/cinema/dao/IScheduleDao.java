package edu.mum.cinema.dao;

import java.util.List;

import edu.mum.cinema.model.Schedule;

public interface IScheduleDao {
	Long save(Schedule schedule);
	Schedule get(Long id);
	List<Schedule> getAll();
	List<Schedule> getByMovieId(Long movieId);
	void update(Long id, Schedule schedule);
	void delete(Long id);

}
