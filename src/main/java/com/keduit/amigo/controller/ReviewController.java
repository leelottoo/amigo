package com.keduit.amigo.controller;

import com.keduit.amigo.dto.ReviewDTO;
import com.keduit.amigo.entity.Movie;
import com.keduit.amigo.entity.Review;
import com.keduit.amigo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addReview")
    public String addReview(@Valid @ModelAttribute("reviewDTO") ReviewDTO reviewDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 에러가 발생한 경우, 에러를 모델에 저장하여 화면으로 전달
            model.addAttribute("error", result.getAllErrors());
            return "errorPage";
        }

        // ReviewDTO에서 Review 엔티티로 변환
        Review review = new Review();
        review.setReviewScore(reviewDTO.getReviewScore());
        review.setReviewContent(reviewDTO.getReviewContent());

        // Movie 객체 생성
        Movie movie = new Movie();
        movie.setMovieId(reviewDTO.getMovie().getMovieId()); // 리뷰가 속하는 영화의 ID 설정

        // 리뷰와 영화 객체 연결
        review.setMovie(movie);

        // 리뷰 서비스 호출하여 리뷰 추가
        reviewService.addReview(review);

        return "redirect:/";
    }

}