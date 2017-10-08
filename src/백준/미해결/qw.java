package 백준.미해결;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class qw {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		String str[] = new String[n1];
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < n1; i ++)
			str[i] = sc.next();
		Arrays.sort(str);
		for(int i = 0; i < n2; i ++){
			String strItem = sc.next();
			if(binarySearch(str, strItem))
				list.add(strItem);
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	public static boolean binarySearch(String [] arr, String findNum){
		if(arr.length == 0)
			return false;
		if(arr[0].equals(findNum))
			return true;
		
		int f = 0; 
		int e = arr.length;
		int m = (f+e)/2;
		while(true){
			if(m == f)
				return false;
			if(arr[m].compareTo(findNum) < 0)
				f = m;
			else if(arr[m].compareTo(findNum) > 0)
				e = m;
			m = (f+e)/2;
			if(arr[m].equals(findNum))
				return true;
		}
	}
}
