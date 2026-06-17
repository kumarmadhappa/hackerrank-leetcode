package onlineQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonQ2 {
	public static void main(String args[])
	{
		int[] arr = { 3, 2, 3 };
		List<Integer> weight = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("Array:" + weight.toString());
		getTotalImbalance(weight);
	}

	public static long getTotalImbalance(List<Integer> weight)
	{
		long imbalanceW, imbalanceF = 0;
		//using While loop
		imbalanceW = usingWhileLoop(weight);
		//For Loop
		imbalanceF = usingForLoop(weight);
		System.out.println("imbalanceW=" + imbalanceW);
		System.out.println("imbalanceF=" + imbalanceF);
		return imbalanceF;
	}

	public static long usingWhileLoop(List<Integer> weight)
	{
		long imbalance = 0;
		int startInd = 0;
		int endInd = 0;
		int count = 1;
		while (count < weight.size())
		{
			startInd = 0;
			endInd = count;
			while (endInd < weight.size())
			{
				imbalance = imbalance + weightDifference(weight, startInd, endInd);
				startInd++;
				endInd++;
			}
			count++;
		}
		return imbalance;
	}

	public static long usingForLoop(List<Integer> weight)
	{
		long imbalance = 0;
		for (int count = 1; count < weight.size(); count++)
		{
			for (int startInd = 0, endInd = count; endInd < weight.size();startInd++,endInd++)
			{
				imbalance = imbalance + weightDifference(weight, startInd, endInd);
			}
		}
		return imbalance;
	}

	public static long weightDifference(List<Integer> weight, int start, int end)
	{
		int min = -1;
		int max = -1;
		for (int i = start; i <= end; i++)
		{
			if (min == -1 || weight.get(i) < min)
			{
				min = weight.get(i);
			}
			if (max == -1 || weight.get(i) > max)
			{
				max = weight.get(i);
			}
		}
		System.out.println("startInd=" + start + ",endInd=" + end + ", Diff=" + (max - min));
		return max - min;
	}
}
