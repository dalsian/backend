package edu.mum.cinema.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import edu.mum.cinema.model.Movie;
import edu.mum.cinema.model.Schedule;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.SectionPrice;
import edu.mum.cinema.model.User;

public class BeanUtil {
	
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
		if(userDto.getId() != null) {
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
		scheduleDto.setId(schedule.getId().toString());
		scheduleDto.setDate(DateUtil.getDate(schedule.getDatetime()));
		scheduleDto.setTime(DateUtil.getTime(schedule.getDatetime()));
		scheduleDto.setMovieId(schedule.getMovie().getId().toString());
		scheduleDto.setMovieName(schedule.getMovie().getName());
		scheduleDto.setLayoutId(schedule.getLayoutTemplate().getId().toString());
		scheduleDto.setLayoutName(schedule.getLayoutTemplate().getName());
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
		schedule.setId(Long.parseLong(scheduleDto.getId()));
		schedule.setDatetime(DateUtil.toDate(scheduleDto.getDate()+" "+scheduleDto.getTime()));
		//schedule.setMovie(scheduleDto.getMovie()); only title
		//layouttemplate
		//sectionprice
		
		return schedule;
	}
	
	public static edu.mum.cinema.dto.SectionPrice toSectionPriceDto(SectionPrice sectionPrice) {
		edu.mum.cinema.dto.SectionPrice spDto = new edu.mum.cinema.dto.SectionPrice();
		spDto.setId(sectionPrice.getId().toString());
		spDto.setSection(sectionPrice.getSectionLabel());
		spDto.setPrice(sectionPrice.getPrice());
		
		return spDto;
	}
	
	public static Movie toMovie() {
		Movie movie = new Movie();
		return null;
	}
}
