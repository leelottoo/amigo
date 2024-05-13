package com.keduit.amigo.repository;

import com.keduit.amigo.entity.Director;
import com.keduit.amigo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByName(String directorName);
    Director findByMovieTitle(String movieTitle);
}
