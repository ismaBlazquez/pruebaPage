package com.example.page.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.PricesDTO;
import com.example.page.service.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@GetMapping(value = "/getPrices")
	public @ResponseBody List<PricesDTO> getPricesByDateAndProductIdAndBrandId(
			@RequestParam String applicationDate, @RequestParam Integer productId, @RequestParam Integer brandId) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = null;
		try {
			appDate = df.parse(applicationDate);
		} catch (ParseException e) {
			return HttpStatus.BAD_REQUEST;
		}
		
		List<PricesDTO> pricesList = pricesService.getPricesByDateAndProductIdAndBrandId(appnDate, productId, brandId);
		return pricesList;
		//HttpStatus.
		
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<PricesDTO> getPricesByDateAndProductIdAndBrandId() {
		
		List<PricesDTO> all = pricesService.getAll();	
		return all;
	}
	
}
