package com.java8.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicateCharacters {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(234, 234, 23, 234, 234, 354, 45, 623, 42, 2, 654, 846846,
				846, 4, 5432, 168, 432, 16, 84, 321, 684, 2, 45));
		
		Set<Integer> dups = new HashSet<>();
		numbers.stream().filter(x -> !dups.add(x)).forEach(System.out::println);;

	}

}















