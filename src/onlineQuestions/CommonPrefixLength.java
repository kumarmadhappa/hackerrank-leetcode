package onlineQuestions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'commonPrefix' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * STRING_ARRAY inputs as parameter.
	 */

	public static List<Integer> commonPrefix(List<String> inputs)
	{
		// Write your code here

		List<Integer> res = new ArrayList<>();
		for (String inp : inputs)
		{
			int sum = inp.length();
			for (int i = 1; i < inp.length();)
			{
				//ababaa
				//a babaa
				//ab abaa
				
				
				String suffix = inp.substring(i);
				int prefixLength = 0;
				/*suffix.
				if (inp.charAt(i) == suffix.charAt())
				{
					prefixLength++;
				}
				else
				{
					break;
				}
				
				*/
				for (int j = 0; j < suffix.length(); j++)
				{
					if (inp.charAt(j) == suffix.charAt(j))
					{
						prefixLength++;
					}
					else
					{
						break;
					}
				}
				sum = sum + prefixLength;
			}

			res.add(sum);

		}

		return res;

	}

}

public class CommonPrefixLength {
	public static void main(String[] args) throws IOException
	{
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		// int inputsCount = Integer.parseInt(bufferedReader.readLine().trim());

		// List<String> inputs = IntStream.range(0, inputsCount).mapToObj(i -> {
		// try {
		// return bufferedReader.readLine();
		// } catch (IOException ex) {
		// throw new RuntimeException(ex);
		// }
		// })
		// .collect(toList());
		List<String> inputs = new ArrayList<String>();
		inputs.add("aa");
		List<Integer> result = Result.commonPrefix(inputs);

		System.out.println(result);

		/*
		 * bufferedWriter.write( result.stream() .map(Object::toString)
		 * .collect(joining("\n")) + "\n" );
		 * 
		 * // bufferedReader.close(); bufferedWriter.close();
		 */
	}
}
