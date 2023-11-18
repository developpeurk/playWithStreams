package groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {

        /*

        table de hachage
        key: valeur du stream
        value: nbre de fois cette valeur particuliere apparait dans le stream

        *  1 2 2 1 3 2 1 1 3 3 1 4

        * 1 -> 5      1 -> { 1,1,1,1,1 }
        * 2 -> 3
        * 3 -> 3
        * 4 -> 1
        * */

        Stream<Integer> stream = Stream.of(1,2,2,1,3,2,1,1,3,3,1,4);
        Map<Integer, Long> map = stream.collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));


        //map.forEach((key, value) -> System.out.println(key + " -> " + value));


        Optional<Map.Entry<Integer, Long>> result = map.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        result.ifPresent(entry -> System.out.println("{" +entry.getKey() +  "," +entry  .getValue() +"}"));



    }
}
