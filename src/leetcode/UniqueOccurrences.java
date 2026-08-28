package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> count = new HashMap<>();

        for(int num:arr){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        HashSet<Integer> unique = new HashSet<>(count.values());

        return unique.size() == count.size();

    }

    public boolean anotherWay(int[] arr) {

        Map<Integer, Integer> count = new HashMap<>();


        for(int num:arr){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        HashSet<Integer> unique = new HashSet<>();

        for(int num: count.values()){
            if(!unique.contains(num))
                unique.add(num);
            else return false;
        }

        return true;


    }

    public static void main(String[] args) {
        UniqueOccurrences prob =  new UniqueOccurrences();
        System.out.println(prob.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(prob.uniqueOccurrences(new int[]{1,2}));
        System.out.println(prob.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));


        System.out.println(prob.anotherWay(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
