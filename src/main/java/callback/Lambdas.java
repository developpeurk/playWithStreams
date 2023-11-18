package callback;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        Function<String, String> upperCaseName2 = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String,Integer, String> upperCaseName3 = (name, age) -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        String uperCasedName = upperCaseName3.apply("Alex", 20);
        System.out.println(uperCasedName);
    }
}
