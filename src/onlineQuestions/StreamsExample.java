package onlineQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample
{

	public static void main(String[] args)
	{
		List<String> nameList = Arrays.asList("Ram", "Amit", "Ashok", "Manish", "Rajat");
		List<String> fileteredList = nameList.stream().filter(n -> !n.startsWith("A")).sorted().collect(Collectors.toList());
		nameList.stream().filter(n -> !n.startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println(fileteredList);
		HashMap<String, String>  map= new HashMap<>();
		
		
		
	}

}

