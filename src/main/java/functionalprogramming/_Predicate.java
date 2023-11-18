package functionalprogramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09009877300"));
        System.out.println("with predicate");

        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        System.out.println(
                "Is phone number valid and contains number 3 : " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("07000300000"));

        System.out.println("BiPredicate example:");
        System.out.println("Is phone number valid and has area code '07': " +
                isPhoneNumberValidAndHasAreaCode.test("07000000000", "07"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static BiPredicate<String, String> isPhoneNumberValidAndHasAreaCode =
            (phoneNumber, areaCode) -> phoneNumber.startsWith(areaCode) && phoneNumber.length() == 11;


    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
         phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
