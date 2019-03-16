package com.example.softuni.RealEstate.models.service;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class OfferRegisterServiceModel {

	private int id;
	private BigDecimal apartmentRent;
	private String apartmentType;
	private BigDecimal agencyCommission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	@DecimalMin("0")
	public BigDecimal getApartmentRent() {
		return apartmentRent;
	}

	public void setApartmentRent(BigDecimal apartmentRent) {
		this.apartmentRent = apartmentRent;
	}

	@NotNull
	@NotEmpty
	public String getApartmentType() {
		return apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	@NotNull
	@DecimalMin("0")
	@DecimalMax("100")
	public BigDecimal getAgencyCommission() {
		return agencyCommission;
	}

	public void setAgencyCommission(BigDecimal agencyCommission) {
		this.agencyCommission = agencyCommission;
	}

}
