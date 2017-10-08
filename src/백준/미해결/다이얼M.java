package 백준.미해결;

import java.io.IOException;
import java.util.Scanner;

public class 다이얼M {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int num = 0;
		int decrease = 65;
		for(int a=0; a<str.length(); a++){
			if('S' <= str.charAt(a))
				decrease++;
			if('Z' <= str.charAt(a))
				decrease++;
			num += ((int)str.charAt(a)-decrease)/3+2+1;
			decrease = 65;
		}
		System.out.println(num);
	}
}
