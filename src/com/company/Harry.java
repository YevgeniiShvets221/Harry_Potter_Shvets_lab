package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Harry{

    public static void main(String[] args) throws IOException {
        String text = readWords("/Users/Asus/Desktop/kohonen-oct/harry.txt");
        System.out.println("Word Harry is met (times):");
        System.out.println(countLinesWithWord("Harry", splitOnLines(text)));
    }
    public static String readWords(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    public static String[] splitOnLines(String text){
        return text.split("\n");
    }
    public static int countLinesWithWord(String word, String[] text){
        int counter = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i].contains(word)) {
                counter += 1;
            }
        }
        return counter;

    }

}