
package com.keduit.amigo.controller;

import com.keduit.amigo.dto.ArticleDTO;
import com.keduit.amigo.dto.MovieDTO;

import com.keduit.amigo.entity.Movie;
import com.keduit.amigo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public String MovieList(Model model) {
        List<MovieDTO> movielist = movieService.getAllMovies();
        System.out.println("무비컨트롤러====="+ movielist);
        model.addAttribute("movies", movielist);
        return "movie-list";
}

    @GetMapping("/movies/{movieId}")
    public String ArticleDetails(@PathVariable Long movieId, Model model) {
        MovieDTO amovie = movieService.getMovieDetailsByMovieId(movieId);
        model.addAttribute("movieDTO", amovie);
        return "moviedetail";
}
}

