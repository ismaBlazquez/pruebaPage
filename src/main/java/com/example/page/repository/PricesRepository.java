package com.example.page.repository;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.page.entity.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

//	@Query("SELECT p FROM PricesEntity p WHERE "
//			+ "(p.start_date < ?1 AND p.end_date > ?1) AND "
//			+ "(p.product_id = ?2) AND "
//			+ "(p.brand_id = ?3")
//	List<PricesEntity> findByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId);
	
	List<Prices> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
			 Integer productId, Integer brandId, Date applicationDate, Date applicationDate2);
}
