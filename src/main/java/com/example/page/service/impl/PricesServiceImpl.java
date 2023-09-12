package com.example.page.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.page.dto.PricesDTO;
import com.example.page.entity.Prices;
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
	public List<PricesDTO> getPricesByDateAndProductIdAndBrandId(Date applicationDate, Integer productId, Integer brandId) {

		List<Prices> pricesEntityList = pricesRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(productId, brandId, applicationDate, applicationDate);
		
		List<PricesDTO> pricesDtoList = new ArrayList<>();
		pricesEntityList.stream().forEach(priceEntity -> pricesDtoList.add(modelMapper.map(priceEntity, PricesDTO.class)));
		
		return pricesDtoList;
	}

	@Override
	public List<PricesDTO> getAll(){
		List<Prices> allPricesEntity = pricesRepository.findAll();
		
		return modelMapper.map(allPricesEntity, new TypeToken<List<PricesDTO>>(){}.getType());
	}
}
