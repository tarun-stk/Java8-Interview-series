package com.java8.exercises;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateASequenceOfElementsAndPutItIntoArray {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Generate 1 to 100
		int[] array = IntStream.rangeClosed(1, 100).toArray();
		System.out.println(Arrays.toString(array));
		
//		Generate even numbers from 1 to 100
		int[] evens = IntStream.rangeClosed(1, 100).filter(x -> x%2 == 0).toArray();

	}

}
