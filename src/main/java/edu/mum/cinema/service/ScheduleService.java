package edu.mum.cinema.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cinema.dao.IScheduleDao;
import edu.mum.cinema.dao.ISeatOccupancyDao;
import edu.mum.cinema.dao.ISectionPriceDao;
import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.template.LayoutTemplate;
import edu.mum.cinema.model.template.SeatTemplate;

@Service
@Transactional(readOnly = true)
public class ScheduleService implements IScheduleService {

	@Autowired
	private IScheduleDao scheduleDao;
	
	@Autowired
	private ISectionPriceDao sectionPriceDao;
	
	@Autowired
	private ISeatOccupancyDao seatOccupancyDao;
	
	/**
	 * Create a new schedule. 
	 */
	@Transactional
	@Override
	public long save(Schedule schedule) {
		
		Long scheduleId = scheduleDao.save(schedule);
		
		return scheduleId;
	}

	/**
	 * Create new seat occupancies for a specific schedule.  Layout must be selected
	 * in the schedule.
	 */
	@Transactional
	public void createSeatOccupancies(Schedule schedule) {
		
		for(SectionPrice sectionPrice : schedule.getSectionPriceList()) {
			
			Set<SeatOccupancy> seatOccupancySet = new HashSet<>();
			
			for(SeatTemplate seatTemplate : sectionPrice.getSectionTemplate().getSeatTemplates()) {
				
				SeatOccupancy seatOccupancy = new SeatOccupancy();
				seatOccupancy.setStatus(SeatOccupancy.STATUS_FREE);
				seatOccupancy.setSectionPriceId(sectionPrice.getId());
				seatOccupancy.setSeatTemplate(seatTemplate);
				seatOccupancyDao.save(seatOccupancy);
				
				seatOccupancySet.add(seatOccupancy);
			}
			
			sectionPrice.setSeatOccupancySet(seatOccupancySet);
			sectionPriceDao.save(sectionPrice);
		}
	}

	@Override
	public Schedule get(long id) {
		return scheduleDao.get(id);
	}

	@Override
	public List<Schedule> getAll() {
		return scheduleDao.getAll();
	}

	@Transactional
	@Override
	public void update(long id, Schedule schedule) {
		scheduleDao.update(id, schedule);
	}

	@Transactional
	@Override
	public void delete(long id) {
		scheduleDao.delete(id);
	}

	@Override
	public List<Schedule> getSchedulesByMovieId(Long movieId) {
		return scheduleDao.getByMovieId(movieId);
	}
	
	@Override
	public List<SeatOccupancy> getSeatOccupanciesBySchedule(long id) {
		List<SeatOccupancy> seatOccupancyList = new ArrayList<>();
		Schedule schedule = scheduleDao.get(id);
		for (SectionPrice sp : schedule.getSectionPriceList()) {
			for (SeatOccupancy so : sp.getSeatOccupancySet()) {
				seatOccupancyList.add(so);
			}
		}
		return seatOccupancyList;
	}

	@Transactional
	@Override
	public void saveSectionPrice(SectionPrice secPrice) {
		sectionPriceDao.save(secPrice);
	}
	
}
