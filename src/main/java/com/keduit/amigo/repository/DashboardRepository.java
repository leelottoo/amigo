package com.keduit.amigo.repository;

import com.keduit.amigo.entity.DashboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity, Long> {
    // 특정 날짜의 대시보드 데이터를 조회하는 메서드
    DashboardEntity findByDate(LocalDate date);
}
