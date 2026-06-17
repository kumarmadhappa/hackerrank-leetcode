package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseWordsInAString {
    //Leetcode Problem 151
    public String reverseWords(String s) {
        String[] words = s.replaceAll("\\s+"," ")
                .trim()
                .split(" ");
        Arrays.stream(words)
                        .forEach(System.out::print);
        System.out.println(Arrays.toString(words));
        StringBuilder replaced = new StringBuilder();
        for (int i=0;i<words.length;i++){
            replaced.append(words[words.length-1-i])
                    .append(" ");
        }
        return replaced.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString rev = new ReverseWordsInAString();
        System.out.println(rev.reverseWords("Hello  the  World   !!  thanks   great "));
        HashSet<String> hs = new HashSet<>();
        hs.add("One");
        hs.add("Kumar");

        System.out.println(hs);
    }
}
