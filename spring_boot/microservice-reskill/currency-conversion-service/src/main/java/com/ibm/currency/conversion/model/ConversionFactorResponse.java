package com.ibm.currency.conversion.model;

public class ConversionFactorResponse {

	private String countryCode;
	private double conversionFactor;

	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ConversionFactorResponse: {")
								.append("countryCode: ").append(countryCode).append(";")
								.append("conversionFactor: ").append(conversionFactor)
								.append("}")
								.toString();
	}	
}
