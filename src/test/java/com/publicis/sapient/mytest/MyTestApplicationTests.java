package com.publicis.sapient.mytest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.publicis.sapient.mytest.entity.Luhn10Check;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestApplicationTests {

	@Autowired
	private Luhn10Check ccDigit;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void luhnCheckValidNumbers() {
		assertTrue(ccDigit.testCreditCardNumber("12345674"));
		assertTrue(ccDigit.testCreditCardNumber("41234345670"));
		assertTrue(ccDigit.testCreditCardNumber("79927398713"));
		assertTrue(ccDigit.testCreditCardNumber("987654321056"));
	}
	
	@Test
	public void luhnCheckNonValidNumbers() {
		assertFalse(ccDigit.testCreditCardNumber("1234597674"));
		assertFalse(ccDigit.testCreditCardNumber("412343345670"));
		assertFalse(ccDigit.testCreditCardNumber("79827398713"));
		assertFalse(ccDigit.testCreditCardNumber("987654371056"));
	}
	
	@Test
	public void luhnCheckInvalidChars() {
		assertFalse(ccDigit.testCreditCardNumber("12345 7674"));
		assertFalse(ccDigit.testCreditCardNumber("412343z45670"));
		assertFalse(ccDigit.testCreditCardNumber("7982739k713"));
		assertFalse(ccDigit.testCreditCardNumber("987654371+056"));
	}
	
	@Test
	public void luhnCheckInvalidSize() {
		assertFalse(ccDigit.testCreditCardNumber(""));
		assertFalse(ccDigit.testCreditCardNumber("1234567"));
		assertFalse(ccDigit.testCreditCardNumber("01234567890123456789"));
		assertFalse(ccDigit.testCreditCardNumber("257896"));
	}
}
