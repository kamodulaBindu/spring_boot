package com.ibm.learning.model;

public class ConversionFactorReSponse {

	private String countryCode;
	private double conversionFactor;

	public ConversionFactorReSponse() {
		super();
	}
	
	
	public ConversionFactorReSponse(String countryCode, double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

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
		return new StringBuilder().append("ConversionFactorReSponse: {")
								.append("countryCode: ").append(countryCode).append(";")
								.append("conversionFactor: ").append(conversionFactor)
								.append("}")
								.toString();
	}	
}
