package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    public int firstUniqueUsingStreams(String input){
        //using streams

        HashMap<Integer,Integer> map = new HashMap<>();

        final int[] result = new int[1];
        Optional<Map.Entry<Character, Long>> nonRepeated = input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()==1)
                .findFirst();


        nonRepeated.ifPresentOrElse(
                ch -> result[0] =input.indexOf(ch.getKey()),
                ()-> result[0] =-1
        );

        return result[0];

    }

    public int firstUniqueUsingArrays(String s){

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for (int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatedCharacter obj = new FirstNonRepeatedCharacter();
        System.out.println(obj.firstUniqueUsingStreams("leetcode"));
        System.out.println(obj.firstUniqueUsingArrays("lleettccoodde"));
    }

}
