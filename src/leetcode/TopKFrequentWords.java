package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);
        Arrays.stream(words).forEach(s -> map.put(s, map.getOrDefault(s, 0)+1));
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());


    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};// [i, love]
        //String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"}; //[the, is, sunny, day]
        int k = 2;
        TopKFrequentWords solution = new TopKFrequentWords();
        List<String> result = solution.topKFrequent(words, k);
        System.out.println(result);
    }
}
