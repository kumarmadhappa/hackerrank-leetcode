package onlineQuestions;

import java.util.Arrays;
import java.util.Collections;

public class MonsoonUmbrella
{
	public static void main(String[] args)
	{
		int n = 37;
		int minCount = -1;
		int loopCount = 0;
		int[] u = { 19, 16, 6, 5 };
		Integer[] intArray = new Integer[u.length];

		for (int i = 0; i < u.length; i++)
		{
			intArray[i] = u[i];
		}
		int[] countArray = { loopCount, minCount };
		int[] minUmbrellaArray = new int[u.length];
		int[] tmpUmbrellaArray = new int[u.length];

		Arrays.sort(intArray, Collections.reverseOrder());
		System.out.println("The Umbrella Array is " + Arrays.toString(intArray));
		caculateMinUmbrella(n, 0, intArray, countArray, minUmbrellaArray, tmpUmbrellaArray);

		System.out.println("The Minimum umbrella required is " + countArray[1]);
	}

	private static int caculateMinUmbrella(int people, int arrPos, Integer[] intArray, int[] countArray,
			int[] minUmbrellaArray, int[] tmpUmbrellaArray)
	{
		System.out.println("Inside caculateMinUmbrella() with : People= " + people + " ,Array Position= " + arrPos
				+ " ,Count Array Values= " + Arrays.toString(countArray));
		int iCount = 0;
		int count = countArray[0];
		int origCount = countArray[0];
		int origPeople = people;
		int minCount = countArray[1];
		iCount = people / intArray[arrPos];
		if (iCount > 0 && iCount != people)
		{
			people = people % intArray[arrPos];
			count = count + iCount;
			countArray[0] = count;
			if (arrPos == 0)
				origCount = iCount;
		}
		tmpUmbrellaArray[arrPos]=iCount;
		if (people > 0)
		{
			if (arrPos + 1 < intArray.length)
				count = caculateMinUmbrella(people, arrPos + 1, intArray, countArray, minUmbrellaArray,
						tmpUmbrellaArray);
			else
				count = -1;
			countArray[0] = count;
		}
		if (countArray[0] == -1 || people > 0)
		{
			if (iCount > 0)
			{
				if (arrPos + 1 < intArray.length)
				{
					for (int i = 1; i <= iCount; i++)
					{
						countArray[0] = (arrPos != 0) ? origCount + iCount - i : iCount - i;
						tmpUmbrellaArray[arrPos]--;
						people = origPeople;
						people = people - intArray[arrPos] * (iCount - i);
						count = caculateMinUmbrella(people, arrPos + 1, intArray, countArray, minUmbrellaArray,
								tmpUmbrellaArray);
					}
				}
				else
				{
					count = -1;
				}
				tmpUmbrellaArray[arrPos]=count;
				countArray[0] = count;
			}
		}
		else if (people == 0 && ((countArray[0] != -1 && countArray[0] < minCount) || minCount == -1))
		{
			minCount = countArray[0];
			countArray[1] = minCount;
			for (int i = 0; i < minUmbrellaArray.length; i++)
			{
				minUmbrellaArray[i] = tmpUmbrellaArray[i];
			}
			System.out.print("The min number of umbrellas are : ");
			for (int i = 0; i < minUmbrellaArray.length; i++)
			{
				if (minUmbrellaArray[i]>0)
					System.out.print(intArray[i]+" = "+minUmbrellaArray[i]+",");
			}
			System.out.println("");
		}
		return countArray[0];
	}

}
