package com.keduit.amigo.service;

import com.keduit.amigo.entity.UserAccess;
import com.keduit.amigo.repository.ReviewRepository;
import com.keduit.amigo.repository.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service //데이터베이스에서 데이터를 조회하거나 데이터를 데이터베이스에 저장하는 역할을 담당
public class UserAccessService {

    @Autowired
    private UserAccessRepository userAccessRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // 오늘 방문자 수 가져오기
    public long getVisitorCountToday() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MIN.toLocalTime());
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MAX.toLocalTime());
        return userAccessRepository.countByAccessTimeBetween(startOfDay, endOfDay);
    }



    // 총 방문자 수 가져오기
    public long getTotalVisitorCount() {
        return userAccessRepository.count();
    }


/*    // 오늘 뉴스 페이지 방문자 수 가져오기
    public long getTodayNewsVisitors() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MIN.toLocalTime());
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MAX.toLocalTime());
        return userAccessRepository.sumNewsVisitsByAccessTimeBetween(startOfDay, endOfDay);
    }

    // 오늘 영화 페이지 방문자 수 가져오기
    public long getTodayMovieVisitors() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MIN.toLocalTime());
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalDateTime.MAX.toLocalTime());
        return userAccessRepository.sumMovieVisitsByAccessTimeBetween(startOfDay, endOfDay);
    }*/

    // URL 을 통해 Access 를 로그하여, UserAccess 엔티티의 새 인스턴스로 생성하고, DB에 저장.
    public void incrementNewsVisits(LocalDateTime accessTime) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);
        UserAccess todayAccess = userAccessRepository.findByDay(startOfDay, endOfDay);
        if (todayAccess == null) {
            todayAccess = new UserAccess();
            todayAccess.setAccessTime(accessTime);
            todayAccess.setNewsVisits(1L);
        } else {
            todayAccess.setNewsVisits(todayAccess.getNewsVisits() + 1);
        }
        userAccessRepository.save(todayAccess);
    }

    public void incrementMovieVisits(LocalDateTime accessTime) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);
        UserAccess todayAccess = userAccessRepository.findByDay(startOfDay, endOfDay);
        if (todayAccess == null) {
            todayAccess = new UserAccess();
            todayAccess.setAccessTime(accessTime);
            todayAccess.setMovieVisits(1L);
        } else {
            todayAccess.setMovieVisits(todayAccess.getMovieVisits() + 1);
        }
        userAccessRepository.save(todayAccess);
    }


}
