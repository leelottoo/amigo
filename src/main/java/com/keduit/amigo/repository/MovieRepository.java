package com.keduit.amigo.repository;

import com.keduit.amigo.entity.Genre;
import com.keduit.amigo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenreId(Genre genre);
    Movie findByTitle(String title);

    Movie findByMovieId(Long movie);

}
