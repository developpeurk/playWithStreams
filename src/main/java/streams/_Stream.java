package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static streams.Gender.FEMALE;
import static streams.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people  = List.of(
                new Person("John", MALE),
                new Person("MARIA", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        Function<Person, Gender> personGenderFunction = person -> person.gender;
        Collector<Gender, ?, Set<Gender>> set = Collectors.toSet();
        Consumer<Gender> println = System.out::println;
        people.stream()
                .map(personGenderFunction)
                .collect(set)
                .forEach(println);

    }


    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}
