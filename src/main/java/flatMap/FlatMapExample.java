package flatMap;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        // Méthode 1 : Créer un nouveau flux
        Stream<String> newLines = Stream.of(
                "un jardin de roses",
                "des fleurs colorées",
                "un raton laveur curieux"
        );
        Function<String, Stream<String>> t = line ->
                Pattern.compile(" ").splitAsStream(line);
        Stream<String> flattenedStream1 = newLines.flatMap(t);

        // Méthode 2 : Utiliser des fournisseurs pour réinitialiser le flux
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(
                "un jardin de roses",
                "des fleurs colorées",
                "un raton laveur curieux"
        );
        Stream<String> flattenedStream2 = streamSupplier.get().flatMap(t);

        // Affichage des résultats
        System.out.println("Flux aplatit avec méthode 1 :");
        flattenedStream1.forEach(System.out::println);

        System.out.println("\nFlux aplatit avec méthode 2 :");
        flattenedStream2.forEach(System.out::println);
    }
}

