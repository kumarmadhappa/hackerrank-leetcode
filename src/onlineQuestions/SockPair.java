package onlineQuestions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SockPair
{

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar)
	{
		int noOfPairs = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++)
		{
			if (map.get(ar[i]) != null)
			{
				int val = map.get(ar[i]);
				val++;

				if (val == 2)
				{
					noOfPairs++;
					map.put(ar[i], 0);
				}
				else
				{
					map.put(ar[i], val);
				}
			}
			else
			{
				map.put(ar[i], 1);
			}

		}
		return noOfPairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{

		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter("src\\resources\\SockPair_output.txt"));

		// int n = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		// int[] ar = new int[n];

		// String[] arItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int n = 9;
		String input = "10 20 20 10 10 30 50 10 20";
		int[] ar = new int[n];
		String[] arItems = input.split(" ");

		// List<String> arList=Arrays.asList(arItems);
		// List<Integer> intList =
		// arList.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());

		for (int i = 0; i < n; i++)
		{
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);
		System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
	}
}
