package com.keduit.amigo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_access")
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessId;

    @Column(nullable = false)
    private LocalDateTime accessTime;

    @Column(nullable = true)
    private String pageUrl;

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long newsVisits;  // 뉴스 페이지 방문 수

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long movieVisits;  // 영화 페이지 방문 수


}

