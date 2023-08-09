package com.java8.exercises.strings;

import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurencesOfEachCharacterInAString {
	
	public static void main(String[] args) {
		String s = "dsklfje;ias;dlifaw;eima;sldfji;aweijfa;wefjasdlc;wle";
		Map<Character, Long> collect = s.codePoints().mapToObj(x -> (char)x).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(collect);
	}

}
