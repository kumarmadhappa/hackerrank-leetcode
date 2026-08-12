package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        /*

        Example 1:

        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]

        //Check if teh new interval [0] is >= interval[i][0] and <=interval[i][1]
        //do this unitl newInterval[0]> interval[i][1]
        //this will find the interval where we have to merge.
        now interval is found , now need to check the

        Next , to find the end int
        newInterval[1]>=interval[i][1] and <=interval[i][0]
        unitl newInterval[1]< interval[i][0]


         */

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        result.add(new int[]{start, end});

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval test = new InsertInterval();
        int[][] result = test.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        System.out.println(Arrays.deepToString(result));


        result = test.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        System.out.println(Arrays.deepToString(result));
    }
}
