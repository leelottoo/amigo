package com.keduit.amigo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keduit.amigo.dto.ReviewDTO;
import com.keduit.amigo.entity.Review;
import com.keduit.amigo.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void testAddReview() throws Exception {
        // 사용자 인증 설정
        Authentication authentication = new UsernamePasswordAuthenticationToken("user@example.com", "userpassword");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 리뷰 DTO 생성
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewScore(4.0);
        reviewDTO.setReviewContent("테스트 리뷰입니다.");

        // 리뷰 추가 요청
        mockMvc.perform(post("/addReview")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reviewDTO)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/moviePage"));

        // 리뷰가 서비스에 추가되었는지 확인
        verify(reviewService, times(1)).addReview(any(Review.class));
    }
}
