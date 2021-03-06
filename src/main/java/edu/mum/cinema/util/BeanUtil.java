package edu.mum.cinema.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cinema.dto.Seat;
import edu.mum.cinema.model.Movie;
import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.User;
import edu.mum.cinema.model.template.SectionTemplate;
import edu.mum.cinema.service.IScheduleService;

public class BeanUtil {
	
	@Autowired
	private IScheduleService scheduleService;
	
	/**
	 * For swapping attributes between beans.  i.e entity <-> dto
	 * @param sectionPrices
	 * @return
	 */
	public static List<edu.mum.cinema.dto.Seat> toSeatDtoList(Set<SectionPrice> sectionPrices) {
		
		List<edu.mum.cinema.dto.Seat> seatDtoList = new ArrayList<>();
		
		for(SectionPrice sectionPrice : sectionPrices) {
			double price = sectionPrice.getPrice();
			
			for(SeatOccupancy seatOccupancy : sectionPrice.getSeatOccupancySet()) {
				
				edu.mum.cinema.dto.Seat seatDto = new edu.mum.cinema.dto.Seat();
				seatDto.setId(seatOccupancy.getId().toString());
				seatDto.setRowNum(seatOccupancy.getSeatTemplate().getSeatLabel());
				seatDto.setColumnNum(Integer.toString(seatOccupancy.getSeatTemplate().getPosY()));
				seatDto.setPrice(Double.toString(price));
				seatDto.setStatus(seatOccupancy.getStatus());
				
				seatDtoList.add(seatDto);
			}
			
		}
		
		return seatDtoList;
	}
	
	public static edu.mum.cinema.dto.User toUserDto(User user) {
		
		edu.mum.cinema.dto.User userDto = new edu.mum.cinema.dto.User();
		userDto.setId(user.getId().toString());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setRoleType(Integer.toString(user.getRoleType()));
		userDto.setUsername(user.getUserId());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}
	
