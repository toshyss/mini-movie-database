package com.example.movie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movie.domain.Movie;
import com.example.movie.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public String index(Model model) {
		List<Movie> movies = movieService.findAll();
		model.addAttribute("movies", movies);
		return "movies/index";
	}
	
	@GetMapping("new")
	public String newMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "movies/new";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		System.out.println(id);
		Movie movie = movieService.findOne(id);
		model.addAttribute("movie", movie);
		return "movies/edit";
	}
	
	@GetMapping("{id}")
	public String showDetail(@PathVariable Long id, Model model) {
		Movie movie = movieService.findOne(id);
		model.addAttribute("movie", movie);
		return "movies/showDetail";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "movies/new";
		movieService.save(movie);
		return "redirect:/movies";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "movies/edit";
		movie.setId(id);
		movieService.save(movie);
		return "redirect:/movies";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		movieService.delete(id);
		return "redirect:/movies";
	}
}
