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

import edu.mum.cinema.model.Movie;
import edu.mum.cinema.service.IMovieService;
import edu.mum.cinema.util.BeanUtil;
@RestController
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	@PostMapping("/movie")
	public ResponseEntity<?> save(@RequestBody edu.mum.cinema.dto.Movie movieDto) {
		long id = movieService.save(BeanUtil.toMovie(movieDto));
		return ResponseEntity.ok().body("Movie id " + id + " has been saved.");
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<edu.mum.cinema.dto.Movie> get(@PathVariable("id") long id) {
		edu.mum.cinema.dto.Movie movieDto = BeanUtil.toMovieDto(movieService.get(id));
		return ResponseEntity.ok().body(movieDto);
	}
	
	@GetMapping("/movie")
	public ResponseEntity<List<edu.mum.cinema.dto.Movie>> getAll() {
		List<edu.mum.cinema.dto.Movie> movieDtoList = new ArrayList<>();
		for(Movie movie : movieService.getAll()) {
			movieDtoList.add(BeanUtil.toMovieDto(movie));
		}
		return ResponseEntity.ok().body(movieDtoList);
	}
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody edu.mum.cinema.dto.Movie movieDto) {
		movieService.update(id, BeanUtil.toMovie(movieDto));
		return ResponseEntity.ok().body("Movie has been updated successfully.");
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		movieService.delete(id);
		return ResponseEntity.ok().body("Movie deleted");
	}
	
	@GetMapping("/moviewithschedule/{date}")
	public ResponseEntity<List<edu.mum.cinema.dto.Movie>> get(@PathVariable("date") String date) {
		
		List<edu.mum.cinema.dto.Movie> movieDtoList = new ArrayList<>();
		for(Movie movie : movieService.getAll()) {
			movieDtoList.add(BeanUtil.toMovieDto(movie));
			//TODO filter by date
		}
		return ResponseEntity.ok().body(movieDtoList);
	}
}
