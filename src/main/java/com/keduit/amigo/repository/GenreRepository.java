package com.keduit.amigo.repository;

import com.keduit.amigo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenreName(String genreName);
}
