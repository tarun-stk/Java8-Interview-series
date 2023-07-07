package com.java8.insertData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.java8.employee.Employee;

public class InsertData {
	
	public static List<Employee> loadData() {
		List<Employee> list = new LinkedList<>();
		list.add(new Employee(1, 1200, 'M', 26, "Michael", "scott", "IT", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(2, 2400, 'F', 32, "Mona", "Lisa", "HR", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(3, 1100, 'M', 56, "Jimping", "Xi", "Support", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(4, 1000, 'F', 21, "Kate", "Perry", "IT", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(5, 1200, 'M', 28, "David", "Josh", "Sales", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(6, 1000, 'F', 60, "Alina", "Crus", "HR", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(7, 1100, 'F', 19, "Thomas", "Cook", "IT", Arrays.asList("9989998999", "8899889988")));
		list.add(new Employee(8, 1000, 'F', 20, "Debalina", "Apple", "Support", Arrays.asList("9989998999", "8899889988")));
		return list;
	}

}
