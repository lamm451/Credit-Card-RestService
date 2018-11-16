package com.publicis.sapient.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.publicis.sapient.mytest.entity.CreditCard;
import com.publicis.sapient.mytest.service.CreditCardDaoService;

@Component
public class CreditCardDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(CreditCardDaoServiceCommandLineRunner.class);
	
	@Autowired
	private CreditCardDaoService cardService;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		CreditCard card1 = new CreditCard("Mary Jones", "91230000064", 11500d);
		cardService.insert(card1);
		log.info("New Credit Card is created : " + card1);
		CreditCard card2 = new CreditCard("James Dean", "4498651118964562", 2050d);
		cardService.insert(card2);
		log.info("New Credit Card is created : " + card2);
		
	}
}
