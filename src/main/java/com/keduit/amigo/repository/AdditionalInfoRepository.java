package com.keduit.amigo.repository;

import com.keduit.amigo.entity.AdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalInfoRepository extends JpaRepository<AdditionalInfo, Long> {
    AdditionalInfo findByMovieCode(String movieCode);
}
