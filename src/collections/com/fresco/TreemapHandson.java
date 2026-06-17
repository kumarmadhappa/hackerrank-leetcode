package collections.com.fresco;

import java.sql.Array;
import java.util.*;
import java.util.Map.Entry;

public class TreemapHandson {

	public TreeMap<Integer, String> createPlayerPositionMap(String cricketDataset)
	{
		TreeMap<Integer, String> ppMap = new TreeMap<>();
		String[] player = cricketDataset.split("\\|");
		for (int i = 0; i < player.length; i++)
		{
			String[] playerDet = player[i].split(",");
			ppMap.put(Integer.parseInt(playerDet[0]), playerDet[1]);
		}
		return ppMap;
	}

	public TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset)
	{

		TreeMap<String, Integer> psMap = new TreeMap<>();
		String[] player = cricketDataset.split("\\|");
		for (int i = 0; i < player.length; i++)
		{
			String[] playerDet = player[i].split(",");
			psMap.put(playerDet[1], Integer.parseInt(playerDet[2]));
		}
		return psMap;

	}

	public TreeMap<?, ?> createMatchesMap(String cricketDataset)
	{
		TreeMap<Integer, TreeMap<Integer, String[]>> mMap = new TreeMap<>();

		String[] match = cricketDataset.split("\n");
		for (int i = 0; i < match.length; i++)
		{
			TreeMap<Integer, String[]> psMap = new TreeMap<>();
			String[] player = match[i].split("\\|");
			for (int j = 0; j < player.length; j++)
			{
				String[] playerDet = player[j].split(",");
				psMap.put(Integer.parseInt(playerDet[0]), new String[]
				{ playerDet[1], playerDet[2] });
			}
			mMap.put(i, psMap);
		}

		return mMap;
	}

	public String getQuery(String cricketDataset, String query)
	{
		String result = null;
		System.out.println("query=" + query);

		String[] queryDet = query.split(" ");
		String queryNo = queryDet[0];
		switch (queryNo)
		{
			case "1":
				result = handleQuery1(createPlayerPositionMap(cricketDataset), queryDet[1], queryDet[2]);
				break;
			case "2":
				result = handleQuery2(createPlayerScoreMap(cricketDataset), createPlayerPositionMap(cricketDataset),
						queryDet[1]);
				break;
			case "3":
				result = handleQuery3(cricketDataset);
				break;
		}

		return result;
	}

	private String handleQuery3(String cricketDataset)
	{ // best opener code

		String[] match = cricketDataset.split("\n");
		HashMap<String, ArrayList<Integer>> hmap = new HashMap<>();
		for (int i = 0; i < match.length; i++)
		{
			String[] player = match[i].split("\\|");
			for (int j = 0; j < player.length; j++)
			{
				String[] playerDet = player[j].split(",");
				if (playerDet[0].equals("1"))
				{
					ArrayList<Integer> list = hmap.get(playerDet[1]);
					if (list != null && list.size() > 0)
					{
						list.add(Integer.parseInt(playerDet[2]));
					}
					else
					{
						list = new ArrayList<>();
						list.add(Integer.parseInt(playerDet[2]));
					}
					hmap.put(playerDet[1], list);
				}
			}
			

		}
		TreeMap<Double, String> best = new TreeMap<>();
		for (Map.Entry<String, ArrayList<Integer>> ele : hmap.entrySet())
		{
			ArrayList<Integer> list = ele.getValue();
			double sum = 0;
			double average;
			for (int i = 0; i < list.size(); i++)
			{
				sum += list.get(i);
			}
			average = sum / list.size();
			best.put(average, ele.getKey());
		}

		return "The Efficient Opener is " + best.lastEntry().getValue();
	}

	private String handleQuery2(TreeMap<String, Integer> playerScoreMap, TreeMap<Integer, String> playerPositionMap,
			String score)
	{
		StringBuilder result = new StringBuilder();

		for (Map.Entry<Integer, String> pp : playerPositionMap.entrySet())
		{
			for (Map.Entry<String, Integer> ps : playerScoreMap.entrySet())
			{
				int pos = 0;
				if (pp.getValue().equals(ps.getKey()))
				{
					pos = pp.getKey();
					if (ps.getValue().intValue() > Integer.parseInt(score))
					{
						result.append(pos + " " + ps.getKey() + "\n");
						break;
					}
				}

			}

		}

		return result.toString();

	}

	private String handleQuery1(TreeMap<Integer, String> playerPositionMap, String start, String end)
	{

		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, String> pp : playerPositionMap.entrySet())
		{
			if (pp.getKey().intValue() >= Integer.parseInt(start) && pp.getKey().intValue() <= Integer.parseInt(end))
			{
				result.append(pp.getKey() + " " + pp.getValue() + "\n");
			}
		}
		return result.toString();
	}

}
