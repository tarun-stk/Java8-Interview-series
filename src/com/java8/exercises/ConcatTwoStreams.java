package com.java8.exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ConcatTwoStreams {
	
	public static void main(String[] args) {
		List<String> l1 = new LinkedList<>(Arrays.asList("a", "b", "c"));
		List<String> l2 = new LinkedList<>(Arrays.asList("d", "e", "f"));
		Stream<String> concat = Stream.concat(l1.stream(), l2.stream());
		concat.forEach(System.out::println);
	}

}
