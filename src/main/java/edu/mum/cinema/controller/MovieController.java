package edu.mum.cinema.controller;

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
@RestController
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	@PostMapping("/movie")
	public ResponseEntity<?> save(@RequestBody Movie movie) {
		long id = movieService.save(movie);
		return ResponseEntity.ok().body("Movie id " + id + " has been saved.");
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> get(@PathVariable("id") long id) {
		Movie movie = movieService.get(id);
		return ResponseEntity.ok().body(movie);
	}
	
	@GetMapping("/movie")
	public ResponseEntity<List<Movie>> getAll() {
		List<Movie> movieList = movieService.getAll();
		return ResponseEntity.ok().body(movieList);
	}
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Movie movie) {
		movieService.update(id, movie);
		return ResponseEntity.ok().body("Movie has been updated successfully.");
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		movieService.delete(id);
		return ResponseEntity.ok().body("Movie deleted");
	}
}
