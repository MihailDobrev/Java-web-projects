package com.example.softuni.RealEstate.models.binding;

import java.math.BigDecimal;

public class OfferFindBindingModel {
	
	private BigDecimal familyBudget;
	private String familyApartmentType; 
	private String familyName;
	
	public BigDecimal getFamilyBudget() {
		return familyBudget;
	}
	public void setFamilyBudget(BigDecimal familyBudget) {
		this.familyBudget = familyBudget;
	}
	public String getFamilyApartmentType() {
		return familyApartmentType;
	}
	public void setFamilyApartmentType(String familyApartmentType) {
		this.familyApartmentType = familyApartmentType;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
}
