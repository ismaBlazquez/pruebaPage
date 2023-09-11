package com.example.page.service;

import java.util.Date;
import java.util.List;

import com.example.page.dto.PricesDTO;

public interface PricesService {

	List<PricesDTO> getPricesByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId);
	
	List<PricesDTO> getAll();
}
