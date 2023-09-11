package com.example.page.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.PricesDTO;
import com.example.page.service.PricesService;

@RestController
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@RequestMapping(value = "/getPrices", method = {RequestMethod.GET})
	public @ResponseBody List<String> getPricesByDateAndProductIdAndBrandId(
			@RequestParam Date applicationDate, @RequestParam Integer productId, @RequestParam Integer brandId) {
		
		List<PricesDTO> pricesOut = pricesService.getPricesByDateAndProductIdAndBrandId(applicationDate, productId, brandId);
		return pricesOut.stream().map(p -> p.toCustomString()).collect(Collectors.toList());
		
	}
	
	@RequestMapping(value = "/getAll", method = {RequestMethod.GET})
	public @ResponseBody List<PricesDTO> getPricesByDateAndProductIdAndBrandId() {
		
		return pricesService.getAll();		
	}
}
