package com.publicis.sapient.mytest.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.publicis.sapient.mytest.entity.CreditCard;

@Repository
@Transactional // transaction management
public class CreditCardDaoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(CreditCard card){
		entityManager.persist(card);
		return card.getId();
	}
}
