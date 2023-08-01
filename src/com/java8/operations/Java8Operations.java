package com.java8.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java8.employee.Employee;
import com.java8.insertData.InsertData;

public class Java8Operations {
	public static void main(String[] args) {
		
//		Date Time API in java-8
//		1. To get current Date
//			java.time.LocalDate.now()
//		2. To get current Date & Time
//			java.time.LocalDateTime.now()
		
		
		List<Employee> emps = InsertData.loadData();

		System.out.println(getCountOfAllGenders(emps));
		System.out.println(getEmployeeWithHighestSalary(emps));
		System.out.println(getFemaleEmployeeWithHighestSalary(emps));
		System.out.println(getAverageSalaryByGender(emps));
		System.out.println(getAverageAgeByGender(emps));
		System.out.println(countEmployeesWithSalaryGreaterThan100000(emps));
		System.out.println(sumOfAllSalaries(emps));
		System.out.println(OldestEmployee(emps));
		System.out.println(employeesGroupedByDepartment(emps));
		System.out.println(countOfEmployeesInEachDepartment(emps));
		System.out.println(averageSalaryOfEachDepartment(emps));
		System.out.println(highestSalaryInEachDepartment(emps));
		System.out.println(findNthHighestSalary(emps, 3));
		System.out.println(countOfEachCharacter("java is awesome"));
		System.out.println(findAllDuplicateCharactersInAGivenString("java is awesome"));
		System.out.println(findAllUniqueCharactersInAGivenString("java is awesome"));
		System.out.println(findFirstNonRepetitiveCharacterInAGivenString("java is awesome"));
		System.out.println("findFirstRepetitiveCharacterInAGivenString: " + findFirstRepetitiveCharacterInAGivenString("java is awesome, & also java is amazing"));
		System.out.println(findSecondLowestNumberInAGivenArray(new int[] {2, 5, 8, 10, 56, 7, 8, 6, 1}));
		System.out.println(findSecondHighestNumberInAGivenArray(new int[] {2, 5, 8, 10, 56, 7, 8, 6, 1}));
		System.out.println(findStringWithGreatestLength(new String[] {"java", "tech", "spring boot", "microservices", "amazonwebservice"}));
		System.out.println(findAllElementsWhichStartsWith1InAnArray(new int[] {2, 5, 8, 10, 56, 7, 8, 6, 1, 101, 111, 121, 876}));
		System.out.println(stringJoinExample(Arrays.asList("1", "2", "3", "4")));
		System.out.println(skipFirstAndLastInAList(IntStream.rangeClosed(1, 10)));
		System.out.println(findEvenInAList(new int[] {2, 5, 8, 10, 56, 7, 8, 6, 1, 101, 111, 121, 876}));
		System.out.println(findAllDuplicateElementsInAGivenArray(new int[] {2, 5, 8, 10, 56, 7, 8, 6, 1, 101, 111, 121, 876}));
		System.out.println(findFirstElementInList(new ArrayList<String>()));
		System.out.println(findCountOfElements(new int[10000]));
		System.out.println(findMaxInAList(Arrays.asList(10,15,8,49,25,98,98,32,15)));
		System.out.println(concatenateTwoStreams(Arrays.asList("java", "tech", "spring boot", "microservices", "amazonwebservice"), Arrays.asList("Python", "tech", "Django", "microservices", "amazonwebservice")));
		System.out.println(findOnlyDuplicateStringsWithItsCountFromAList(Arrays.asList("AA", "AB", "ABC", "ABB", "ABCC", "AA")));

	}

//	get all genders and their count;
	private static Map<Character, Long> getCountOfAllGenders(List<Employee> emps) {
		Map<Character, Long> map = emps.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		return map;
	}
	
	private static Employee getEmployeeWithHighestSalary(List<Employee> emps) {
		Employee emp = emps.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		return emp;
	}
	
	private static Employee getFemaleEmployeeWithHighestSalary(List<Employee> emps) {
		Employee emp = emps.stream().filter(e -> e.getGender() == 'F').collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		return emp;
	}
	
	static private Map<Character, Double> getAverageSalaryByGender(List<Employee> emps){
		return emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
	}
	
	static private Map<Character, Double> getAverageAgeByGender(List<Employee> emps){
		return emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
	}
	
	static private long countEmployeesWithSalaryGreaterThan100000(List<Employee> emps) {
		return emps.stream().filter(e -> e.getSalary() > 100000).count();
	}
	
