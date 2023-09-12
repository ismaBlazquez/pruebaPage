package com.example.page.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.PriceDTO;
import com.example.page.service.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@GetMapping(value = "/getPrices")
	public @ResponseBody PriceDTO getPricesByDateAndProductIdAndBrandId(
			@RequestParam String applicationDate, @RequestParam Integer productId, @RequestParam Integer brandId) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date appDate = null;
		try {
			appDate = df.parse(applicationDate);
			return pricesService.getPricesByDateAndProductIdAndBrandId(appDate, productId, brandId);
		} catch (ParseException e) {
			return new PriceDTO();
		}
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<PriceDTO> getPricesByDateAndProductIdAndBrandId() {
		List<PriceDTO> all = pricesService.getAll();	
		return all;
	}
	
}
