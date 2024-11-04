package org.example.neo4j.controller;

import org.example.neo4j.dao.MovieEntity;
import org.example.neo4j.repository.MovieRepository;
import org.example.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity movieEntity) {
        return movieService.save(movieEntity);
    }

    @GetMapping(value = {"","/"},produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEntity> getAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping("/by-title")
    Mono<MovieEntity> byTitle(@RequestParam("title") String title) {
        return movieService.findMovieByTitle(title);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return movieService.deleteMovieById(id);
    }


}
