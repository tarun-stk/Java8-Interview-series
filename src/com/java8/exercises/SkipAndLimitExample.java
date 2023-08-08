package com.java8.exercises;

import java.util.stream.IntStream;

public class SkipAndLimitExample {

	public static void main(String[] args) {
		
//		print elements from 2-9 in elements from 1-10
		IntStream.rangeClosed(1, 10)
		.skip(1)
		.limit(8)
		.forEach(System.out::println);
		System.out.println();
//		Skip 5 elements from first and 10 elements from last
		IntStream.rangeClosed(1, 50)
		.skip(5)
		.limit(35)
		.forEach(System.out::println);

	}

}
