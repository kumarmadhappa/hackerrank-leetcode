package onlineQuestions;

public class CountingValleys
{

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s)
	{

		int currentLevel = 0;
		int vCount = 0;
		int mCount = 0;
		for (int i = 0; i < n; i++)
		{
			char ch = s.charAt(i);
			if (ch == 'D')
			{
				currentLevel--;
				if (currentLevel == 0)
				{
					mCount++;
				}

			}
			else
			{
				currentLevel++;
				if (currentLevel == 0)
				{
					vCount++;
				}

			}

		}
		System.out.println("Valley count-" + vCount + "\nMountain Count-" + mCount);

		return vCount;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int n = 8;
		String s = "DDUUUUDD";
		int result = countingValleys(n, s);
		System.out.println(result);
	}

}
