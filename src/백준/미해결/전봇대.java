package 백준.미해결;

import java.util.ArrayList;
import java.util.Scanner;

public class 전봇대 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> difference = new ArrayList<Integer>();
		int  minWidth = Integer.MAX_VALUE;
		int  maxWidth = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			list.add(sc.nextInt());
			if (i != 0){
				difference.add(list.get(i) - list.get(i-1));
				if(difference.get(difference.size() - 1) < minWidth)
					minWidth = difference.get(difference.size() - 1);
				if(maxWidth < difference.get(difference.size() - 1))
					maxWidth = difference.get(difference.size() - 1);
			}
		}
		
		int resultDiv = minWidth;
		for(resultDiv = maxWidth; 1 <= resultDiv; resultDiv--){
			boolean allDiv = true;
			for(int i = 0; i < difference.size(); i++){
				if(difference.get(i)%resultDiv != 0)
					allDiv = false;
			}
			if(allDiv)
				break;
		}
		minWidth = resultDiv;
		int width = list.get(list.size() -1) - list.get(0);
		System.out.println((width)/minWidth+1 - n);
		
	}
}
