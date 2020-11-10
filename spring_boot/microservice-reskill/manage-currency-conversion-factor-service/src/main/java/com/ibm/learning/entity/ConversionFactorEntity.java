package com.ibm.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conversion_Factor")
public class ConversionFactorEntity {


	@Id
	@Column(nullable = false, length=2)
	private String countryCode;
	
	@Column(nullable = false)
	private double conversionFactor;
	
	public ConversionFactorEntity() {
		super();
	}

	public ConversionFactorEntity(String countryCode, double conversionFactor) {
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
		return String.format("ConversionFactorEntity: [countryCode=%s; conversionFactor=%f]", countryCode, conversionFactor);
	}
	
}
