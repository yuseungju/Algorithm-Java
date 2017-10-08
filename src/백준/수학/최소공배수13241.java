package 백준.수학;

import java.util.Scanner;

import java.util.Scanner;

public class 최소공배수13241 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n1 = sc.nextInt();
		long n2 = sc.nextInt();
		long min = Long.min(n1, n2);
		long max = Long.max(n1, n2);
		

		while(true){
			if(min == 0){
				//System.out.println(max);
				break;
			}
			long mod = max % min;
			max = min;
			min = mod;
		}
		System.out.println((n1*n2)/max);
		
	}
}
