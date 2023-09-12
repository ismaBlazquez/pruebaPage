package com.example.page.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceDTO {

	private Integer id;
	
	private Integer brandId;
	
	private String startDate;
	
	private String endDate;
	
	private Integer priceList;
	
	private Integer productId;
	
	private Double price;
	
	private String curr;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = dateFormat.format(startDate);
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = dateFormat.format(endDate);
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	public PriceDTO(Integer id, Integer brandId, String startDate, String endDate, Integer priceList,
			Integer productId, Double price, String curr) {
		this.id = id;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.price = price;
		this.curr = curr;
	}

	public PriceDTO(Integer id, Integer brandId, Date startDate, Date endDate, Integer priceList,
			Integer productId, Double price, String curr) {
		this.id = id;
		this.brandId = brandId;
		setStartDate(startDate);
		setEndDate(endDate);
		this.priceList = priceList;
		this.productId = productId;
		this.price = price;
		this.curr = curr;
	}
	
	public PriceDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PricesDTO [id=" + id + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priceList=" + priceList + ", productId=" + productId + ", price="
				+ price + ", curr=" + curr + "]";
	}
	
	
	
}
