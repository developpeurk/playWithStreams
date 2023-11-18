package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people =getPeople();

        // Filter
        List<Person> female = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();
        //female.forEach(System.out::println);

        //Sort by the actual age
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getGender).reversed())
                .toList();
       // sorted.forEach(System.out::println);


        // All Match

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
      //  System.out.println(allMatch);

        // Any Match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
         //System.out.println(anyMatch);


        // None Match
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Antonio"));
        //System.out.println(noneMatch);


        // Max

        people.stream()
                .max(Comparator.comparing(Person::getAge));
               // .ifPresent(System.out::println);


        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge));
              //  .ifPresent(System.out::println);

        // Group based on gender
        Map<Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));

        /*groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });*/


        // chaining 'find out every single female and then grab
        // all the oldest female and pretty much just return the first name

        Optional<String> oldestFemaleAge = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 8, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 22, Gender.FEMALE),
                new Person("Jamie Goa", 10, Gender.MALE),
                new Person("Anna Cook", 27, Gender.FEMALE),
                new Person("Zelda Brown", 26, Gender.FEMALE)
        );
    }
}
