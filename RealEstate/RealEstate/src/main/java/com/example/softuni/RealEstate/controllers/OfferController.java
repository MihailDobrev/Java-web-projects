package com.example.softuni.RealEstate.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.softuni.RealEstate.models.binding.*;
import com.example.softuni.RealEstate.models.service.*;

@Controller
public class OfferController {
 
	private final OfferService offerService;
	private final ModelMapper modelMapper;
	
	public OfferController(OfferService offerService, ModelMapper modelMapper) {
		this.offerService = offerService;
		this.modelMapper = modelMapper;
	}

	@ModelAttribute("registerModel")
    public OfferRegisterBindingModel getRegisterModel(){
        return new OfferRegisterBindingModel();         
    }
	@ModelAttribute("findModel")
    public OfferFindBindingModel getFindModel(){
        return new OfferFindBindingModel();         
    }
	
	@GetMapping("/reg")
	public String register(){
		return "register.html";
	}
	
	@PostMapping("/reg")
	public String register(@ModelAttribute(name="registerModel") OfferRegisterBindingModel registerModel){

		try {
			OfferRegisterServiceModel serviceModel= this.modelMapper.map(registerModel, OfferRegisterServiceModel.class);
			this.offerService.registerOffer(serviceModel);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			
			return "redirect:/reg";
		}		
		return "redirect:/";
	}
	
	@GetMapping("/find")
	public String find(){
		return "find.html";
	}
	
	@PostMapping("/find")
	public String find(@ModelAttribute(name="findModel") OfferFindBindingModel findModel){
		System.out.println("here");
		try {
			OfferFindServiceModel serviceModel=this.modelMapper.map(findModel, OfferFindServiceModel.class);
			this.offerService.findOffer(serviceModel);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			
			return "redirect:/find";
		}		
		return "redirect:/";
	}
	
}
