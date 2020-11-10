package com.ibm.learning.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.learning.entity.ConversionFactorEntity;
import com.ibm.learning.exception.RecordNotFoundException;
import com.ibm.learning.model.ConversionFactorReSponse;
import com.ibm.learning.model.ConversionFactorRequest;
import com.ibm.learning.repository.ConversionFactorRepository;

@Service
public class ManageCurrencyConversionServiceImpl implements ManageCurrencyConversionService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired 
	ConversionFactorRepository repository;
	 	
	@Override
	public ConversionFactorReSponse getConversionFactor(String countryCode) throws RecordNotFoundException {
		
		logger.info("In getConversionFactor method");
		ConversionFactorEntity result = repository.findByCountryCode(countryCode);
		if(result == null) {
			throw new RecordNotFoundException("No Record Found");
		}
		ConversionFactorReSponse response = new ConversionFactorReSponse();
		response.setCountryCode(result.getCountryCode());
		response.setConversionFactor(result.getConversionFactor());
		return response;
	}
	
	@Override
	public ConversionFactorReSponse addConversionFactor(ConversionFactorRequest conversionFactorRequest) throws Exception {

		ConversionFactorEntity savedEntity = repository.save(new ConversionFactorEntity(conversionFactorRequest.getCountryCode(),conversionFactorRequest.getConversionFactor()));

		ConversionFactorReSponse response = new ConversionFactorReSponse();
		response.setCountryCode(savedEntity.getCountryCode());
		response.setConversionFactor(savedEntity.getConversionFactor());
		return response;
	}

	@Override
	public ConversionFactorReSponse updateConversionFactor(ConversionFactorRequest conversionFactorRequest) throws Exception {
		
		ConversionFactorEntity savedEntity = repository.save(new ConversionFactorEntity(conversionFactorRequest.getCountryCode(),conversionFactorRequest.getConversionFactor()));
		
		ConversionFactorReSponse response = new ConversionFactorReSponse();
		response.setCountryCode(savedEntity.getCountryCode());
		response.setConversionFactor(savedEntity.getConversionFactor());
		return response;
	}
	
}
