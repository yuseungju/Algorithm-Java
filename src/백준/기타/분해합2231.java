package 백준.기타;

import java.util.Scanner;

public class 분해합2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		for(int i = 1; i <= 1000000; i++){
			String s = String.valueOf(i);
			int sum = i;
			for(int  j = 0; j < s.length(); j++)
				sum += Integer.parseInt(s.charAt(j) + "");
			if(N  == sum){
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
