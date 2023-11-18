package functionalprogramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ConsumerDemo {

    private static final Logger LOGGER = Logger.getLogger(ConsumerDemo.class.getName());

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "9999");
        greetCustomerConsumer.accept(customer, false);

        greetCustomerConsumer1.accept(customer);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumer = (customer, showPhoneNumber) ->
            LOGGER.info("Hello " + customer.getCustomerName() + ", thanks for registering phone number " +
                    (showPhoneNumber ? customer.getCustomerPhoneNumber() : "*****"));
static Consumer<Customer> greetCustomerConsumer1 = customer ->
            LOGGER.info("Hello " + customer.getCustomerName() + ", thanks for registering phone number " + customer.getCustomerPhoneNumber());

    static void greetCustomer(Customer customer) {
        LOGGER.info("Hello " + customer.getCustomerName() + ", thanks for registering phone number " + customer.getCustomerPhoneNumber());
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerPhoneNumber() {
            return customerPhoneNumber;
        }
    }
}
