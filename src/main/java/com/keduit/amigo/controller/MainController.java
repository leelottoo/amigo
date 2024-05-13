package com.keduit.amigo.controller;

import com.keduit.amigo.dto.MovieDTO;
import com.keduit.amigo.service.MainService;
import com.keduit.amigo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String MovieList(Model model) {
        List<MovieDTO> movielist = mainService.getAllMovies();
        model.addAttribute("movies", movielist);
        return "main";
    }
}
