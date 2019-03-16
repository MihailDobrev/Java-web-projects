package com.example.softuni.RealEstate.models.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.softuni.RealEstate.entities.Offer;
import com.example.softuni.RealEstate.repositories.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	public static final String WRONG_DATA_INPUT = "Data input is not correct";
	private final OfferRepository offerRepository;
	private final Validator validator;
	private final ModelMapper modelMapper;

	@Override
	public void registerOffer(OfferRegisterServiceModel offerServiceModel) {

		Set<ConstraintViolation<OfferRegisterServiceModel>> violations = this.validator.validate(offerServiceModel);
		if (!violations.isEmpty()) {
			throw new IllegalArgumentException(WRONG_DATA_INPUT);
		}
		this.offerRepository.saveAndFlush(this.modelMapper.map(offerServiceModel, Offer.class));

	}

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
		this.offerRepository = offerRepository;
		this.validator = validator;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<OfferRegisterServiceModel> findAllOffers() {
		return this.offerRepository.findAll().stream()
				.map(o -> this.modelMapper.map(o, OfferRegisterServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public void findOffer(OfferFindServiceModel offerFindServiceModel) {
		
		if (!this.validator.validate(offerFindServiceModel).isEmpty()) {
			throw new IllegalArgumentException(WRONG_DATA_INPUT);
		}
		
		Offer offer=this.findAllOffers()
				.stream()
				.filter(o->o.getApartmentType().toLowerCase().equals(offerFindServiceModel.getFamilyApartmentType().toLowerCase())
				 &&	offerFindServiceModel.getFamilyBudget()
				 		.compareTo(o.getApartmentRent()
				 					.add(o.getAgencyCommission().divide(new BigDecimal(100)).multiply(o.getApartmentRent())))>=0)
				.map(o->this.modelMapper.map(o, Offer.class))
				.findFirst()
				.orElse(null);
				
		if (offer==null) {
			throw new IllegalArgumentException(WRONG_DATA_INPUT);
		}
		
		this.offerRepository.delete(offer);
	
	}

}
