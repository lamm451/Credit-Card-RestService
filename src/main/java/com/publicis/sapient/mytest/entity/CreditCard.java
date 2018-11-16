package com.publicis.sapient.mytest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the Credit Card")
@JsonFilter("CreditCardFilter")
public class CreditCard {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	@ApiModelProperty(notes="Name should have at least 2 characters")	
	private String name;
	
	@Size(min=8, max=19, message="Number should have at least 8 characters, maximum 19")
	@ApiModelProperty(notes="Number should have at least 8 characters, maximum 19")
	private String number;
	
	private double balance = 0.0;
	
	@Positive
	@ApiModelProperty(notes="Limit must be positive")
	@Column(name="cclimit")  // must have other name limit is a SQL reserved word
	private double limit;
	
	protected CreditCard() {
		// JPA expects a default constructor for every defined Entity
	}
	
	public CreditCard(String name, String number, double limit) {
		super();
		this.name = name;
		this.number = number;		
		this.limit = limit;
	}
	
	

	@Override
	public String toString() {
		return String.format("CreditCard [id=%s, name=%s, number=%s, balance=%s, limit=%s]", id, name, number, balance,
				limit);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public double getLimit() {
		return limit;
	}	
	
}
