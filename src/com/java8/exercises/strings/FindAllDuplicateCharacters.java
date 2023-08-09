package com.java8.exercises.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllDuplicateCharacters {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(234, 234, 23, 234, 234, 354, 45, 623, 42, 2, 654, 846846,
				846, 4, 5432, 168, 432, 16, 84, 321, 684, 2, 45));

		numbers.stream()
			.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
			.entrySet()
			.stream()
			.filter(x -> x.getValue() > 1)
			.map(x -> x.getKey())
			.forEach(System.out::println);
		
		String str = "Java8 is fun and amazing";

		str.codePoints().mapToObj(x -> (char)x)
			.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
			.entrySet()
			.stream()
			.filter(x -> x.getValue() > 1)
			.map(x -> x.getKey())
			.forEach(System.out::println);
		;
		
	}

}















