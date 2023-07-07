package com.java8.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		AdditionFunctionalInterface afi = (a, b) -> a + b;

		System.out.println(call(9, 90, afi));
	}

	private static int call(int i, int j, AdditionFunctionalInterface afi) {
		AdditionFunctionalInterface.staticFunctionDemo();
		return afi.sum(9, 90);
	}

}
