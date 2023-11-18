package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "hello@gmail.com",
                "+0898787879878",
                LocalDate.of(1986,1,1)
        );

        // using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isAnAdult())
                .and(isPhoneValid())
                .apply(customer);
        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
