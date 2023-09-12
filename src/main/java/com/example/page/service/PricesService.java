package com.example.page.service;

import java.util.Date;
import java.util.List;

import com.example.page.dto.PriceDTO;

public interface PricesService {

	PriceDTO getPricesByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId);
	
	List<PriceDTO> getAll();
}
