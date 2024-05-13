package com.keduit.amigo.dto;

import com.keduit.amigo.entity.Member;
import com.keduit.amigo.entity.Movie;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long reviewId;

    @NotNull(message = "별점을 남겨주세요.")
    private Double reviewScore;

    @NotEmpty(message = "리뷰를 작성해주세요.")
    private String reviewContent;

    private Movie movie;
    private Member userId;
    private String nickname;

}
