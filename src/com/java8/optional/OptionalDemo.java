package com.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = EkartDataBase.getAll();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(() -> new Exception("no customer present with this email id"));

    }

    public static void main(String[] args) throws Exception {

        /*change email field to null and valid value and run the program to understand better*/
        Customer customer = new Customer(101, "john", null, Arrays.asList("397937955", "21654725"));

        //empty
        //of
        //ofNullable

        /*emptty() gives Optional.empty*/
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        /*.of() use only when you're sure that value is not null
         * if null passed it will throw nullpointer exception*/
//        Optional<String> optionalOf = Optional.of(customer.getEmail());
        /*below throws nullponiterexc, because we put null in optional*/
        /*if(optionalOf.isPresent()){
            System.out.println(optionalOf);
        }*/


        /*Use ofNullable() when not sure if object is null or value is present
         * it will not throw nullpointer exception*/
        Optional<String> optionalOfNullable = Optional.ofNullable(customer.getEmail());
        if (optionalOfNullable.isPresent()) {
            System.out.println(optionalOfNullable.get());
        }
        /*assigning some default response when null or empty is present in optional*/
        System.out.println(optionalOfNullable.orElse("default@email.com"));

//         System.out.println(optionalOfNullable.orElseThrow(()->new IllegalArgumentException("email not present")));


        System.out.println(optionalOfNullable.map(String::toUpperCase).orElseGet(() -> "default email..."));

        getCustomerByEmailId("pqr");
    }
}

class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Customer() {
    }

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

class EkartDataBase {


    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }


}