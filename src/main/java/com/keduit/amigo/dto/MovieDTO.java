package com.keduit.amigo.dto;

import com.keduit.amigo.entity.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String title;               // 제목
    private String runningTime;         // 러닝타임
    private String releaseDate;         // 개봉일
    private String ratingName;          // 관람 등급
    private String actor;               // 배우
    private double score;               // 평점

    //장르 엔티티
    private String genreName;           // 장르명
    //국가 엔티티
    private String countryName;         // 국가명
    // 감독 엔티티
    private String name;               // 감독명
    // 부가 정보 엔티티
    private String posterImage;         // 영화 포스터 이미지
    private String synopsis;            // 시놉시스


    public MovieDTO (Movie movie, Genre genre, AdditionalInfo additionalInfo, Director director, Country country){
        this.movieId = movie.getMovieId();
        this.title = movie.getTitle();
        this.runningTime = movie.getRunningTime();
        this.releaseDate = movie.getReleaseDate();
        this.ratingName = movie.getRatingName();
        this.actor = movie.getActor();
        this.score = movie.getScore();

        this.genreName = genre.getGenreName();
        this.name = director.getName();
        this.posterImage = additionalInfo.getPosterImage();
        this.synopsis = additionalInfo.getSynopsis();

    }
}
