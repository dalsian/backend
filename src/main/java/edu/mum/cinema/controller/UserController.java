package edu.mum.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cinema.model.User;
import edu.mum.cinema.service.IUserService;
import edu.mum.cinema.util.BeanUtil;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody edu.mum.cinema.dto.User userDto) {
		long id = userService.save(BeanUtil.toUser(userDto));
		return ResponseEntity.ok().body("User id " + id + " has been saved.");
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<edu.mum.cinema.dto.User> get(@PathVariable("id") long id) {
		edu.mum.cinema.dto.User userDto = BeanUtil.toUserDto(userService.get(id));
		return ResponseEntity.ok().body(userDto);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<edu.mum.cinema.dto.User>> getAll() {
		
		List<edu.mum.cinema.dto.User> userDtoList = new ArrayList<>();
		
		for(User user : userService.getAll()) {
			edu.mum.cinema.dto.User userDto = BeanUtil.toUserDto(user);
			userDtoList.add(userDto);
		}
		
		return ResponseEntity.ok().body(userDtoList);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody edu.mum.cinema.dto.User userDto) {
		userService.update(id, BeanUtil.toUser(userDto));
		return ResponseEntity.ok().body("User has been updated successfully.");
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		userService.delete(id);
		return ResponseEntity.ok().body("User deleted");
	}
}
