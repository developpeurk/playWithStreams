package Strings;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String s = "Bonjour le monde";
        IntStream str = s.chars();
        str.forEach(System.out::println); // Affiche les entiers représentant chaque caractère
        // Java 11
        IntStream newStr = s.chars();
        Stream<String> obj = newStr.mapToObj(lettre -> Character.toString((char) lettre));
        obj.forEach(System.out::println); // Affiche chaque caractère en tant que chaîne


        //Stream<String> obj = str.mapToObj(lettre -> Character.toString(lettre));

       // obj.forEach(System.out::println);
        // java 8

       // Stream<String> stream = str.mapToObj(lettre -> (char) lettre)

         //       .map(c -> Character.toString(c));
       // stream.forEach(System.out::println);

        Pattern pattern = Pattern.compile(" ");
        Stream<String> stringStream = pattern.splitAsStream(s);
        List<String> resultList = stringStream.collect(Collectors.toList());
        resultList.forEach(System.out::println);

    }
}
