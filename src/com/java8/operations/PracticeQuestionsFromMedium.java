package com.java8.operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 * Author: Tarun Soodula
 * Created Date: 10-07-2023
 * Created For: Java-8 coding practice.
 * Questions taken from : https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class PracticeQuestionsFromMedium {

	public static void main(String[] args) {

		System.out.println("Numbers starting with 1.");
        List<Integer> list = Arrays.asList(2,5,10,15,8,49,25,98,32,8);
        list.stream().map(x -> x+"").filter(x -> x.startsWith("1"))
        .forEach(System.out::println);
        
        System.out.println("Find duplicates.");
        Set<Integer> set = new HashSet<>();
        list.stream().filter(x -> !set.add(x)).forEach(System.out::println);
        
        System.out.println("Given the list of integers, find the first element of the list");
        System.out.println(list.stream().findFirst().get());
        
        System.out.println("Given a list of integers, find the total number of elements present in the list using Stream");
        System.out.println(list.stream().count());
        
		System.out.println("Given a list of integers, find the maximum value element present in it using Stream");
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).findFirst().get());
		System.out.println(list.stream().collect(Collectors.maxBy((a, b) -> a-b)).get());
		
		System.out.println("Given a String, find the first non-repeated character in it using Stream");
		String str = "Jjava articles are Awesome";
		System.out.println(str.toLowerCase().codePoints()
			.mapToObj(x -> (char)x)
			.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
			.entrySet().stream()
			.filter(x -> x.getValue() == 1)
			.findFirst()
			.get()
			.getKey());
		
		System.out.println("Given a String, find the first repeated character in it using Stream");
		String str1 = "Jjava articles are Awesome";
		System.out.println(str1.chars() // Stream of String       
	            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
	            .entrySet().stream()
	            .filter(x -> x.getValue() > 1)
	            .findFirst()
	            .get()
	            .getKey());
		
		System.out.println(" Given a list of integers, sort all the values present in it using Stream");
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		
		System.out.println("Given a list of integers, sort all the values present in it in descending order using Stream functions");
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		
		System.out.println("Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");
		 Set<Integer> set1 = list.stream().collect(Collectors.toSet());
		 System.out.println(set1.size() == list.size());
		 
		 System.out.println("Write a Java 8 program to concatenate two Streams");
		 Stream<Integer> s1 = Stream.of(1, 2, 3);
		 Stream<Integer> s2 = Stream.of(4, 5, 6);
		 Stream<Integer> s3 = Stream.concat(s1, s2);
		 System.out.println(s3.collect(Collectors.toList()));
		 
		 System.out.println("Java 8 program to perform cube on list elements and filter numbers greater than 50.");
		 System.out.println(list.stream().filter(x -> x*x*x > 50).collect(Collectors.toList()));
		 
		 System.out.println("Write a Java 8 program to sort an array and then convert the sorted array into Stream");
		 int[] arr = {8,23,56,3,45,57};
		 Arrays.parallelSort(arr); //sorted
		 Arrays.stream(arr).forEach(x->System.out.print(x + " ")); //converted to intstream and then print
		 
		 System.out.println("How to find only duplicate elements with its count from the String ArrayList in Java8");
		 List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		 Map<String, Long> collect = names.stream()
		 	.filter(x -> Collections.frequency(names, x) > 1)
		 	.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		 System.out.println(collect);
	}

}

















