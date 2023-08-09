package com.java8.exercises.strings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAllNumbersStartingWithDigitOne {

	public static void main(String[] args) {
		List<Integer> list = Stream
				.of(1,2,3,4,199,12,32,54,67,232,54,56,56,2,12,12,34,342,12,121111,1212)
				.collect(Collectors.toList());
		
		list.stream().map(x -> x+"").filter(x -> x.startsWith("1")).forEach(System.out::println);

	}

}
