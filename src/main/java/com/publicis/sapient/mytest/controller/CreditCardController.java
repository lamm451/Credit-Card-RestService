package com.publicis.sapient.mytest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.publicis.sapient.mytest.entity.CreditCard;
import com.publicis.sapient.mytest.exception.InvalidCreditCardException;
import com.publicis.sapient.mytest.entity.Luhn10Check;
import com.publicis.sapient.mytest.service.CreditCardRepository;

@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCardRepository service;
	
	@Autowired
	private Luhn10Check checkCCNumber;
	
	@PostMapping(path="/add-card")
	public ResponseEntity<Object> addCard(@Valid @RequestBody CreditCard card) {
		// verify validity o credit card number
		if (! checkCCNumber.testCreditCardNumber(card.getNumber())) {
			throw new InvalidCreditCardException("Invalid Credit Card Number");
		}
		service.save(card);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()				
				.build().toUri();
		return ResponseEntity.created(location).build(); // return status 201 created
	}

	
	@GetMapping(path="/get-all")
	public MappingJacksonValue getAllCards() {
		List<CreditCard> cards = service.findAll();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("name", "number", "balance", "limit");

		FilterProvider filters = new SimpleFilterProvider().addFilter("CreditCardFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(cards);

		mapping.setFilters(filters);

		return mapping;
	}
	
	@GetMapping("/check-number/{number}")
	public CardNumberValid verifyCardNumber(@PathVariable String number) {
		return new CardNumberValid(checkCCNumber.testCreditCardNumber(number));
		
	}
	
}
