package edu.mum.cinema.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import edu.mum.cinema.dto.OrderReqDto;
import edu.mum.cinema.dto.Seat;
import edu.mum.cinema.dto.ToggleSeatReqDto;
import edu.mum.cinema.model.SeatOccupancy;
import edu.mum.cinema.model.Ticket;
import edu.mum.cinema.model.User;

public class WebServiceConnector {
	
	public enum HTTP_METHOD {
		GET, POST, PUT, DELETE
	}

	public static final String URL_PREFIX = "http://localhost:8080/cinema/";
	
	public <Req, Res> Res callWebService(HTTP_METHOD httpMethod, 
										String uri, //name of REST API after server url prefix.
										Req req,  //request body. i.e. in createUser, req should be a User object to be saved
										Class<Res> resType) { //class type expected from response
		
		uri = URL_PREFIX + uri;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Res> responseEntity = null;
		
		System.out.println(uri);
		
		switch (httpMethod) {
		case GET : 
			responseEntity = restTemplate.getForEntity(uri, resType);
			break;
		case POST :
			responseEntity = restTemplate.postForEntity(uri, req, resType);
			break;
		case PUT :
			restTemplate.put(uri, req);
			break;
		case DELETE :
			restTemplate.delete(uri);
			break;
		default :
			break;
		}
		
		return (resType == null || responseEntity == null ? null : responseEntity.getBody());
	}
	
	/**
	 * Convert Object into JSON String.
	 * 
	 * @param t
	 * @return JsonString
	 */
	protected <T> String getObjectAsString(T t) {
		
		ObjectMapper mapper = new ObjectMapper();
		JSONPObject jsonObj = new JSONPObject("", t);
		
		String requestStr = null;
		
		try {
			requestStr = mapper.writeValueAsString(jsonObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return requestStr;
	}
	
	
	/*------------------------ Testing code starts ------------------------*/
	public List<User> getAllUsers() {
		
		User[] users = callWebService(HTTP_METHOD.GET, "user", null, User[].class);
		
		return Arrays.asList(users);
	}
	
	public void createUser(User user) {
		
		String response = callWebService(HTTP_METHOD.POST, 
						"user/", 
						user, 
						String.class);
		System.out.println(response);
	}
	
	public List<Long> toggleSeats(List<Long> seatOccupancyIds, Long userId) {
		/*  This only works for mapped string values. Need a wrapper object -> DTO
		//Request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		//Request body. with multiple values
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("selectedSeatIds", seatOccupancyIds);
		map.add("userId", 1);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		*/
		ToggleSeatReqDto reqDto = new ToggleSeatReqDto(userId, seatOccupancyIds);
		
		Long[] lockedList = callWebService(HTTP_METHOD.POST, "toggleSeatStatus", reqDto, Long[].class);
		
		return Arrays.asList(lockedList);
	}
	
	public SeatOccupancy getSeatOccupancy(Long id) {
		return callWebService(HTTP_METHOD.GET, "seatoccupancy/" + id, null, SeatOccupancy.class);
	}
	
	public void releaseSeatsByUserId(Long userId) {
		callWebService(HTTP_METHOD.PUT, "releaseSeatByUserId/" + userId, null, String.class);
	}
	
	public List<Ticket> orderTickets(List<Seat> seatList, Long userId) {
		
		OrderReqDto reqDto = new OrderReqDto(userId.toString(), seatList);
		Ticket[] ticketList = callWebService(HTTP_METHOD.POST, "orderTickets/", reqDto, Ticket[].class);
		
		return Arrays.asList(ticketList);
	}
	
	public static void main(String[] args) {
		WebServiceConnector connector = new WebServiceConnector();
		
		//--------------- Test release seats selected by a user --------------
		connector.releaseSeatsByUserId(1L);
		
		//--------------- Test add user -------------------
//		User u = new User();
//		u.setFirstName("Snowman");
//		u.setLastName("Santa");
//		u.setUserId("snow");
//		u.setPassword("****** need to hash password *******");
//		u.setPhone("911");
//		connector.createUser(u);
		
		//--------------- Test get all users -------------------
		List<User> users = connector.getAllUsers();
		for(User user : users) {
			System.out.println(user.getFirstName());
		}
		
		
		//--------------- Test toggleseats -------------------
		List<Long> selectedSeatIds = new ArrayList<>();
		selectedSeatIds.add(2L);
		selectedSeatIds.add(3L);
		selectedSeatIds.add(4L);
		List<Long> lockedList = connector.toggleSeats(selectedSeatIds, 1L);
		System.out.println("Locked ids...");
		for(Long id : lockedList) {
			System.out.println(id);
		}
		
		//---------------- Test booking ----------------------
		List<Seat> seats = new ArrayList<>();
		Seat s = new Seat();
		s.setId("1");
		seats.add(s);
		s = new Seat();
		s.setId("2");
		seats.add(s);
		s = new Seat();
		s.setId("3");
		seats.add(s);
		List<Ticket> ticketList = connector.orderTickets(seats, 1L);
		for(Ticket ticket : ticketList) {
			System.out.println(ticket.getSeatLabel() + " : $" + ticket.getPrice());
		}
		
		
	}
	/*------------------------ Testing code ends ------------------------*/
}
