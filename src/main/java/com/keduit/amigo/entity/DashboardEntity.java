package com.keduit.amigo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dashboard_stats")
public class DashboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date; // 데이터가 기록된 날짜

    @Column(nullable = false)
    private long todayVisitors; // 해당 날짜의 방문자 수

    @Column(nullable = false)
    private long totalVisitors; // 누적 방문자 수

    @Column(nullable = false)
    private long todayReviews; // 해당 날짜의 리뷰 수

    @Column(nullable = false)
    private long totalReviews; // 누적 리뷰 수

}