package com.keduit.amigo.service;

import com.keduit.amigo.dto.MovieDTO;
import com.keduit.amigo.dto.ReviewDTO;
import com.keduit.amigo.entity.Movie;
import com.keduit.amigo.entity.Review;
import com.keduit.amigo.repository.MovieRepository;
import com.keduit.amigo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.keduit.amigo.entity.QMovie.movie;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addReview(Review review) {
        if (review == null || review.getMovie().getMovieId() == null) {
            // 리뷰나 리뷰에 해당하는 영화가 없으면 메서드를 종료하거나 예외를 던질 수 있습니다.
            return;
        }

        // 영화를 찾기
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieDTO.getMovieId());

        // 리뷰 저장
        reviewRepository.save(review);
    }

    private Movie findMovie(Long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.orElseThrow(() -> new EntityNotFoundException("Movie with ID " + movieId + " not found"));
    }

/*    private double calculateNewScore(Movie movie) {
        if (movie == null || movie.getReviews() == null) {
            return 0.0; // movie 객체나 해당 객체의 reviews 필드가 null이면 평점을 0으로 반환
        }

        List<Review> reviews = movie.getReviews();

        if (reviews.isEmpty()) {
            return 0.0; // 리뷰가 없을 경우 평점을 0으로 반환
        }

        double totalScore = 0.0;
        for (Review review : reviews) {
            totalScore += review.getReviewScore(); // 모든 리뷰의 별점을 합산
        }

        return totalScore / reviews.size(); // 평균을 구하여 반환
    }*/

}