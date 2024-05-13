package com.keduit.amigo.repository;

import com.keduit.amigo.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    // 오늘의 방문자 수 계산
    long countByAccessTimeBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    // 총 방문자 수 계산
    long count();


    @Query("SELECT ua FROM UserAccess ua WHERE ua.accessTime BETWEEN :startOfDay AND :endOfDay")
    UserAccess findByDay(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);
}
