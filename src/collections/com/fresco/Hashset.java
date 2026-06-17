package collections.com.fresco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Hashset {

	public static String getOut(int numberOfMatches, String squads, int x, int y)
	{
		// write your code here
		String[] teams = squads.split("#");

		Map<Integer, HashSet<String>> matchArray = new HashMap<>();
		for (int i = 0; i < teams.length; i++)
		{
			HashSet<String> p = new HashSet<>();
			String[] matchPlayers = teams[i].split(" ");
			for (int j = 0; j < matchPlayers.length; j++)
			{
				p.add(matchPlayers[j]);
			}
			matchArray.put(i, p);
		}

		HashSet<String> mNo1 = matchArray.get(0);
		HashSet<String> commonPlayers = new HashSet<>();
		commonPlayers.addAll(mNo1);
		/*Iterator<String> itr= commonPlayers.iterator();
		while(itr.hasNext()) {
			String p = itr.next();
			for (int i = 1; i < teams.length; i++)
			{
				HashSet<String> m = matchArray.get(i);
				if(!m.contains(p)) {
					itr.remove();
					break;
				}
			}
		}*/
		for (int i = 1; i < teams.length; i++)
		{
			HashSet<String> m = matchArray.get(i);
			commonPlayers.retainAll(m);
		}

		HashSet<String> my = matchArray.get(y - 1);
		HashSet<String> mx = matchArray.get(x - 1);
		my.removeAll(mx);

		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = commonPlayers.iterator();
		while (itr.hasNext())
		{
			sb.append(itr.next() + " ");
		}

		sb = new StringBuilder(sb.toString().trim());
		sb.append(", ");
		itr = my.iterator();
		while (itr.hasNext())
		{
			sb.append(itr.next() + " ");
		}
		sb = new StringBuilder(sb.toString().trim());
		return sb.toString();
	}

	public static void main(String[] args)
	{
		String output = getOut(4,
				"Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Daniel Patrício Nelson Pepe Mario Pereira Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo",
				2, 4);
		System.out.println("output=" + output);
		System.out.println(
				"Actual=Pereira Ronaldo Goncalo Eder Andre Bruma, Ricardo Pizzi Semedo Bruno Domingos Bernardo");
	}
}
