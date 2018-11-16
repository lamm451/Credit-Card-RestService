package com.publicis.sapient.mytest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.publicis.sapient.mytest.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{
	// implementation is provided by spring
}
