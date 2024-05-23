package com.java8.lambda;

import java.util.Arrays;

public class LambdaDemo {

	public static void main(String[] args) {
		AdditionFunctionalInterface afi = (a, b) -> a + b;
		VarargsSum vs = (a) -> Arrays.stream(a).sum();
//		variable leng args, works in both ways like mentioned below
		System.out.println(vs.add(new int[]{1, 2, 3, 4, 12, 234, 234}));
		System.out.println(vs.add(1, 2, 3, 4, 12, 234, 234));
		System.out.println(call(9, 90, afi));
	}

	private static int call(int i, int j, AdditionFunctionalInterface afi) {
		AdditionFunctionalInterface.staticFunctionDemo();
		return afi.sum(9, 90);
	}

}
