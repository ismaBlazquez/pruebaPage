package com.example.page;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.page.dto.PriceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricesTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test1() throws Exception {		
		PriceDTO expected = new PriceDTO(1, 1, "2020-06-14 00:00:00.0", "2020-12-31 23:59:59.0", 1, 35455, 35.5d, "EUR");		
		String applicationDate = "2020-06-14-10:00:00";
		String productId = "35455";
		String brandId = "1";
		
		testBlock(applicationDate, productId, brandId, expected);
	}
	
	@Test
	public void test2() throws Exception {
		PriceDTO expected = new PriceDTO(2, 1, "2020-06-14 15:00:00.0", "2020-06-14 18:30:00.0", 2, 35455, 25.45d, "EUR");
		String applicationDate = "2020-06-14-16:00:00";
		String productId = "35455";
		String brandId = "1";
		
		testBlock(applicationDate, productId, brandId, expected);
	}
	
	@Test
	public void test3() throws Exception {
		PriceDTO expected = new PriceDTO(1, 1, "2020-06-14 00:00:00.0", "2020-12-31 23:59:59.0", 1, 35455, 35.5d, "EUR");
		String applicationDate = "2020-06-14-21:00:00";
		String productId = "35455";
		String brandId = "1";
		
		testBlock(applicationDate, productId, brandId, expected);
	}
	
	@Test
	public void test4() throws Exception {
		PriceDTO expected = new PriceDTO(3, 1, "2020-06-15 00:00:00.0", "2020-06-15 11:00:00.0", 3, 35455, 30.5d, "EUR");
		String applicationDate = "2020-06-15-10:00:00";
		String productId = "35455";
		String brandId = "1";
		
		testBlock(applicationDate, productId, brandId, expected);
	}
	
	@Test
	public void test5() throws Exception {
		PriceDTO expected = new PriceDTO(4, 1, "2020-06-15 16:00:00.0", "2020-12-31 23:59:59.0", 4, 35455, 38.95d, "EUR");
		String applicationDate = "2020-06-16-21:00:00";
		String productId = "35455";
		String brandId = "1";
		
		testBlock(applicationDate, productId, brandId, expected);
	}
	
	private void testBlock(String applicationDate, String productId, String brandId, PriceDTO expected)
			throws Exception, JsonProcessingException, JsonMappingException, UnsupportedEncodingException {
		MvcResult callReturn = mockMvc.perform(MockMvcRequestBuilders
				.get("/prices/getPrices")
				.param("applicationDate", applicationDate)
				.param("productId", productId)
				.param("brandId", brandId)
				.contentType(MediaType.APPLICATION_JSON))
		        .andReturn();
		
		ObjectMapper om = new ObjectMapper();
		PriceDTO priceResult = om.readValue(callReturn.getResponse().getContentAsString(), PriceDTO.class);
		
		assertEquals(expected.getBrandId(), priceResult.getBrandId());
		assertEquals(expected.getStartDate(), priceResult.getStartDate());
		assertEquals(expected.getEndDate(), priceResult.getEndDate());
		assertEquals(expected.getPriceList(), priceResult.getPriceList());
		assertEquals(expected.getProductId(), priceResult.getProductId());
		assertEquals(expected.getPrice(), priceResult.getPrice());
	}
	
}
