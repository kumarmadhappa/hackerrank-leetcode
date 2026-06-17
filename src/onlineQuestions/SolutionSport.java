package onlineQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionSport
{
	public static void main(String args[])
	{
		//Scanner sc = new Scanner(System.in);
		int[] hockeyPlayers = new int[11];
		int[] footballPlayers = new int[11];
		//2 0 0 0 1 1 0 0 0 1 0
		//2 1 0 3 0 0 0 0 0 0 0
		
		String[] hockeyPlayersInp = "6 0 0 0 1 1 0 0 0 1 0".split(" ");
		String[] footballPlayersInp = "2 1 10 3 0 0 0 0 0 0 0".split(" ");
		for (int i = 0; i < 11; i++)
		{
			hockeyPlayers[i] = Integer.parseInt(hockeyPlayersInp[i]);
		}

		for (int i = 0; i < 11; i++)
		{
			footballPlayers[i] = Integer.parseInt(footballPlayersInp[i]);
		}

		Sport s = new Sport(hockeyPlayers, footballPlayers);
		try
		{
			HockeyTeam.class.getMethod("calculateHockeyScore");
			HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
			FootballTeam.class.getMethod("calculateFootballScore");
			FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

			if (s instanceof HockeyTeam && s instanceof FootballTeam)
			{
				System.out.println(s.calculateHockeyScore());
				System.out.println(s.calculateFootballScore());
				System.out.println(s.findHighestGoalByIndividualInHockey());
				System.out.println(s.findHighestGoalByIndividualInFootball());
			}
		}
		catch (NoSuchMethodException ex)
		{
			System.out.println("No such function is exits");
		}
	}
}

class Sport implements HockeyTeam, FootballTeam
{

	int[] hockeyPlayers;
	int[] footballPlayers;

	public Sport(int[] hockeyPlayers, int[] footballPlayers)
	{
		super();
		this.hockeyPlayers= new int[hockeyPlayers.length];
		this.footballPlayers= new int[footballPlayers.length];

		for (int i = 0; i < hockeyPlayers.length; i++)
			this.hockeyPlayers[i] = hockeyPlayers[i];

		for (int i = 0; i < footballPlayers.length; i++)
			this.footballPlayers[i] = footballPlayers[i];

	}

	@Override
	public int calculateFootballScore()
	{
		int totalScore=0;
		for(int i=0;i<footballPlayers.length;i++) {
			totalScore+=footballPlayers[i];
		}
		
		return totalScore;
	}

	@Override
	public int findHighestGoalByIndividualInFootball()
	{
		int maxScore=0;
		for(int i=0;i<footballPlayers.length;i++) {
			if(footballPlayers[i]>maxScore) {
				maxScore=footballPlayers[i];
			}
		}
		
		return maxScore;
	}

	@Override
	public int calculateHockeyScore()
	{
		int totalScore=0;
		for(int i=0;i<hockeyPlayers.length;i++) {
			totalScore+=hockeyPlayers[i];
		}
		
		return totalScore;
	}

	@Override
	public int findHighestGoalByIndividualInHockey()
	{
		int maxScore=0;
		for(int i=0;i<hockeyPlayers.length;i++) {
			if(hockeyPlayers[i]>maxScore) {
				maxScore=hockeyPlayers[i];
			}
		}
		
		return maxScore;
	}

}

interface HockeyTeam
{

	public int calculateHockeyScore();

	public int findHighestGoalByIndividualInHockey();

}

interface FootballTeam
{

	public int calculateFootballScore();

	public int findHighestGoalByIndividualInFootball();

}