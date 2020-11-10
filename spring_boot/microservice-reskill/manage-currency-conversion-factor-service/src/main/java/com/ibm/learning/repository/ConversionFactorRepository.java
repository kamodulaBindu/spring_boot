package com.ibm.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.learning.entity.ConversionFactorEntity;

@Repository
public interface ConversionFactorRepository extends JpaRepository<ConversionFactorEntity, Long> {

	ConversionFactorEntity findByCountryCode(String countryCode);
}
