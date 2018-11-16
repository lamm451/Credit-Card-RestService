package com.publicis.sapient.mytest.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class Luhn10Check {
	
	// empty strings don't match
	private static final Pattern pattern = Pattern.compile("[0-9]+");
	
	// looks a reasonable minimum number of digits for a CC
	private static final int MIN_SIZE = 8;
	
	private static final int MAX_SIZE = 19; 
	
	// https://en.wikipedia.org/wiki/Luhn_algorithm	
	public boolean testCreditCardNumber(String ccNumber) {
		
		int length = ccNumber.length();
		
		if (length < MIN_SIZE || length > MAX_SIZE)
			return false;
		
		Matcher matcher = pattern.matcher(ccNumber);
        if (!matcher.matches())
        	return false; // must have only digits
        
        int sum = 0;
        int n;
        boolean multiply = false;
        
        for (int index = length -1; index >= 0; --index) {
        	
        	n = ccNumber.charAt(index) - '0';
        	if (multiply) {
        		n *= 2;
	        	if (n > 9) {
	        		n -= 9;
	        	}
        	}        	
        	sum += n;
        	multiply = !multiply;
        }
        
        return sum % 10 == 0;        
	}
	
	// Valid numbers:		
	//  12345674   41234345670	79927398713 	987654321056
	
}
