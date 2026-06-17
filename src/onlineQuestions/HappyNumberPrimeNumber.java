package onlineQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HappyNumberPrimeNumber
{
	public static void main(String args[]) throws Exception
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int end = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		scanner.close();
		Parent p = new ChildOne(start, end);

		System.out.println(p.filter());

		p = new ChildTwo(start, end);
		System.out.println(p.filter());
		// Collections.sort(((ChildTwo)p).happyNumbers);
		// Collections.sort(((ChildTwo)p).notHappyNumbers);
		// System.out.println("Happy Numbers-" + ((ChildTwo)p).happyNumbers);
		// System.out.println("UnHappy Numbers-" +((ChildTwo)p).notHappyNumbers);

	}
}

class Parent
{
	public int startElement;
	public int endElement;

	public Parent()
	{
	}

	public Parent(int start, int end)
	{
		startElement = start;
		endElement = end;
	}

	public String filter()
	{
		return null;
	}
}

class ChildOne extends Parent
{

	public ChildOne(int start, int end)
	{
		super(start, end);
	}

	public String filter()
	{
		StringBuilder output = new StringBuilder();
		List<Integer> prime = new ArrayList<>();
		for (int i = startElement; i <= endElement; i++)
		{
			if (checkIfPrime(i))
			{
				prime.add(i);
			}
		}

		for (int i = 0; i < prime.size(); i++)
		{
			if (i == 0)
				output.append(prime.get(i));
			else
			{
				output.append(" ");
				output.append(prime.get(i));
			}
		}

		return output.toString();
	}

	public boolean checkIfPrime(int n)
	{
		int i, m = 0, flag = 0;
		m = n / 2;
		if (n == 1)
		{
			flag = 1;
		}

		else if (n > 1)
		{
			for (i = 2; i <= m; i++)
			{
				if (n % i == 0)
				{
					flag = 1;
					break;
				}
			}
		}
		if (flag == 0)
			return true;
		else
			return false;
	}
}

class ChildTwo extends Parent
{

	List<Integer> happyNumbers = new ArrayList<>();
	List<Integer> notHappyNumbers = new ArrayList<>();
	List<Integer> tmpCheck = new ArrayList<>();

	public ChildTwo(int start, int end)
	{
		super(start, end);
	}

	public String filter()
	{
		// System.out.println("Satrt");
		StringBuilder output = new StringBuilder();
		for (int i = startElement; i <= endElement; i++)
		{
			tmpCheck = new ArrayList<>();
			if (checkIfHappyNumber(i))
			{
				happyNumbers.addAll(tmpCheck);
				output.append(i + " ");
			}
			else
			{
				notHappyNumbers.addAll(tmpCheck);
			}
		}
		return output.toString().trim();
	}

	public boolean checkIfHappyNumber(int n)
	{

		boolean flag;
		if (happyNumbers.contains(n))
		{
			flag = true;
		}
		else if (notHappyNumbers.contains(n))
		{
			flag = false;
		}
		else
		{
			if (tmpCheck.contains(n))
			{
				flag = false;
			}
			else
			{
				tmpCheck.add(n);
				if (n == 1)
				{
					flag = true;
				}
				else
				{
					int num = n;
					int newNum = 0;
					while (num > 0)
					{
						int rem = num % 10;
						newNum += rem * rem;
						num = num / 10;
					}
					if (newNum == 1)
					{
						flag = true;
					}
					else
					{
						flag = checkIfHappyNumber(newNum);
					}

				}

			}

		}
		return flag;
	}
}