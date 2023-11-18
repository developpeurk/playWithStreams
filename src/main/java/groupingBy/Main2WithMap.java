package groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2WithMap {
    public static void main(String[] args) {
        Stream<String> strings = Stream.of(
                "one", "two", "three", "four", "five", "six", "seven", "eight"
        );

        // Quelle est la longueur de chaîne la plus fréquente ?

        /*
         * Table de hachage
         * 3  one, two, six       3
         * 4  four, five          2
         * 5  three, seven, eight 3
         * */

        Map<Integer, Long> lengthCounts = strings.collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()
        ));

        Map<Long, List<Integer>> result = lengthCounts.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                        )
                ));

        System.out.println("Table de hachage des longueurs de chaînes les plus fréquentes : ");
        result.forEach((count, lengths) -> System.out.println(count + " : " + lengths));
    }
}
