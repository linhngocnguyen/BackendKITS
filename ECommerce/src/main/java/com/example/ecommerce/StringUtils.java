package com.example.ecommerce;

public class StringUtils {
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }
}
