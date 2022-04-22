package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;


class Hashes {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("/Users/Asus/Desktop/kohonen-oct/harry.txt")));
        content =content.toLowerCase(Locale.ROOT).replaceAll(" [^A-Za-z]", "");
        String[] words = content.split(" + ");
        content = null;
        Arrays.sort(words);

        String distinctString = " ";
        for (int i = 0; i < words.length; i++) {
            if(!distinctString.contains(words[i])){
                distinctString+=words[i]+ "";
            }
        }

        String[] distinct = distinctString.split(" ");
        int[] hashes = new int[distinct.length];
        for (int i = 0; i < 10; i++) {
            System.out.println(distinct[i] +"-"+ distinct[i].hashCode());
            hashes[i] = distinct[i].hashCode();
        }
    }
}
