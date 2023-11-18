package takeWhile;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        long count = Stream.iterate("", s -> s + "+") // Commence avec une chaîne vide, ajoute "+" à chaque itération
                .takeWhile(s -> s.length() < 10) // S'arrête lorsque la longueur de la chaîne est >= 10
                .count(); // Compte le nombre d'éléments dans la séquence

        System.out.println(count); // Affiche le nombre d'éléments dans la séquence
    }
}
