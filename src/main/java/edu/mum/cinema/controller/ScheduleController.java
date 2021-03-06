package edu.mum.cinema.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.template.LayoutTemplate;
import edu.mum.cinema.model.template.SectionTemplate;
import edu.mum.cinema.service.IMovieService;
import edu.mum.cinema.service.IScheduleService;
import edu.mum.cinema.service.template.ITemplateService;
import edu.mum.cinema.util.BeanUtil;

@RestController
public class ScheduleController {
	
	@Autowired
	private IScheduleService scheduleService;
	
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private ITemplateService templateService;
	
	@GetMapping("/seatsByScheduleId/{sid}")
	public ResponseEntity<List<edu.mum.cinema.dto.Seat>> getSeatOccupancyByScheduleId(@PathVariable("sid") long sid) {

		Schedule schedule = scheduleService.get(sid);
		List<edu.mum.cinema.dto.Seat> seatDtos = BeanUtil.toSeatDtoList(schedule.getSectionPriceList());
		
		return ResponseEntity.ok().body(seatDtos);
	}
	
	@PostMapping("/schedule")
	public ResponseEntity<?> save(@RequestBody edu.mum.cinema.dto.Schedule scheduleDto) {
		Schedule schedule = BeanUtil.toSchedule(scheduleDto);
		LayoutTemplate layout = templateService.getLayoutTemplate(Long.parseLong(scheduleDto.getTemplateId()));
		schedule.setLayoutTemplate(layout);
		Set<SectionPrice> sps = new HashSet<>();
		
		long id = scheduleService.save(schedule);
		
		for(edu.mum.cinema.dto.SectionPrice spDto : scheduleDto.getSectionPrices()) {
			SectionPrice sp = BeanUtil.toSectionPrice(spDto);
			sp.setSchedule(schedule);//Check ID
			
			SectionTemplate secTemp = templateService.getSectionTemplate(Long.parseLong(spDto.getSectionId()));
			sp.setSectionLabel(secTemp.getSectionLabel());
			sp.setSectionTemplate(secTemp);
			scheduleService.saveSectionPrice(sp);
			sps.add(sp);
		}
		schedule.setSectionPriceList(sps);
		scheduleService.update(schedule.getId(), schedule);
		scheduleService.createSeatOccupancies(schedule);
		
		return ResponseEntity.ok().body("Schedule id " + id + " has been saved.");
	}
	
	@GetMapping("/schedule/{id}")
	public ResponseEntity<edu.mum.cinema.dto.Schedule> get(@PathVariable("id") long id) {
		
		Schedule schedule = scheduleService.get(id);
		edu.mum.cinema.dto.Schedule scheduleDto = BeanUtil.toScheduleDto(schedule);
		
		return ResponseEntity.ok().body(scheduleDto);
	}
	
	@GetMapping("/schedule")
	public ResponseEntity<List<edu.mum.cinema.dto.Schedule>> getAll() {
		List<edu.mum.cinema.dto.Schedule> scheduleDtoList = new ArrayList<>();
		
		for(Schedule schedule : scheduleService.getAll()) {
			edu.mum.cinema.dto.Schedule scheduleDto = BeanUtil.toScheduleDto(schedule);
			scheduleDto.setMovieTitle(movieService.get(schedule.getMovieId()).getName());
			scheduleDtoList.add(scheduleDto);
		}
		
		return ResponseEntity.ok().body(scheduleDtoList);
	}
	
	@GetMapping("/scheduleByMovieId/{movieid}")
	public ResponseEntity<List<edu.mum.cinema.dto.Schedule>> getByMovieID(@PathVariable("movieid") long movieid) {
		
		List<edu.mum.cinema.dto.Schedule> scheduleDtoList = new ArrayList<>();
		
		for(Schedule schedule : scheduleService.getSchedulesByMovieId(movieid)) {
			
			edu.mum.cinema.dto.Schedule scheduleDto = BeanUtil.toScheduleDto(schedule);
			scheduleDtoList.add(scheduleDto);
		}
		
		return ResponseEntity.ok().body(scheduleDtoList);
	}
	
	//TODO
	@PutMapping("/schedule/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Schedule schedule) {
		scheduleService.update(id, schedule);
		return ResponseEntity.ok().body("Schedule has been updated successfully.");
	}
	
	@DeleteMapping("/schedule/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		scheduleService.delete(id);
		return ResponseEntity.ok().body("Schedule deleted");
	}
}
