package com.keduit.amigo.service;


import com.keduit.amigo.repository.MovieRepository;
import com.keduit.amigo.dto.AdditionalInfoDTO;

import com.keduit.amigo.dto.MovieDTO;
import com.keduit.amigo.entity.*;

import com.keduit.amigo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
   // private final GenreRepository genreRepository;
    private final AdditionalInfoRepository additionalInfoRepository;
    private final CountryRepository countryRepository;
    private final DirectorRepository directorRepository;


    //리스트 형태로 전부 가져오기
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieList = new ArrayList<>();
//        Movie movie = new Movie();
        for( Movie movie : movies){

            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setMovieId(movie.getMovieId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setRunningTime(movie.getRunningTime());
            movieDTO.setReleaseDate(movie.getReleaseDate());
            movieDTO.setRatingName(movie.getRatingName());
            movieDTO.setScore(movie.getScore());
            movieDTO.setGenreName(movie.getGenreId().getGenreName()); //Genreid로 genreName가져오기
            movieDTO.setCountryName(movie.getCountryId().getCountryName());
            movieDTO.setName(movie.getDirectorId().getName());
            movieDTO.setPosterImage(movie.getAdditionalInfoId().getPosterImage());
            movieDTO.setSynopsis(movie.getAdditionalInfoId().getSynopsis());

            movieList.add(movieDTO);

        }

        return movieList;
    }


    //List 형태로 movieId로 영화 정보가져오기
    public MovieDTO getMovieDetailsByMovieId(Long movieId) {
        MovieDTO movieDTO = new MovieDTO();
        Movie movies = movieRepository.findByMovieId(movieId);
       // Genre genres = genreRepository.findByMovieId(movieId);
//        AdditionalInfo additionalInfos = additionalInfoRepository.findByMovieId(movieId);
//        Director directors = directorRepository.findByMovieId(movieId);
//        Country country = countryRepository.findByMovieId(movieId);
        movieDTO.setTitle(movies.getTitle());
        movieDTO.setRunningTime(movies.getRunningTime());
        movieDTO.setReleaseDate(movies.getReleaseDate());
        movieDTO.setRatingName(movies.getRatingName());
        movieDTO.setActor(movies.getActor());
        movieDTO.setScore(movies.getScore());
        movieDTO.setGenreName(movies.getGenreId().getGenreName()); //이것도 되고 밑에방식도 된다
        movieDTO.setCountryName(movies.getCountryId().getCountryName());
        movieDTO.setName(movies.getDirectorId().getName()); //감독정보
        movieDTO.setPosterImage(movies.getAdditionalInfoId().getPosterImage());
        movieDTO.setSynopsis(movies.getAdditionalInfoId().getSynopsis());
        return movieDTO;
        }

    }