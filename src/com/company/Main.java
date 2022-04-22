package com.company;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();
        Arrays
                .stream(new String(Files.readAllBytes(Paths.get("/Users/Asus/Desktop/kohonen-oct/harry.txt")))
                        .toLowerCase(Locale.ROOT)
                        .replaceAll("[^A-Za-z]", " ")
                        .split(" + "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(20)
                .forEach(System.out::println);

        System.out.println(ChronoUnit.MILLIS.between(start, LocalDateTime.now()));

        String content = new String(Files.readAllBytes(Paths.get("/Users/Asus/Desktop/kohonen-oct/harry.txt")));
        StringTokenizer string = new StringTokenizer(content);
        int maxLengthOfWord = 0;

        while (string.hasMoreTokens()) {
            String word = string.nextToken();
            int wordLength = word.length();

            if (maxLengthOfWord == 0) {
                content = word;
                maxLengthOfWord = wordLength;
            } else if (wordLength > maxLengthOfWord) {
                maxLengthOfWord = wordLength;
                content = word;
            }
        }

        if (maxLengthOfWord > 0)
            System.out.println("Longest word in the text is: " + content);

        else {
            System.out.println("No word in string!");
        }


        String content1 = new String(Files.readAllBytes(Paths.get("/Users/Asus/Desktop/kohonen-oct/harry.txt")));
        String[] harry = content1.split(" ");
        long countC = Arrays.stream(harry)
                .filter(str -> str.toLowerCase().charAt(0) == 'c')
                .count();
        System.out.println("From the letter C begins " + countC + " words");
    }
}









