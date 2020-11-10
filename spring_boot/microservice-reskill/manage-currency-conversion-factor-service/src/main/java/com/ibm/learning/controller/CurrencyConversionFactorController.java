package com.ibm.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.exception.RecordNotFoundException;
import com.ibm.learning.model.ConversionFactorReSponse;
import com.ibm.learning.model.ConversionFactorRequest;
import com.ibm.learning.service.ManageCurrencyConversionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(path="/conversion")
public class CurrencyConversionFactorController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ManageCurrencyConversionService conversionService;

	@GetMapping(path = "/getConversionFactor/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConversionFactor")
	public ResponseEntity<ConversionFactorReSponse> getConversionFactor(@PathVariable("countryCode") String countryCode)  throws RecordNotFoundException {
		
		logger.info("In getConversionFactor method");
		logger.info("code: " + countryCode);
		
		ConversionFactorReSponse response = conversionService.getConversionFactor(countryCode);
		
		return new ResponseEntity<ConversionFactorReSponse>(response, HttpStatus.OK);
		
	}
	
	/*
	 * @GetMapping(path = "/getConversionFactorFeign/{countryCode}", produces =
	 * MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @HystrixCommand(fallbackMethod = "fallbackRetrieveConversionFactor") public
	 * ResponseEntity<ConversionFactorReSponse>
	 * getConversionFactorFeign(@PathVariable("countryCode") String countryCode)
	 * throws RecordNotFoundException {
	 * 
	 * logger.info("In getConversionFactorFeign method"); logger.info("code: " +
	 * countryCode);
	 * 
	 * ConversionFactorReSponse response =
	 * conversionService.getConversionFactor(countryCode);
	 * 
	 * return new ResponseEntity<ConversionFactorReSponse>(response, HttpStatus.OK);
	 * 
	 * }
	 */	
  @PostMapping(path = "/addConversionFactor", produces = MediaType.APPLICATION_JSON_VALUE) 
  public ResponseEntity<ConversionFactorReSponse> addConversionFactor(@RequestBody ConversionFactorRequest conversionFactorRequest) throws Exception {
  
	  logger.info("In addConversionFactor method");
	  logger.info("ConversionFactorRequest: {}", conversionFactorRequest);
	  ConversionFactorReSponse conversionFactorReSponse = conversionService.addConversionFactor(conversionFactorRequest);
	  return new ResponseEntity<ConversionFactorReSponse>(conversionFactorReSponse, HttpStatus.CREATED); 
  }

  @PutMapping(path = "/updateConversionFactor", produces = MediaType.APPLICATION_JSON_VALUE) 
  public ResponseEntity<ConversionFactorReSponse> updateConversionFactor(@RequestBody ConversionFactorRequest conversionFactorRequest) throws Exception {
  
	  logger.info("In updateConversionFactor method");
	  logger.info("ConversionFactorRequest: {}", conversionFactorRequest);
	  ConversionFactorReSponse conversionFactorReSponse = conversionService.updateConversionFactor(conversionFactorRequest);
	  return new ResponseEntity<ConversionFactorReSponse>(conversionFactorReSponse, HttpStatus.OK); 
  }
  
  public ResponseEntity<ConversionFactorReSponse> fallbackRetrieveConversionFactor(@PathVariable("countryCode") String countryCode) {
	  return new ResponseEntity<ConversionFactorReSponse>(new ConversionFactorReSponse("US", 75.0), HttpStatus.EXPECTATION_FAILED);
  }
}
