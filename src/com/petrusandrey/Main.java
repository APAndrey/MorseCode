package com.petrusandrey;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(Arrays.toString(words));
        System.out.println("Unique messages: " + uniqueMorseRepresentations(words));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        StringBuilder sb = new StringBuilder();
        HashSet<String> setMorse = new HashSet<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= 'A' && word.charAt(j) <= 'Z') {
                    sb.append(MORSE[word.charAt(j) - 65]);
                } else if (word.charAt(j) >= 'a' && word.charAt(j) <= 'z') {
                    sb.append(MORSE[word.charAt(j) - 97]);
                } else {
                    throw new IllegalArgumentException("Wrong command!");
                }
            }
            setMorse.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return setMorse.size();
    }
}