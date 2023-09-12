package com.example.page.dto;

import java.util.Date;

public class PricesDTO {

	private Integer id;
	
	private Integer brandId;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer priceList;
	
	private Integer productId;
	
	private Integer priority;
	
	private Double price;
	
	private String curr;

	

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public PricesDTO(Integer id, Integer brand_id, Date start_date, Date end_date, Integer price_list,
			Integer product_id, Integer priority, Double price, String curr) {
		this.id = id;
		this.brandId = brand_id;
		this.startDate = start_date;
		this.endDate = end_date;
		this.priceList = price_list;
		this.productId = product_id;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
	
	
	public PricesDTO() {
		super();
	}

	public String toCustomString() {
		return "product_id: " + this.productId + ", brand_id: " + brandId + ", price_list: " + priceList
				+ ", start_date: " + startDate + ", end_date: " + endDate + ", price: " + price;
	}

	@Override
	public String toString() {
		return "PricesDTO [id=" + id + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priceList=" + priceList + ", productId=" + productId + ", priority=" + priority + ", price="
				+ price + ", curr=" + curr + "]";
	}
	
	
	
}
