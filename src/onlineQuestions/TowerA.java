package onlineQuestions;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class TowerA
{

	public static void main(String[] args)
	{
		//Scanner scan = new Scanner(System.in);
		ArrayList<String> inputArray = new ArrayList<String>();
		/*while (scan.hasNextLine())
		{
			String string = scan.nextLine();
			if (string.equals("EOL"))
			{
				break;
			}
			inputArray.add(string);

			long value = powerOfX(inputArray.get(1), inputArray, 1) % Integer.parseInt(inputArray.get(0));

		}*/
		inputArray.add("5");
		inputArray.add("139");
		inputArray.add("14036");
		inputArray.add("6967");
		/*inputArray.add("7");
		inputArray.add("9");
		inputArray.add("11");*/
		inputArray.remove(0);
		
		long value = powerOfX(inputArray.get(1), inputArray, 1) % Integer.parseInt(inputArray.get(0));
		
		System.out.println(value);
	}

	private static long powerOfX(String string, ArrayList<String> inputArray, int pos)
	{
		// TODO Auto-generated method stu
		long power = 1;
		if  (pos + 1 < inputArray.size())
		{
			power = powerOfX(inputArray.get(pos + 1), inputArray, pos + 1);
		}
		
		power = (long) Math.pow(Integer.parseInt(string), power);
		return power;
	}

}
