package com.publicis.sapient.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.publicis.sapient.mytest.entity.CreditCard;
import com.publicis.sapient.mytest.service.CreditCardRepository;

@Component
public class CreditCardRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(CreditCardRepositoryCommandLineRunner.class);
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	// implementation provided by Spring
	
	@Override
	public void run(String... arg0) throws Exception {
		
		CreditCard card1 = new CreditCard("Jill Jones", "9123748569664", 1500d);
		creditCardRepository.save(card1);
		log.info("New Credit Card is created : " + card1);
		CreditCard card2 = new CreditCard("Anthony Thomas", "4498652378964562", 2000d);
		creditCardRepository.save(card2);
		log.info("New Credit Card is created : " + card2);
		
	}
	
}