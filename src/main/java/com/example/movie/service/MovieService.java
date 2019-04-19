package com.example.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.domain.Movie;
import com.example.movie.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
//	public Optional<Movie> findOne(Long id) {
//		return movieRepository.findById(id);
//	}
	
	public Movie findOne(Long id) {
		return movieRepository.findById(id).orElseThrow(null);
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void delete(Long id) {
		movieRepository.deleteById(id);
	}
}
