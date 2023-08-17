package com.java8.exercises.employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindNthHighestSalary {

	public static void main(String[] args) {

		List<Employee> employees = Stream.of(
				new Employee("Suresh", 1200),
				new Employee("Mahesh", 1200),
				new Employee("Rajesh", 1000),
				new Employee("Tarunesh", 1500),
				new Employee("Lignesh", 1700),
				new Employee("Lingesh", 1200),
				new Employee("Somesh", 1200),
				new Employee("Ramesh", 1500),
				new Employee("Umesh",1700)
				).collect(Collectors.toList());
		
		System.out.println(getNthHighestSalary(4, employees));
		
	}
	
	private static Entry<Double, List<Employee>> getNthHighestSalary(int n, List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.groupingBy(x-> x.getSalary(), TreeMap::new, Collectors.toList()))
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList())
				.get(n-1);
	}

}

class Employee {
	
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
}
