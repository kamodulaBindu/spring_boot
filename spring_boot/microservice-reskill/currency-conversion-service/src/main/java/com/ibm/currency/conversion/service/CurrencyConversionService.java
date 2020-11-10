package com.ibm.currency.conversion.service;

import com.ibm.currency.conversion.model.CurrencyConversionRequest;
import com.ibm.currency.conversion.model.CurrencyConversionResponse;

public interface CurrencyConversionService {

	CurrencyConversionResponse convertCurrency(CurrencyConversionRequest conversionRequest) throws Exception;
}
