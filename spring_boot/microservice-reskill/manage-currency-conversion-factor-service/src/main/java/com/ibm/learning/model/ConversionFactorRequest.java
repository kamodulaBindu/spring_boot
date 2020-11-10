package com.ibm.learning.model;

import javax.validation.constraints.Size;

public class ConversionFactorRequest {

	@Size(min=2, message = "Country Code should be 2 characters length")
	private String countryCode;
	
	private double conversionFactor;



	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ConversionFactorRequest: {")
								.append("countryCode: ").append(countryCode).append(";")
								.append("conversionFactor: ").append(conversionFactor)
								.append("}")
								.toString();
	}
}
