package com.ibm.currency.conversion.model;

public class CurrencyConversionRequest {

	private String countryCode;
	private double currencyAmount;

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getCurrencyAmount() {
		return currencyAmount;
	}
	public void setCurrencyAmount(double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}
	@Override
	public String toString() {
		return "CurrencyConversionRequest [countryCode=" + countryCode + ", currencyAmount=" + currencyAmount + "]";
	}
	
	
}
