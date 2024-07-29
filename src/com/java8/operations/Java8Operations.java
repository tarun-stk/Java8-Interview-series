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

import static java.util.stream.Collectors.toList;

public class Java8Operations {

    static List<Employee> emps1 = InsertData.loadData();
    static List<Employee> emps;


    static {
        emps = new LinkedList<>();
        emps.add(new Employee(1, 1200, 'M', 26, "Michael", "scott", "IT", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(2, 2400, 'F', 32, "Mona", "Lisa", "HR", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(3, 1100, 'M', 56, "Jimping", "Xi", "Support", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(4, 1000, 'F', 21, "Kate", "Perry", "IT", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(5, 1200, 'M', 28, "David", "Josh", "Sales", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(6, 1000, 'F', 60, "Alina", "Crus", "HR", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(7, 1100, 'F', 19, "Thomas", "Cook", "IT", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(8, 1000, 'F', 20, "Debalina", "Apple", "Support", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(9, 1800, 'M', 28, "Tim", "Cook", "Executive", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(10, 2000, 'F', 60, "Alastair", "Cook", "Admin", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(11, 1500, 'F', 19, "Mohammed", "Jansen", "HR", Arrays.asList("9989998999", "8899889988")));
        emps.add(new Employee(12, 1300, 'F', 20, "Yapsin", "Supreme", "IT", Arrays.asList("9989998999", "8899889988")));
    }

    public static void main(String[] args) {

//		Date Time API in java-8
//		1. To get current Date
//			java.time.LocalDate.now()
//		2. To get current Date & Time
//			java.time.LocalDateTime.now()
//		System.out.println("emps: " + emps);
        System.out.println("getCountOfAllGenders: " + getCountOfAllGenders(emps));
        System.out.println("getAllEmployeesSortedBySalariesAscending: ");
        getAllEmployeesSortedBySalariesAscending(emps);
        System.out.println("getEmployeeWithFifthHighestSalary: " + getEmployeeWithFifthHighestSalary(emps));
        System.out.println("getEmployeeWithFifthLowestSalary: " + getEmployeeWithFifthLowestSalary(emps));
        System.out.println("getEmployeeWithHighestSalary: " + getEmployeeWithHighestSalary(emps));
        System.out.println("getFemaleEmployeeWithHighestSalary: " + getFemaleEmployeeWithHighestSalary(emps));
        System.out.println("getAverageSalaryByGender: " + getAverageSalaryByGender(emps));
        System.out.println("getAverageAgeByGender: " + getAverageAgeByGender(emps));
        System.out.println("countEmployeesWithSalaryGreaterThan100000: " + countEmployeesWithSalaryGreaterThan100000(emps));
        System.out.println("sumOfAllSalaries: " + sumOfAllSalaries(emps));
        System.out.println("OldestEmployee: " + oldestEmployee(emps));
        System.out.println(employeesGroupedByDepartment(emps));
        System.out.println("countOfEmployeesInEachDepartment : " + countOfEmployeesInEachDepartment(emps));
        System.out.println(averageSalaryOfEachDepartment(emps));
        System.out.println("highestSalaryInEachDepartment: " + highestSalaryInEachDepartment(emps));
        System.out.println("findNthHighestSalary: " + findNthHighestSalary(emps, 3));
        System.out.println(countOfEachCharacter("java is awesome"));
        System.out.println(findAllDuplicateCharactersInAGivenString("java is awesome"));
        System.out.println(findAllUniqueCharactersInAGivenString("java is awesome"));
        System.out.println(findFirstNonRepetitiveCharacterInAGivenString("java is awesome"));
        System.out.println("findFirstRepetitiveCharacterInAGivenString: " + findFirstRepetitiveCharacterInAGivenString("java is awesome, & also java is amazing"));
        System.out.println(findSecondLowestNumberInAGivenArray(new int[]{2, 5, 8, 10, 56, 7, 8, 6, 1}));
        System.out.println("findSecondHighestNumberInAGivenArray: " + findSecondHighestNumberInAGivenArray(new int[]{2, 5, 8, 10, 56, 7, 8, 6, 1}));
        System.out.println(findStringWithGreatestLength(new String[]{"java", "tech", "spring boot", "microservices", "amazonwebservice"}));
        System.out.println(findAllElementsWhichStartsWith1InAnArray(new int[]{2, 5, 8, 10, 56, 7, 8, 6, 1, 101, 111, 121, 876}));
        System.out.println(stringJoinExample(Arrays.asList("1", "2", "3", "4")));
        System.out.println(skipFirstAndLastInAList(IntStream.rangeClosed(1, 10)));
        System.out.println(findEvenInAList(new int[]{2, 5, 8, 10, 56, 7, 8, 6, 1, 101, 111, 121, 876}));
        System.out.println(findMaxInAList(Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15)));
        System.out.println(concatenateTwoStreams(Arrays.asList("java", "tech", "spring boot", "microservices", "amazonwebservice"), Arrays.asList("Python", "tech", "Django", "microservices", "amazonwebservice")));
        System.out.println(findOnlyDuplicateStringsWithItsCountFromAList(Arrays.asList("AA", "AB", "ABC", "ABB", "ABCC", "AA")));
        System.out.println("flattenAListOfStringsToCharacters: " + flattenAListOfStringsToCharacters(Arrays.asList("String", "Character", "Integer")));
        System.out.println("flattenAListOfArrays: " + flattenAListOfArrays(List.of(new int[]{1, 2}, new int[]{3, 4})));
        System.out.println("flattenAListOfStringsWithSpaces: " + flattenAListOfStringsWithSpaces(Arrays.asList("Hello World", "Intelligent person", "He is very good")));
        System.out.println("findDepartmentWithHighestEmployeeCount: " + findDepartmentWithHighestEmployeeCount());
        System.out.println("findSecondHighestSalaryInEachDepartment: " + findEmployeeWithSecondHighestSalaryInEachDepartment());

    }

    private static Map<String, Employee> findEmployeeWithSecondHighestSalaryInEachDepartment() {
        return emps.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                .entrySet().stream()
                .flatMap(x ->
                        x.getValue()
                                .stream()
//                                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Employee::getSalary)))
                                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                                .skip(1)
                                .limit(1)
                )
                .collect(Collectors.toMap(Employee::getDepartment, x -> x));
    }

    private static String findDepartmentWithHighestEmployeeCount() {
//        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
//                .map(Entry::getKey)
//                .findFirst()
//                .get();
        /*Above uses sorting, but dont need actually*/
//        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
//                .entrySet().stream()
//                .max((a, b) -> Long.compare(a.getValue(), b.getValue()))
//                .map(Entry::getKey)
//                .get();
        /*Other way*/
        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Entry::getKey)
                .get();
    }

    private static List<String> flattenAListOfStringsWithSpaces(List<String> list) {
        return list.stream().flatMap(x -> Arrays.stream(x.split(" "))).collect(toList());
    }

    private static List<Integer> flattenAListOfArrays(List<int[]> ints) {
        return ints.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }

    private static List<Character> flattenAListOfStringsToCharacters(List<String> list) {
        return list.stream().flatMap(x -> x.codePoints().mapToObj(y -> (char) y)).collect(toList());
    }

    private static Employee getEmployeeWithFifthHighestSalary(List<Employee> emps) {
        return (Employee) emps.stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(Employee::getSalary))).skip(4).limit(1).toArray()[0];
    }

    private static void getAllEmployeesSortedBySalariesAscending(List<Employee> emps) {
        emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
    }

    private static String getEmployeeWithFifthLowestSalary(List<Employee> emps) {
        return emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(4).limit(1).toArray()[0].toString();
    }

    //	get all genders and their count;
    private static Map<Character, Long> getCountOfAllGenders(List<Employee> emps) {
        Map<Character, Long> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        return map;
    }

    private static Employee getEmployeeWithHighestSalary(List<Employee> emps) {
        Optional<Employee> emp = emps.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
//		Employee emp = emps.stream().reduce((a, b) -> a.getSalary() > b.getSalary()? a: b).get();
//		Employee emp = emps.stream().max((emp1, emp2) -> (int)emp1.getSalary() - (int)emp2.getSalary()).get();
        return emp.isPresent() ? emp.get() : null;
    }

    private static Employee getFemaleEmployeeWithHighestSalary(List<Employee> emps) {
        Employee emp = emps.stream().filter(e -> e.getGender() == 'F').collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
        return emp;
    }

    static private Map<Character, Double> getAverageSalaryByGender(List<Employee> emps) {
//		return emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        return emps.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingDouble(e -> e.getSalary())));
    }

    static private Map<Character, Double> getAverageAgeByGender(List<Employee> emps) {
        return emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
    }

    static private long countEmployeesWithSalaryGreaterThan100000(List<Employee> emps) {
        return emps.stream().filter(e -> e.getSalary() > 100000).count();
    }

    static private double sumOfAllSalaries(List<Employee> emps) {
        return emps.stream().mapToDouble(x -> x.getSalary()).reduce((x, b) -> x + b).getAsDouble();
//		return emps.stream().mapToDouble(x -> x.getSalary()).sum();
    }

    static private Employee oldestEmployee(List<Employee> emps) {
//		return (Employee) emps.stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(1);
//		return emps.stream().reduce((e1, e2) -> e2.getAge() > e1.getAge()? e2: e1).get();
        return (Employee) emps.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge))).get();
//		return (Employee) emps.stream().collect(Collectors.maxBy((a, b) -> a.getAge() - b.getAge())).get();
//		Below to get youngest employee
//		return (Employee) emps.stream().collect(Collectors.minBy((a, b) -> a.getAge() - b.getAge())).get();

//		return emps.stream().max((x1, x2) -> x1.getAge() - x2.getAge()).get();
    }

    static private Map<String, List<Employee>> employeesGroupedByDepartment(List<Employee> emps) {
//		If you want only emp id/name instead of whole emp obj do this
        Map<String, List<Integer>> map = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getId, toList())));

//		System.out.println(map);
        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    static private Map<String, Long> countOfEmployeesInEachDepartment(List<Employee> emps) {
        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    static private Map<String, Double> averageSalaryOfEachDepartment(List<Employee> emps) {
        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(emp -> emp.getSalary())));
    }

