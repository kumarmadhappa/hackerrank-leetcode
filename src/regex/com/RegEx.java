package regex.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public String findCardTypeNumbers(String conversation, String cardType)
	{
		String output;
		switch (cardType)
		{
			case "Visa":
				output = findVisa(conversation);
				break;
			case "American Express":
				output = findAmex(conversation);
				break;
			case "Discover":
				output = findDiscover(conversation);
				break;
			case "JCB":
				output = findJCB(conversation);
				break;
			default:
				output = "Not a valid card type";
				break;
		}
		return output;
	}

	private String findJCB(String conversation)
	{
		Pattern pattern = Pattern.compile(
				"\\b([2][1][3][1][0-9]{11}[,\\s\\.])|([1][8][0][0][0-9]{11}[,\\s\\.])|([3][5][0-9]{14}[,\\s\\.])");
		return getCardNumbers(pattern, conversation);

	}

	private String findDiscover(String conversation)
	{
		Pattern pattern = Pattern.compile("\\b([6][0][1][1][0-9]{12}[,\\s\\.])|([6][5][0-9]{14}[,\\s\\.])");
		return getCardNumbers(pattern, conversation);

	}

	private String findAmex(String conversation)
	{
		Pattern pattern = Pattern.compile("\\b([3][4][0-9]{13}[,\\s\\.])|([3][7][0-9]{13}[,\\s\\.])");
		return getCardNumbers(pattern, conversation);

	}

	private String findVisa(String conversation)
	{
		Pattern pattern = Pattern.compile("\\b([4][0-9]{12}[,\\s\\.])|([4][0-9]{15}[,\\s\\.])");
		return getCardNumbers(pattern, conversation);
	}

	private String getCardNumbers(Pattern pattern, String conversation)
	{
		StringBuilder cardStr = new StringBuilder();
		int i = 0;
		Matcher matcher = pattern.matcher(conversation);
		while (matcher.find())
		{
			if (i > 0)
				cardStr.append(" ");
			cardStr.append(conversation.substring(matcher.start(), matcher.end() - 1));
			i++;
		}
		return cardStr.toString();
	}

	public static void main(String args[])
	{
		RegEx obj = new RegEx();
		String passage = "Manager : Good morning sir, How can i help for you? Customer : Sir, actually the card names in my cards got scratched by and i am unable to find their types. I am only having the card numbers. Manager : What are all the types of cards you are having sir. Customer : I am having visa cards, american express cards, Discover cards and JCB cards. Manager : Ok sir, can you tell me your account number and your mobile number. Customer : My account number is 1356798988878 and my mobile number is 8765465743. Manager : And now tell me the number of the cards sir. Customer : The card numbers are 4769856453217, 340987687654689, 213189796876789, 6011675489757876 and 3589797987979879. Manager : Please wait a minute sir. Customer : Sorry and i forget another number its 4654465765767878, 374567868809898 and 6589456879087568. Manager : Please give me a minute sir.";
		// String cardType="Visa";
		System.out.println(obj.findVisa(passage));

	}
}