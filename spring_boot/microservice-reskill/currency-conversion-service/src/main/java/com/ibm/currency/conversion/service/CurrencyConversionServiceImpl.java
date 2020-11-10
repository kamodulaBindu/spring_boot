package com.ibm.currency.conversion.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.currency.conversion.model.ConversionFactorResponse;
import com.ibm.currency.conversion.model.CurrencyConversionRequest;
import com.ibm.currency.conversion.model.CurrencyConversionResponse;


@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {


	private Logger logger = LoggerFactory.getLogger(CurrencyConversionServiceImpl.class);
	
	@Override
	public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest conversionRequest) throws Exception {
		
		logger.info("In convertCurrency method");
		if(conversionRequest.getCountryCode().length()<=0) {
			throw new Exception();
		}

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("countryCode", conversionRequest.getCountryCode());
		
		ResponseEntity<ConversionFactorResponse> responseEntity = new RestTemplate().getForEntity("http://localhost:8020/conversion/getConversionFactor/{countryCode}", 
				ConversionFactorResponse.class, uriVariables);
		
		ConversionFactorResponse factorResponse = responseEntity.getBody();
		CurrencyConversionResponse response = new CurrencyConversionResponse();
		response.setConvertedAmount(conversionRequest.getCurrencyAmount() * factorResponse.getConversionFactor());
		return response;
	}
}
