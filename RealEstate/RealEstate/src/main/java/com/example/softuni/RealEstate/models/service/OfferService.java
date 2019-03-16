package com.example.softuni.RealEstate.models.service;

import java.util.List;

public interface OfferService {

	void registerOffer(OfferRegisterServiceModel offerServiceModel);
	
	List<OfferRegisterServiceModel> findAllOffers();
	
	void findOffer(OfferFindServiceModel offerFindServiceModel);
}
