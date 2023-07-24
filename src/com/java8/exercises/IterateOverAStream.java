package com.java8.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterateOverAStream {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("Tarun", "Varun", "Arun", "Aron", "Taruneshwar"));
		list.stream().forEach(System.out::println);

	}

}
