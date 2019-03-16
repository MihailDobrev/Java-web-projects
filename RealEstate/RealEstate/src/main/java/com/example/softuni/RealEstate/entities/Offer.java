package com.example.softuni.RealEstate.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offers")
public class Offer extends BaseEntity{

	private BigDecimal apartmentRent;
	private String apartmentType; 
	private BigDecimal agencyCommission;


	@Column(name="apartmentRent")
	public BigDecimal getApartmentRent() {
		return apartmentRent;
	}
	public void setApartmentRent(BigDecimal apartmentRent) {
		this.apartmentRent = apartmentRent;
	}
	@Column(name="apartmentType")
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	@Column(name="agencyCommission")
	public BigDecimal getAgencyCommission() {
		return agencyCommission;
	}
	public void setAgencyCommission(BigDecimal agencyCommission) {
		this.agencyCommission = agencyCommission;
	}
}
