package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 카드2161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String str ="";
		for (int i = 1; i <= n; i++)
			list.add(i);
		while(1 < list.size()){
			//버린다
			str+= list.get(0) +" ";
			list.remove(0);
			
			//옮긴다
			list.add(list.get(0));
			list.remove(0);
		}
		str += list.get(0);
		System.out.println(str);
	}
}
