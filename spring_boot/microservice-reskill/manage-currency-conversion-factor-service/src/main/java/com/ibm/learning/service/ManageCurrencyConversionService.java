package com.ibm.learning.service;

import com.ibm.learning.exception.RecordNotFoundException;
import com.ibm.learning.model.ConversionFactorReSponse;
import com.ibm.learning.model.ConversionFactorRequest;

public interface ManageCurrencyConversionService {

	ConversionFactorReSponse getConversionFactor(String countryCode)  throws RecordNotFoundException;
	
	ConversionFactorReSponse addConversionFactor(ConversionFactorRequest conversionFactorRequest) throws Exception;
	
	ConversionFactorReSponse updateConversionFactor(ConversionFactorRequest conversionFactorRequest) throws Exception;
}