	public static User toUser(edu.mum.cinema.dto.User userDto) {
		
		User user = new User();
		if(userDto.getId() != null && !userDto.getId().isEmpty()) {
			user.setId(Long.parseLong(userDto.getId()));
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setRoleType(userDto.getRoleType() != null ? Integer.parseInt(userDto.getRoleType()) : 1);
		user.setUserId(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	public static edu.mum.cinema.dto.Schedule toScheduleDto(Schedule schedule) {
		
		edu.mum.cinema.dto.Schedule scheduleDto = new edu.mum.cinema.dto.Schedule();
		if(schedule.getId() != null) {
			scheduleDto.setId(schedule.getId().toString());
		}
		scheduleDto.setDate(DateUtil.getDate(schedule.getDatetime()));
		scheduleDto.setTime(DateUtil.getTime(schedule.getDatetime()));
		scheduleDto.setMovieId(schedule.getMovieId().toString());
//		scheduleDto.setMovieName(schedule.getMovie().getName());
		scheduleDto.setTemplateId(schedule.getLayoutTemplate().getId().toString());
		scheduleDto.setTemplateName(schedule.getLayoutTemplate().getName());
		List<edu.mum.cinema.dto.SectionPrice> spDtos = new ArrayList<>();
		for (SectionPrice sectionPrice : schedule.getSectionPriceList()) {
			spDtos.add(BeanUtil.toSectionPriceDto(sectionPrice));
		}
		scheduleDto.setSectionPrices(spDtos);
		scheduleDto.setSeatList(BeanUtil.toSeatDtoList(schedule.getSectionPriceList())); 
		
		return scheduleDto;
	}
	
	public static Schedule toSchedule(edu.mum.cinema.dto.Schedule scheduleDto) {
		
		Schedule schedule = new Schedule();
		if (scheduleDto.getId() != null && !scheduleDto.getId().isEmpty()) {
			schedule.setId(Long.parseLong(scheduleDto.getId()));
		}
		schedule.setDatetime(DateUtil.toDate(scheduleDto.getDate()+" "+scheduleDto.getTime()));
		schedule.setMovieId(Long.parseLong(scheduleDto.getMovieId()));
		//layouttemplate
		//sectionprice
		
		return schedule;
	}
	
	public static edu.mum.cinema.dto.SectionPrice toSectionPriceDto(SectionPrice sectionPrice) {
		edu.mum.cinema.dto.SectionPrice spDto = new edu.mum.cinema.dto.SectionPrice();
		spDto.setId(sectionPrice.getId().toString());
		spDto.setSectionId(sectionPrice.getSectionTemplate().getId().toString());
		spDto.setSectionName(sectionPrice.getSectionLabel());
		spDto.setPrice(sectionPrice.getPrice());
		
		return spDto;
	}
	
	public static SectionPrice toSectionPrice(edu.mum.cinema.dto.SectionPrice spDto) {
		SectionPrice sp = new SectionPrice();
		if(spDto.getId() != null && !spDto.getId().isEmpty()) {
			sp.setId(Long.parseLong(spDto.getId()));
		}
		sp.setPrice(spDto.getPrice());
		return sp;
	}
	
	public static Movie toMovie(edu.mum.cinema.dto.Movie movieDto) {
		Movie movie = new Movie();
		if (movieDto.getId() != null && !movieDto.getId().isEmpty()) {
			movie.setId(Long.parseLong(movieDto.getId()));
		}
		movie.setName(movieDto.getTitle());
		movie.setDescription(movieDto.getDescription());
		movie.setGenre(movieDto.getGenre());
		movie.setImageurl(movieDto.getImageUrl());
		movie.setLength(Integer.parseInt(movieDto.getDuration()));
		
		
		return movie;
	}
	
	public static edu.mum.cinema.dto.Movie toMovieDto(Movie movie) {
		edu.mum.cinema.dto.Movie movieDto = new edu.mum.cinema.dto.Movie();
		movieDto.setId(movie.getId().toString());
		movieDto.setTitle(movie.getName());
		movieDto.setDescription(movie.getDescription());
		movieDto.setDuration(Integer.toString(movie.getLength()));
		movieDto.setGenre(movie.getGenre());
		movieDto.setImageUrl(movie.getImageurl());
		
		List<edu.mum.cinema.dto.Schedule> scheduleDtoList = new ArrayList<>();
		for(Schedule schedule : movie.getScheduleList()) {
			scheduleDtoList.add(toScheduleDto(schedule));
		}
		movieDto.setSchedules(scheduleDtoList);
		
		return movieDto;
	}
	
	public static edu.mum.cinema.dto.SectionTemplate toSectionTemplateDto(SectionTemplate template) {
		edu.mum.cinema.dto.SectionTemplate templateDto = new edu.mum.cinema.dto.SectionTemplate();
		templateDto.setId(template.getId().toString());
		templateDto.setSectionLabel(template.getSectionLabel());
		templateDto.setLayoutTemplateId(template.getLayoutTemplate().getId().toString());
	
		return templateDto;
	}
	
	public static Seat toSeatDto(SeatOccupancy seatOccupancy) {
		Seat seat = new Seat();
		seat.setId(seatOccupancy.getId().toString());
		seat.setColumnNum(Integer.toString(seatOccupancy.getSeatTemplate().getPosY())); 
		seat.setRowNum(seatOccupancy.getSeatTemplate().getSeatLabel());
		seat.setStatus(seatOccupancy.getStatus());
		return seat;
	}
	
	/**
	 * Don't have enough info from front end.  
	 * Need to retrieve from DB.
	 */
	@Deprecated
	public static SeatOccupancy toSeatOccupancy(Seat seat) {
		SeatOccupancy seatOccupancy = new SeatOccupancy();
		if (seat.getId() != null && !seat.getId().isEmpty()) {
			seatOccupancy.setId(Long.parseLong(seat.getId()));
		}
		seatOccupancy.setStatus(seat.getStatus());
		
		return seatOccupancy;
	}
}
