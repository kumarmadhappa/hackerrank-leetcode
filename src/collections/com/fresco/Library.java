package collections.com.fresco;

import java.util.*;

class Library {

	String bookName;
	String author;

	Library()
	{
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.bookName);
		hash = 83 * hash + Objects.hashCode(this.author);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Library other = (Library) obj;
		if (!Objects.equals(this.bookName, other.bookName))
		{
			return false;
		}
		if (!Objects.equals(this.author, other.author))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Library [bookName=" + bookName + ", author=" + author + "]";
	}

	Library(String bookName, String author)
	{
		this.bookName = bookName;
		this.author = author;
	}

	public HashMap<Integer, Library> createLibraryMap(String booksInLibrary)
	{

		HashMap<Integer, Library> libMap = new HashMap<>();
		String[] books = booksInLibrary.split("\\|");
		for (int i = 0; i < books.length; i++)
		{
			String[] bookDet = books[i].split(",");
			Library bookLib = new Library(bookDet[1], bookDet[2]);
			libMap.put(Integer.parseInt(bookDet[0]), bookLib);
		}
		System.out.println("Library Map" + libMap.toString());

		return libMap;
	}

	public HashMap<Integer, Integer> createUserMap(String borrowedUsers)
	{

		HashMap<Integer, Integer> userMap = new HashMap<>();
		String[] borrowedUser = borrowedUsers.split("\\|");
		for (int i = 0; i < borrowedUser.length; i++)
		{
			String[] bookDet = borrowedUser[i].split(",");
			userMap.put(Integer.parseInt(bookDet[0]), Integer.parseInt(bookDet[1]));
		}
		System.out.println("User Map" + userMap.toString());

		return userMap;
	}

	public String getQuery(String booksInLibrary, String borrowedUsers, String query)
	{
		System.out.println("booksInLibrary=" + booksInLibrary);
		System.out.println("borrowedUsers=" + borrowedUsers);
		System.out.println("query=" + query);
		HashMap<Integer, Library> libMap = createLibraryMap(booksInLibrary);
		HashMap<Integer, Integer> userMap = createUserMap(borrowedUsers);

		String[] queryDet = query.split(",");

		String queryNo = queryDet[0];
		String searchString = queryDet[1];
		String result = null;
		switch (queryNo)
		{
			case "1":
				result = handleQuery1(searchString, libMap, userMap);
				break;
			case "2":
				result = handleQuery2(searchString, libMap, userMap);
				break;
			case "3":
				result = handleQuery3(searchString, libMap, userMap);
				break;
			case "4":
				result = handleQuery4(searchString, libMap, userMap);
				break;
			case "5":
				result = handleQuery5(searchString, libMap, userMap);
				break;
		}

		System.out.println("result=" + result);

		return result;
	}

	private String handleQuery5(String searchString, HashMap<Integer, Library> libMap,
			HashMap<Integer, Integer> userMap)
	{
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Library> lib : libMap.entrySet())
		{
			if (lib.getValue().bookName.toLowerCase().contains(searchString.toLowerCase()))
			{
				result.append(lib.getKey() + " " + lib.getValue().bookName + "\n");
			}

		}
		return result.toString();
	}

	private String handleQuery4(String searchString, HashMap<Integer, Library> libMap,
			HashMap<Integer, Integer> userMap)
	{
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Library> lib : libMap.entrySet())
		{
			if (lib.getValue().author.equals(searchString))
			{
				result.append(lib.getValue().bookName + "\n");
			}

		}
		return result.toString();
	}

	private String handleQuery3(String searchString, HashMap<Integer, Library> libMap,
			HashMap<Integer, Integer> userMap)
	{
		StringBuilder result = new StringBuilder();
		int out = 0;
		int in = 0;

		for (Map.Entry<Integer, Library> lib : libMap.entrySet())
		{
			if (lib.getValue().bookName.equals(searchString))
			{
				if (userMap.containsKey(lib.getKey()))
				{
					out++;
				}
				else
				{
					in++;
				}
			}
		}
		result.append(out + " out\n" + in + " in\n");

		return result.toString();
	}

	private String handleQuery2(String userId, HashMap<Integer, Library> libMap, HashMap<Integer, Integer> userMap)
	{
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Integer> user : userMap.entrySet())
		{
			if (user.getValue() == Integer.parseInt(userId))
			{
				Library l = libMap.get(user.getKey());
				result.append(user.getKey() + " " + l.bookName + "\n");
			}
		}

		return result.toString();
	}

	private String handleQuery1(String bookIdStr, HashMap<Integer, Library> libMap, HashMap<Integer, Integer> userMap)
	{
		String result = null;
		int bookId = Integer.parseInt(bookIdStr);
		if (userMap.containsKey(bookId))
		{
			result = "No Stock\nIt is owned by " + userMap.get(bookId) + "\n";
		}
		else if (libMap.containsKey(bookId))
		{

			result = "It is available\nAuthor is " + libMap.get(bookId).author + "\n";
		}

		return result;

	}

}
