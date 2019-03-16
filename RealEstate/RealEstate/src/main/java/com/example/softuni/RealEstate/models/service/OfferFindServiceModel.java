package com.example.softuni.RealEstate.models.service;

import java.math.BigDecimal;

import javax.validation.constraints.*;

public class OfferFindServiceModel {

	
	private BigDecimal familyBudget;
	
	private String familyApartmentType; 

	private String familyName;
	
	@NotNull()
	@Min(0)
	public BigDecimal getFamilyBudget() {
		return familyBudget;
	}
	public void setFamilyBudget(BigDecimal familyBudget) {
		this.familyBudget = familyBudget;
	}
	@NotNull()
	@NotEmpty
	public String getFamilyApartmentType() {
		return familyApartmentType;
	}
	public void setFamilyApartmentType(String familyApartmentType) {
		this.familyApartmentType = familyApartmentType;
	}
	@NotNull()
	@NotEmpty
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
}
