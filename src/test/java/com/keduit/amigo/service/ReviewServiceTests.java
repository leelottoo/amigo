package com.keduit.amigo.service;

import com.keduit.amigo.entity.Movie;
import com.keduit.amigo.entity.Review;
import com.keduit.amigo.repository.MovieRepository;
import com.keduit.amigo.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceTests {

    @Autowired
    private ReviewService reviewService;

    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void testAddReview() {
        // 테스트할 리뷰 생성
        Review review = new Review();
        review.setReviewScore(4.0);
        review.setReviewContent("테스트 리뷰입니다.");

        // 테스트할 영화 생성 및 필드 설정
        Movie movie = new Movie();
        movie.setMovieId(1L);
        movie.setTitle("Test Movie");

        // 영화 객체에 리뷰를 추가합니다.
        List<Review> reviews = new ArrayList<>();
        reviews.add(review);
        movie.setReviews(reviews);

        // 리뷰 저장 시 mock 객체 사용
        when(reviewRepository.save(review)).thenReturn(review);

        // 영화 저장 시 mock 객체 사용
        when(movieRepository.save(movie)).thenReturn(movie);

        // 리뷰 추가 메서드 호출
        reviewService.addReview(review);

    }
}