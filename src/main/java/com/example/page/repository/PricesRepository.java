package com.example.page.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.page.entity.PriceEntity;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {

	@Query("SELECT p FROM PriceEntity p WHERE "
			+ "(p.startDate < ?1 AND p.endDate > ?1) AND "
			+ "(p.productId = ?2) AND "
			+ "(p.brandId = ?3) ORDER BY priority DESC")
	List<PriceEntity> findByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId);
	
}

