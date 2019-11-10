package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JoliverFortuneService implements FortuneService {
	
	@Value("${foo.list}")
	private String myList;
	private String[] myListArray;
	private Random myRandom = new Random();

	@Override
	public String getFortune() { 
		myListArray = myList.split(",");
		int index = myRandom.nextInt(myListArray.length);
		String theFortune = myListArray[index];
		return theFortune;
	}

}
