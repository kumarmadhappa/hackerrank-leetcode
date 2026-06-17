package onlineQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two integer arrays A and B of size N.
 * 
 * <br>There are N gas stations along a circular route, where the amount of gas at
 * station i is A[i].
 * 
 * <br>You have a car with an unlimited gas tank and it costs B[i] of gas to travel
 * from station i to its next station (i+1). 
 * 
 * <p>You begin the journey with an empty tank at one of
 * the gas stations.
 * <br>Return the minimum starting gas station�s index if you can travel around the
 * circuit once, otherwise return -1.
 * 
 * <br>You can only travel in one direction. i to i+1, i+2, � n-1, 0, 1, 2..
 * Completing the circuit means starting at i and ending up at i again.
 * 
 * 
 * 
 * 
 * <p>Input Format
 * 
 * <br>The first argument given is the integer array A. The second argument given is
 * the integer array B. Output Format
 * 
 * <br>Return the minimum starting gas station's index if you can travel around the
 * circuit once, otherwise return -1. For Example
 * 
 * <p>Input 1: A = [1, 2] B = [2, 1] Output 1: 1 
 * <p>Explanation 1: 
 * <br>If you start from
 * index 0, you can fill in A[0] = 1 amount of gas. <br>Now your tank has 1 unit of
 * gas. But you need B[0] = 2 gas to travel to station 1. 
 * <br>If you start from
 * index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of
 * gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0
 * and still have 1 unit of gas left over. You fill in A[0] = 1 unit of
 * additional gas, making your current gas = 2. It costs you B[0] = 2 to get to
 * station 1, which you do and complete the circuit.
 * 
 */
public class GasStation {
	public static void main(String[] args)
	{
		GasStation g = new GasStation();
		int[] a = { 1, 2, };
		int[] b = { 2, 1 };
		List<Integer> A = Arrays.stream(a).boxed().collect(Collectors.toList());// Arrays.asList(a)-- not possible
		List<Integer> B = Arrays.stream(b).boxed().collect(Collectors.toList());
		System.out.println(g.canCompleteCircuit(A, B));
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int canCompleteCircuit(final List<Integer> A, final List<Integer> B)
	{
		int res = -1;
		int size = A.size();
		for (int i = 0; i < size; i++)
		{
			int garInCar = 0;
			boolean successfulJourney = true;
			for (int j = 0; j < size; j++)
			{
				int var = (j + i) % size;
				int gas = A.get(var);
				int cost = B.get(var);
				if (garInCar + gas >= cost)
				{
					garInCar = garInCar + gas - cost;
				}
				else
				{
					successfulJourney = false;
					System.out.println("Can not complete journey starting from " + i);
					break;
				}
			}
			if (successfulJourney == true)
			{
				res = i;
			}
		}
		return res;
	}
}
