package com.example.softuni.RealEstate.controllers;

import java.io.IOException;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.softuni.RealEstate.models.service.OfferService;
import com.example.softuni.RealEstate.models.views.OfferViewModel;
import com.example.softuni.RealEstate.util.HtmlReader;

@Controller
public class HomeController {

	private final OfferService offerService;
	private final HtmlReader htmlReader;
	private final ModelMapper modelMapper;

	public HomeController(OfferService offerService, HtmlReader htmlReader, ModelMapper modelMapper) {
		super();
		this.offerService = offerService;
		this.htmlReader = htmlReader;
		this.modelMapper = modelMapper;
	}

	
	@GetMapping("/")
	@ResponseBody()
	public String index() throws IOException {
		return this.prepareHtml();
	}

	private String prepareHtml() throws IOException, PatternSyntaxException {
		List<OfferViewModel> offers = this.offerService.findAllOffers().stream()
				.map(o -> this.modelMapper.map(o, OfferViewModel.class)).collect(Collectors.toList());

		StringBuilder offersHtml = new StringBuilder();

		if (offers.isEmpty()) {
			offersHtml.append("<div class=\"apartment\" style=\"border: red solid 1px\">").append("There are no offers")
					.append("</div>");

		}

		for (OfferViewModel offer : offers) {
			offersHtml.append("<div class=\"apartment\">").append("<p>Rent: " + offer.getApartmentRent() + "</p>")
					.append("<p>Type: " + offer.getApartmentType() + "</p>")
					.append("<p> Commission: " + offer.getAgencyCommission() + "</p>").append("</div>");
		}

		String viewWithData = this.htmlReader
				.readHtmlFile(
						"C:\\Users\\Misho\\Desktop\\Java-web-projects\\RealEstate\\RealEstate\\src\\main\\resources\\static\\index.html");
		
		String replaced= viewWithData.replace("{{{offers}}}", offersHtml.toString());
		 
		 return replaced;
	};
}
