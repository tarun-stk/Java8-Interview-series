package com.java8.exercises;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestStringFromAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"java", "springboot", "microservices", "kafka", "aws", "amazonwebservices"};
		
		String longest = Arrays.stream(arr)
		.sorted(Comparator.comparingInt(String::length).reversed())
		.findFirst()
		.get();
		
//		Other way
		String longest1 = Arrays.stream(arr)
		.reduce((x1, x2) -> x1.length() > x2.length()? x1: x2)
		.get();

		
		System.out.println(longest);
		System.out.println(longest1);

	}

}