    static private Map<String, Optional<Employee>> highestSalaryInEachDepartment(List<Employee> emps) {
//        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        /*using lamdba*/
        return emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((a, b) -> (int) (a.getSalary()-b.getSalary()))));
    }

    static private Map<Double, List<Employee>> findNthHighestSalary(List<Employee> emps, int n) {
//		first group emps by their salaries, becuase there mayt be emps with same salaries.
//		below map stores all the unique salaries with list of emps;
        Map<Double, List<String>> map = emps.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getFirstName, toList())));
        List<Entry<Double, List<String>>> collect = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(toList());
//		System.out.println(collect);
//		return emps.stream().collect(Collectors.groupingBy(e -> e.getSalary(), Collectors.toList()))
//				.entrySet().stream()
//				.sorted((a, b) -> (int)(b.getKey() - a.getKey()))
//				.skip(n-1)
//				.limit(1).iterator().next();

//		return emps.stream().collect(Collectors.groupingBy(e -> e.getSalary()))
//				.entrySet().stream()
//				.sorted((a, b) -> (int)(b.getKey() - a.getKey()))
//				.skip(n-1)
//				.findFirst().get();

        return emps.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream()
//				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .sorted(Map.Entry.<Double, List<Employee>>comparingByKey(Comparator.reverseOrder()))
                .skip(n - 1)
                .limit(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//		return collect.get(n-1);
    }

    static private Map<Character, Long> countOfEachCharacter(String s) {
//		codePoints() returns ascii values of each character as intStream.
//		return s.codePoints().mapToObj(x -> (char)x).collect(Collectors.groupingBy(x->x, Collectors.counting()));
//		using arrays.stream but will return string
//		Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		Other way by using Function.identity() which identifies unique characters.
        return s.codePoints().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    static private List<Character> findAllDuplicateCharactersInAGivenString(String s) {
//		Other short way
//		return s.codePoints().mapToObj(c  -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
//		.entrySet().stream()
//		.filter(x -> x.getValue() > 1)
//		.map(Map.Entry::getKey)
//		.collect(Collectors.toList());

        Map<Character, Long> collect = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Set<Character> set = collect.keySet();
        Stream<Character> stream = set.stream().filter(x -> collect.get(x) > 1);
        return stream.collect(toList());

    }

    static private List<Character> findAllUniqueCharactersInAGivenString(String s) {
//		Q. Find if all the chars in string are unique:
//		Set<Character> set = new HashSet();
//		s.codePoints().mapToObj(x -> (char)x).collect(Collectors.toSet());
//		boolean result = set.size() == s.length();


//		Other short way
        return s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(toList());

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
        Map<Character, Long> collect = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
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
        Map<Character, Long> collect = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
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
//		return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//		if array has duplicates
//		return (int)Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).toArray()[0];
        return Arrays.stream(arr).boxed().sorted((a, b) -> b - a).skip(1).findFirst().get();
    }

    private static String findStringWithGreatestLength(String[] strArr) {
//		return Arrays.stream(strArr).reduce((s1, s2) -> s2.length() > s1.length()? s2: s1).get();
//		if input array has elements with same length:
        return Arrays.stream(strArr).collect(Collectors.groupingBy(String::length, toList())).entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(toList()).get(0).getValue().get(0);
    }

    private static List<String> findAllElementsWhichStartsWith1InAnArray(int[] arr) {
        return Arrays.stream(arr).boxed().map(s -> s + "").filter(s -> s.startsWith("1")).collect(toList());
    }

    private static List<Integer> findEvenInAList(int[] arr) {
        return Arrays.stream(arr).boxed().filter(x -> x % 2 == 0).collect(toList());
    }

    private static String stringJoinExample(List<String> list) {
//		String.join(delimeter, list) -> u can use any delimeter
        return java.lang.String.join("-", list);
    }

    private static List<Integer> skipFirstAndLastInAList(IntStream stream) {
//		Other way
//		IntStream.rangeClosed(1, 10)
//		.skip(1)
//		.limit(8)
//		.forEach(System.out::print);
        return stream.mapToObj(x -> (int) x).skip(1).limit(8).collect(toList());
    }

    private static long findMaxInAList(List<Integer> list) {
        Optional<Integer> opt = list.stream()
                .max(Integer::compare);
        return opt.isPresent() ? opt.get() : 0;
    }

    private static List<String> concatenateTwoStreams(List<String> l1, List<String> l2) {
        // Concatenated the list1 and list2 by converting them into Stream
        Stream<String> concatStream = Stream.concat(l1.stream(), l2.stream());

        // Printed the Concatenated Stream
//        concatStream.forEach(str -> System.out.print(str + " "));

        List<String> collect = concatStream.collect(toList());
        return collect;

    }

    private static Map<String, Long> findOnlyDuplicateStringsWithItsCountFromAList(List<String> l1) {

        IntStream.rangeClosed(1, 10).mapToObj(x -> x).collect(toList());

        return l1.stream()
                .filter(x -> Collections.frequency(l1, x) > 1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        //other simple way
//		return l1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
//				entrySet().stream()
//				.filter(x -> x.getValue() > 1)
//				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }

}










