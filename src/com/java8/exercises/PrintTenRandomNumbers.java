package com.java8.exercises;

import java.util.Random;

public class PrintTenRandomNumbers {

	public static void main(String[] args) {
		
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}

}
