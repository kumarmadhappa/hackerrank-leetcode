package secretCode.code.numbers;

public class NumberFinder {

	public boolean checkIfKeithComposite(int number)
	{
		boolean flag = false;

		String numStr = Integer.toString(number);
		char[] cArray = numStr.toCharArray();
		int[] iArray = new int[numStr.length()];
		for (int i = 0; i < numStr.length(); i++)
		{
			iArray[i] = Integer.parseInt(String.valueOf(cArray[i]));
		}
		// System.out.println(Arrays.toString(iArray));

		int sum = 0;
		while (sum < number)
		{
			sum = 0;
			int tempSum = 0; //To check possibilility of skipping one loop
			for (int i = 0; i < numStr.length(); i++)
			{
				sum += iArray[i];
				if (i > 0)
				{
					tempSum += iArray[i];
				}
				//Left shifting the elements in the array 
				if (i < numStr.length() - 1)
				{
					iArray[i] = iArray[i + 1];
				}
				else
				{
					iArray[i] = sum;
				}

			}

			//Cheking the next sum
			if ((tempSum + sum) > number)
			{
				flag = false;
				break;
			}
			if ((tempSum + sum) == number)
			{
				flag = true;
				break;
			}
		}
		
		if (flag==true) {
			//composite number is a positive integer that is not a prime number 
			flag=!checkIfPrime(number);
		}

		return flag;
	}
	
	public boolean checkIfPrime(int num)
	{
		int i, m = 0;
		boolean flag = true;
		m = num / 2;
		if (num == 1)
		{
			flag = false;
		}

		else if (num > 1)
		{
			for (i = 2; i <= m; i++)
			{
				if (num % i == 0)
				{
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}

	public static void main(String[] args)
	{
		NumberFinder nf = new NumberFinder();
		System.out.println(nf.checkIfKeithComposite(197));

	}

}
