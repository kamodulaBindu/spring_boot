package com.ibm.currency.conversion.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.currency.conversion.model.ConversionFactorResponse;

//@FeignClient(name="manage-currency-conversion-factor-service", url="http://localhost:8020/conversion")
@FeignClient(name="manage-currency-conversion-factor-service")
@RibbonClient(name="manage-currency-conversion-factor-service")
public interface CurrencyConversionServiceProxy {

	@GetMapping(path="/conversion/getConversionFactor/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConversionFactorResponse getConversionFactorFeign(@PathVariable("countryCode") String countryCode);
}
