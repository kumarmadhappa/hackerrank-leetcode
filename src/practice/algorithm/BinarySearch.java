package practice.algorithm;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args)
	{
		BinarySearch b = new BinarySearch();
		int[] array = { 1, 4, 7, 8, 9, 5, 15 };
		int searchElement = 4;
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("Recursive Search:"+searchElement+" found at index:"+b.binarySearch(array, searchElement, 0, array.length - 1));
		System.out.println("Iterative Search:"+searchElement+" found at index:"+b.binarySearchIterative(array, searchElement));
	}

	public int binarySearch(int[] sortedArray, int search, int min, int max)
	{
		int res = -1;
		int mid = (min + max) / 2;
		if (max < min)
		{
			res = -1;
		}
		else
		{
			if (search < sortedArray[mid])
			{
				res = binarySearch(sortedArray, search, min, mid - 1);
			}
			else if (search > sortedArray[mid])
			{
				res = binarySearch(sortedArray, search, mid + 1, max);
			}
			else {
				res = mid;
			}
			
		}
		return res;
	}
	
	
	public boolean bianrySearchPrac(int[] sortedArray, int value,int min, int max) {
		
		if (max<min) {
			return false;
		}
		else {
			int mid=(min+max)/2;
			if (value>sortedArray[mid]) {
				return bianrySearchPrac(sortedArray,value,mid+1,max);
			}
			else if(value<sortedArray[mid]) {
				return bianrySearchPrac(sortedArray,value,min,mid-1);
			}
			else
				return true;
			
		}
		
	}
	
	public int binarySearchIterative(int[] sortedArray, int value) {
		
		int min=0;
		int max=sortedArray.length;
		int index = -1;
		while(max>min) {
			int mid=(min+max)/2;
			if(value>sortedArray[mid]) {
				min=mid+1;
			}
			else if (value<sortedArray[mid]) {
				max=mid-1;
			}
			else {
				index =mid;
				break;
			}
				
		}
		
		return index;
		
	}
}
