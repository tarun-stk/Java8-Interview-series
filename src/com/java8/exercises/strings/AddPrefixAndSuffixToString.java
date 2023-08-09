package com.java8.exercises.strings;

import java.util.StringJoiner;

public class AddPrefixAndSuffixToString {

	public static void main(String[] args) {
//		StringJoiner("delimeter", "prefix", "suffix");
		StringJoiner sj = new StringJoiner(",", "#", "$");
		sj.add("Java");
		sj.add("Interview");
		sj.add("Questions");
		System.out.println(sj); //#Java,Interview,Questions$
	}

}
