package com.java8.employee;

import java.util.List;

public class Employee {

	private int id;
	private double salary;
	private char gender;
	private String firstName;
	private String lastName;
	private String department;
	private List<String> phone;

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}


	public Employee(int id, double salary, char gender, int age, String firstName, String lastName, String department,
			List<String> phone) {
		super();
		this.id = id;
		this.salary = salary;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", gender=" + gender + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", department=" + department + ", phone=" + phone + ", age=" + age + "]";
	}

}
