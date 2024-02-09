package com.java8.exercises.strings;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepetitiveCharacterInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "java is a object oriented programming language";
		char ans = str.codePoints().mapToObj(x -> (char)x)
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			.entrySet()
			.stream()
			.filter(x -> x.getValue() == 1)
			.findFirst()
			.map(x -> x.getKey())
			.get();
		System.out.println("Ans: " + ans);
	}

}
