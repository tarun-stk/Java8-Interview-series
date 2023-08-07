package com.java8.exercises;

public class StringJoinExample {

	public static void main(String[] args) {
		
		String[] arr = {"1", "2", "3", "4", "5"};
//		produce result as 1-2-3-4-5
		String result = String.join("-", arr);
		System.out.println(result);
	}

}
