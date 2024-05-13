package com.keduit.amigo.repository;

import com.keduit.amigo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);
}
