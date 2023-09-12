package com.example.page.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.page.dto.PriceDTO;
import com.example.page.entity.PriceEntity;
import com.example.page.repository.PricesRepository;
import com.example.page.service.PricesService;

@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Autowired
    public PricesServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public PriceDTO getPricesByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId) {

		PriceDTO priceDto = null;
		
		List<PriceEntity> pricesEntityList = pricesRepository.findByDateAndProductIdAndBrandId(applicationDate, productId, brandId);
	
		if(pricesEntityList != null && !pricesEntityList.isEmpty()) {
			priceDto = modelMapper.map(pricesEntityList.get(0), PriceDTO.class);
		}		
		return priceDto;
	}

	@Override
	public List<PriceDTO> getAll(){
		List<PriceDTO> listDto = new ArrayList<>();
		List<PriceEntity> allPricesEntity = pricesRepository.findAll();
		if (allPricesEntity != null && !allPricesEntity.isEmpty()) {
			allPricesEntity.stream().forEach(p -> listDto.add(modelMapper.map(p, PriceDTO.class)));
		}
		return listDto;
	}
}
