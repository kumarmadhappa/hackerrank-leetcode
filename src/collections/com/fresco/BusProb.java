package collections.com.fresco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Passanger {
	int id;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public float getFare()
	{
		return fare;
	}

	public void setFare(float fare)
	{
		this.fare = fare;
	}

	float fare;

	public Passanger(int id, float fare)
	{
		this.id = id;
		this.fare = fare;
	}

	@Override
	public String toString()
	{
		return "Passanger [id=" + id + ", fare=" + fare + "]";
	}

}

public class BusProb {

	public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
	{
		StringBuilder output = new StringBuilder();
		int noOfPassenger = 0;
		int q1GotOntheBus = 0;
		int q1GotOfftheBus = 0;
		ArrayList<Float> fareList = new ArrayList<>(4);
		fareList.add((float) 0);
		fareList.add((float) 0);
		fareList.add((float) 0);
		fareList.add((float) 0);
		String passengerId ="" ;
		Passanger checkPassenger = null;
		String[] queryArray = query.split(",");
		String queryId = queryArray[0];
		if (queryArray.length>1) {
			passengerId = queryArray[1].trim();
			checkPassenger= new Passanger(Integer.parseInt(passengerId), 0);
		}
		
		ArrayList<Passanger> passangers = new ArrayList<>();
		
		int noOfTimes = 0;
		boolean presentInBus = false;

		for (int i = 0; i < stops; i++)
		{
			String busTnx = listOfInputStrings.get(i);
			String[] arr = busTnx.split(" ");

			int in = 0, out = 0;
			for (int j = 0; j < arr.length; j++)
			{
				if (arr[j].startsWith("+"))
				{
					in++;
				}
				else if (arr[j].startsWith("-"))
				{
					out++;
				}

			}
			q1GotOntheBus = q1GotOntheBus + in;
			q1GotOfftheBus = q1GotOfftheBus + out;
			noOfPassenger = noOfPassenger + in - out;
			System.out.println(Arrays.toString(arr));

			for (int j = 0; j < arr.length; j++)
			{
				if (arr[j].startsWith("+"))
				{
					int id = Integer.parseInt(arr[j].substring(1));
					float f = fare(capacity, noOfPassenger, fareList).get(0);
					Passanger p = new Passanger(id, f);
					passangers.add(p);

					if (checkPassenger!=null && checkPassenger.getId() == id)
					{
						float cost = checkPassenger.getFare() + f;
						checkPassenger.setFare(cost);
						noOfTimes++;
						presentInBus = true;
					}
				}
				else if (arr[j].startsWith("-"))
				{
					int id = Integer.parseInt(arr[j].substring(1));
					for (int k = 0; k < passangers.size(); k++)
					{
						if (passangers.get(k).getId() == id)
						{
							passangers.remove(k);
							if (checkPassenger!=null && checkPassenger.getId() == id)
							{
								presentInBus = false;
							}
							break;
						}
					}
				}

			}
			System.out.println(Arrays.toString(passangers.toArray()));
		}

		switch (queryId)
		{
			case "1":
				output.append(q1GotOntheBus + " passengers got on the bus and ");
				output.append(q1GotOfftheBus + " passengers got out of the bus");
				break;
			case "2":
				output.append(fareList.get(3).intValue() + " passengers traveled with a fare of "
						+ (float) (capacity + capacity * 0.6) + ", ");
				output.append(fareList.get(2).intValue() + " passengers traveled with a fare of "
						+ (float) (capacity + capacity * 0.3) + " and ");
				output.append(fareList.get(1).intValue() + " passengers traveled with a fare of " + (float) (capacity));
				break;
			case "3":
				output.append("Passenger " + passengerId + " spent a total fare of " + checkPassenger.getFare());
				break;
			case "4":
				output.append("Passenger " + passengerId + " has got on the bus for " + noOfTimes + " times");
				break;
			case "5":
				output.append("Passenger " + passengerId + " was " + ((presentInBus == true) ? "inside" : "not inside")
						+ " the bus at the end of the trip");
				break;
		}
		return output.toString();
	}

	private ArrayList<Float> fare(int capacity, int noOfPassenger, ArrayList<Float> fare)
	{
		double fiftyPercentCapacity = Math.ceil(capacity / 2.0);
		double twentyFivePercentCapacity = Math.ceil(capacity / 4.0);
		System.out.println("fiftyPercentCapacity=" + fiftyPercentCapacity + ";" + "twentyFivePercentCapacity="
				+ twentyFivePercentCapacity);
		if (noOfPassenger > fiftyPercentCapacity)
		{
			fare.set(0, (float) capacity);
			fare.set(1, fare.get(1) + 1);
		}
		else if (noOfPassenger <= fiftyPercentCapacity && noOfPassenger > twentyFivePercentCapacity)
		{
			fare.set(0, (float) (capacity + capacity * 0.3));
			fare.set(2, fare.get(2) + 1);
		}
		else if (noOfPassenger <= twentyFivePercentCapacity)
		{
			fare.set(0, (float) (capacity + capacity * 0.6));
			fare.set(3, fare.get(3) + 1);
		}
		return fare;
	}

	public static void main(String[] args)
	{

		BusProb b = new BusProb();
		int capacity = 8;
		int stops = 5;
		List<String> listOfInputs = new ArrayList<>();
		
		capacity=8;
        stops=5;
        listOfInputs.add("+1001 +1002 +1003 +1004 +1005 +1015");
        listOfInputs.add("-1001 -1003 -1005 +1006 +1007 -1015");
        listOfInputs.add("+1008 -1004 -1002 +1009 -1006 +1001");
        listOfInputs.add("-1008 +1010 -1009 +1005 -1007");
        listOfInputs.add("+1011 -1010 -1005");
        String query="5, 1001";
        
		/*
		 * listOfInputs.add("+1001 +1002 +1003 +1004 +1005 +1015");
		 * listOfInputs.add("-1001 -1003 -1005 +1006 +1007 -1015");
		 * listOfInputs.add("+1008 -1004 -1002 +1009 -1006 +1001");
		 * listOfInputs.add("-1008 +1010 -1009 +1005 -1007");
		 * listOfInputs.add("+1011 -1010 -1005");
		 * String query = "1";
		 */

		/*capacity = 10;
		stops = 4;
		listOfInputs.add("+2501 +2502 +2503 +2504");
		listOfInputs.add("-2501 -2504 +2505 +2506 +2507 +2509");
		listOfInputs.add("+2501 +2511 -2502 -2505");
		listOfInputs.add("+2513 -2507 -2503 -2511 -2509");*/

		/*capacity=18;
		stops=8;
		listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
		listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
		listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
		listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
		listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
		listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
		listOfInputs.add("+65446 +10412 +12412 +68723 -532");
		listOfInputs.add("+7545 +8651 -4131 -562");
		String query="2";*/
		 

		/*capacity = 30;
		stops = 12;
		listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
		listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
		listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
		listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
		listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
		listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
		listOfInputs.add(
				"-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
		listOfInputs.add("+141 +142");
		listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
		listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
		listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
		listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
		String query = "3, 101";*/

		String result = b.output(capacity, stops, listOfInputs, query);
		System.out.println(result);
		System.out.println(result.hashCode());
	}
}
