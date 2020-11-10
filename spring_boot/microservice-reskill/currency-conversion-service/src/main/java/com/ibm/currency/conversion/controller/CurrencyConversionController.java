package com.ibm.currency.conversion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currency.conversion.model.ConversionFactorResponse;
import com.ibm.currency.conversion.model.CurrencyConversionRequest;
import com.ibm.currency.conversion.model.CurrencyConversionResponse;
import com.ibm.currency.conversion.service.CurrencyConversionService;
import com.ibm.currency.conversion.service.CurrencyConversionServiceProxy;



@RestController
@EnableHystrix
@ControllerAdvice
@RequestMapping(path="/currency")
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyConversionService currencyConversionService;
	
	@Autowired
	private CurrencyConversionServiceProxy proxy;
	
	  @PostMapping(path = "/convertCurrency", produces = MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest conversionRequest) throws Exception {
	  
		  logger.info("In convertCurrency method");
		  logger.info("CurrencyConversionRequest: {}", conversionRequest);
		  
		  CurrencyConversionResponse response = currencyConversionService.convertCurrency(conversionRequest);
		  return new ResponseEntity<CurrencyConversionResponse>(response, HttpStatus.OK); 
	  }
	  
	  @PostMapping(path="/convertCurrencyFeign", produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  public ResponseEntity<CurrencyConversionResponse> convertCurrencyFeign(@RequestBody CurrencyConversionRequest conversionRequest) throws Exception {
		  logger.info("In convertCurrencyFeign method");
		  logger.info("CurrencyConversionRequest: {}", conversionRequest);
		  
		  ConversionFactorResponse factorResponse = proxy.getConversionFactorFeign(conversionRequest.getCountryCode());
		  
		  CurrencyConversionResponse response = new CurrencyConversionResponse();
		  response.setConvertedAmount(conversionRequest.getCurrencyAmount() * factorResponse.getConversionFactor());

		  return new ResponseEntity<CurrencyConversionResponse>(response, HttpStatus.OK); 
	  }
}
