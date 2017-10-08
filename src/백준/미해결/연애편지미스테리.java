package 백준.미해결;

import java.util.Scanner;

public class 연애편지미스테리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =  sc.next();
		int start = 0;
		int end = str.length() -1;
		int result = 0;
		//연산시작
		while(start < end){
			result += Math.abs(str.charAt(end) - str.charAt(start));
			start++;
			end--;
		}
		System.out.println(result);
	}
}