	static private double sumOfAllSalaries(List<Employee> emps) {
		return emps.stream().mapToDouble(e -> e.getSalary()).sum();
	}
	
	static private Employee OldestEmployee(List<Employee> emps) {
//		return (Employee) emps.stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(1);
		return emps.stream().reduce((e1, e2) -> e2.getAge() > e1.getAge()? e2: e1).get();
	}
	
	static private Map<String, List<Employee>> employeesGroupedByDepartment(List<Employee> emps){
//		If you want only emp id/name instead of whole emp obj do this
		Map<String, List<Integer>> map = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getId, Collectors.toList())));
//		System.out.println(map);
		return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}
	
	static private Map<String, Long> countOfEmployeesInEachDepartment(List<Employee> emps){
		return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}
	
	static private Map<String, Double> averageSalaryOfEachDepartment(List<Employee> emps){
		return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(emp -> emp.getSalary())));
	}
	
	static private Map<String, Optional<Employee>> highestSalaryInEachDepartment(List<Employee> emps){
		return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
	}
	
	static {
		List<Employee> emps = new LinkedList<>();
		emps.add(new Employee(1, 1200, 'M', 26, "Michael", "scott", "IT", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(2, 2400, 'F', 32, "Mona", "Lisa", "HR", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(3, 1100, 'M', 56, "Jimping", "Xi", "Support", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(4, 1000, 'F', 21, "Kate", "Perry", "IT", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(5, 1200, 'M', 28, "David", "Josh", "Sales", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(6, 1000, 'F', 60, "Alina", "Crus", "HR", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(7, 1100, 'F', 19, "Thomas", "Cook", "IT", Arrays.asList("9989998999", "8899889988")));
		emps.add(new Employee(8, 1000, 'F', 20, "Debalina", "Apple", "Support", Arrays.asList("9989998999", "8899889988")));
		System.out.println(emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
	}
	
	static private Entry<Double, List<String>> findNthHighestSalary(List<Employee> emps, int n){
//		first group emps by their salaries, becuase there mayt be emps with same salaries.
//		below map stores all the unique salaries with list of emps;
		Map<Double, List<String>> map = emps.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getFirstName, Collectors.toList())));
		List<Entry<Double, List<String>>> collect = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
//		System.out.println(collect);
		return collect.get(n-1);
	}
	
	static private Map<Character, Long> countOfEachCharacter(String s){
//		codePoints() returns ascii values of each character as intStream.
//		return s.codePoints().mapToObj(x -> (char)x).collect(Collectors.groupingBy(x->x, Collectors.counting()));
//		using arrays.stream but will return string
//		Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		Other way by using Function.identity() which identifies unique characters.
		return s.codePoints().mapToObj(x -> (char)x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	static private List<Character> findAllDuplicateCharactersInAGivenString(String s) {
//		Other short way
//		return s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
//		.entrySet().stream()
//		.filter(x -> x.getValue() > 1)
//		.map(Map.Entry::getKey)
//		.collect(Collectors.toList());
		
		Map<Character, Long> collect = s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Set<Character> set = collect.keySet();
		Stream<Character> stream = set.stream().filter(x -> collect.get(x) > 1);
		return stream.collect(Collectors.toList());

	}
	
	static private List<Character> findAllUniqueCharactersInAGivenString(String s) {
//		Q. Find if all the chars in string are unique:
//		Set<Character> set = new HashSet();
//		s.codePoints().mapToObj(x -> (char)x).collect(Collectors.toSet());
//		boolean result = set.size() == s.length();
		
		
//		Other short way
		return s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
		.entrySet().stream()
		.filter(x -> x.getValue() == 1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		
//		Map<Character, Long> collect = s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//		Set<Character> set = collect.keySet();
//		Stream<Character> stream = set.stream().filter(x -> collect.get(x) == 1);
//		return stream.collect(Collectors.toList());
		

	}
	
	static private char findFirstNonRepetitiveCharacterInAGivenString(String s) {
//		Other short way
//		return s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
//		.entrySet().stream()
//		.filter(x -> x.getValue() == 1)
//		.findFirst().get().getKey();
		
//		LinkedHashMap::new -> by doing this we say stream not to use hashmap but use linkedHashMap 
		Map<Character, Long> collect = s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		Set<Character> set = collect.keySet();
		Stream<Character> stream = set.stream().filter(x -> collect.get(x) == 1);
		return stream.findFirst().get();
	}
	
	static private char findFirstRepetitiveCharacterInAGivenString(String s) {
//		Other short way
//		return s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
//		.entrySet().stream()
//		.filter(x -> x.getValue() > 1)
//		.findFirst().get().getKey();
		
//		LinkedHashMap::new -> by doing this we say stream not to use hashmap but use linkedHashMap 
		Map<Character, Long> collect = s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		Set<Character> set = collect.keySet();
		Stream<Character> stream = set.stream().filter(x -> collect.get(x) > 1);
		return stream.findFirst().get();

	}
	
	static private int findSecondLowestNumberInAGivenArray(int[] arr) {
		return Arrays.stream(arr).sorted().skip(1).limit(1).toArray()[0];
	}
	
	static private int findSecondHighestNumberInAGivenArray(int[] arr) {
		int[] array = Arrays.stream(arr).sorted().toArray();
//		Other simple way
//		return (int) Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).toArray()[1];
//		return array[array.length-2];
//		One more simple way
//		return (int) Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).limit(1).toArray()[0];
//		One more way
		return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	}
	
	private static String findStringWithGreatestLength(String[] strArr) {
		return Arrays.stream(strArr).reduce((s1, s2) -> s2.length() > s1.length()? s2: s1).get();
	}
	
	private static List<String> findAllElementsWhichStartsWith1InAnArray(int[] arr) {
		return Arrays.stream(arr).boxed().map(s -> s+"").filter(s -> s.startsWith("1")).collect(Collectors.toList());
	}
	
	private static List<Integer> findEvenInAList(int[] arr){
		return Arrays.stream(arr).boxed().filter(x -> x%2 == 0).collect(Collectors.toList());
	}
	
	private static String stringJoinExample(List<String> list) {
//		String.join(delimeter, list) -> u can use any delimeter
		return String.join("-", list);
	}
	
	private static List<Integer> skipFirstAndLastInAList(IntStream stream) {
//		Other way
//		IntStream.rangeClosed(1, 10)
//		.skip(1)
//		.limit(8)
//		.forEach(System.out::print);
		return stream.mapToObj(x->(int)x).skip(1).limit(8).collect(Collectors.toList());
	}
	
	private static List<Integer> findAllDuplicateElementsInAGivenArray(int[] arr){
		return Arrays.stream(arr).boxed() // converting given array to stream
				.collect(Collectors.groupingBy(x->x, Collectors.counting())) // grouping by their frequency
				.entrySet().stream()  // above gives us a map(key-> element, value-> key's frequency), so convert it to stream
				.filter(x -> x.getValue() > 1).map(x -> x.getKey()) // now get whichever element has frequency more than 1.
				.collect(Collectors.toList()); // finally collecting.
		
		// Other simple way
		/*
		 * Set<Integer> set = new HashSet<>();
		Arrays.stream(arr)
			.filter(x -> !set.add(x))
			.forEach(System.out::println); */
//		return null;
	}
	
	private static Optional<String> findFirstElementInList(List<String> list) {
		Optional<String> out = list.stream().findFirst();
		return out;
	}
	
	private static long findCountOfElements(int[] arr){
		return Arrays.stream(arr)
				.count(); 
	}
	
	private static long findMaxInAList(List<Integer> list){
		Optional<Integer> opt = list.stream()
				.max(Integer::compare);
		return opt.isPresent()? opt.get(): 0;
	}
	
	private static List<String> concatenateTwoStreams(List<String> l1, List<String> l2) {
		// Concatenated the list1 and list2 by converting them into Stream
		Stream<String> concatStream = Stream.concat(l1.stream(), l2.stream());
         
		// Printed the Concatenated Stream
//        concatStream.forEach(str -> System.out.print(str + " "));
		
		List<String> collect = concatStream.collect(Collectors.toList());
		return collect;
        
	}
	
	private static Map<String, Long> findOnlyDuplicateStringsWithItsCountFromAList(List<String> l1){
		
		IntStream.rangeClosed(1, 10).mapToObj(x -> x).collect(Collectors.toList());
		
		return l1.stream()
				.filter(x -> Collections.frequency(l1, x) > 1)
				.collect(Collectors.groupingBy
						(Function.identity(), Collectors.counting()));
	}
	
}










