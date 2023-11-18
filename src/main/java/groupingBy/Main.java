package groupingBy;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> strings = Stream.of(
                "one", "two", "three", "four", "five", "six", "seven"
        );

        //  quelle est la longueur de chaine la plus frequente ?

        /*
         * Table de hachage
         * 3  one, two, six
         * 4 four, five
         * 5 three, seven
         * */

        Map<Integer, Long> map = strings.collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()
        ));

        Optional<Map.Entry<Integer, Long>> result = map.entrySet().stream()
                .max(
                        Comparator.comparing(Map.Entry::getValue));
        result.ifPresent(entry -> System.out.println("Longueur la plus fréquente: " + entry.getKey()));

    }
}
