package com.play;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "A man a plan a canal Panama";
        System.out.println(isPalindrome(test) ? "Palindrome" : "Not Palindrome");
    }
}
