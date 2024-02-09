package com.java8.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindSecondHighesElementInAGivenArray {

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 1, 56, 8, 3, 85, 52, 8, 2, 8, 52, 8, 6, 5, 8, 7, 65, 21, 74, 5641, 85 };
		int limit = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst().get();
		System.out.println(limit);
		int fifth = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).limit(5).skip(4).findFirst().get();
		System.out.println("Fifth largest: " + fifth);
	}

}
