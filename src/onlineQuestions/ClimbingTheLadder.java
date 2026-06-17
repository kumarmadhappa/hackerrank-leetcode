package onlineQuestions;

public class ClimbingTheLadder
{

	public static void main(String[] args)
	{
		int[] scores = { 100, 100, 50, 40, 40, 20, 10 };
		int[] alice = { 5, 25, 50, 120 };
		int[] result = climbingLeaderboard(scores, alice);
		for (int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

	}

	static int[] climbingLeaderboard(int[] scores, int[] alice)
	{
		int[] rank = new int[scores.length];
		int[] aliceRanks = new int[alice.length];
		for (int i = 0; i < scores.length; i++)
		{
			if (i == 0)
			{
				rank[i] = 1;
			}
			else
			{
				if (scores[i] < scores[i - 1])
				{
					rank[i] = rank[i - 1] + 1;
				}
				else if (scores[i] == scores[i - 1])
				{
					rank[i] = rank[i - 1];
				}
			}
		}
		for (int j = 0; j < alice.length; j++)
		{
			int points = alice[j];
			int viewedScore = scores.length;
			for (int i = viewedScore - 1; i >= 0; i--)
			{
				if (points >= scores[0])
				{
					aliceRanks[j] = rank[0];
					viewedScore = 0;
					break;
				}
				else if (points < scores[scores.length - 1])
				{
					aliceRanks[j] = rank[scores.length - 1] + 1;
					viewedScore = scores.length;
					break;
				}
				else if (points == scores[scores.length - 1])
				{
					aliceRanks[j] = rank[scores.length - 1];
					viewedScore = scores.length;
					break;
				}
				else
				{
					if (points < scores[i] && points > scores[i + 1])
					{
						aliceRanks[j] = rank[i] + 1;
						viewedScore = i;
						break;
					}
					if (points == scores[i])
					{
						aliceRanks[j] = rank[i];
						viewedScore = i;
						break;
					}
				}
			}
		}
		return aliceRanks;
	}

}
