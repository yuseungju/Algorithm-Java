package 백준.미해결;

import java.util.Scanner;

public class 쉬운계단수M {
	public static Scanner sc = new Scanner(System.in);
	public static long dp[][];
	public static void main(String[] args) {
		int n  = sc.nextInt();
		dp = new long[n+1][10];
		
		dp[1][0] = 0; 
		for(int b=1; b<=9; b++)
			dp[1][b] = 1; 
		
		for(int a=2; a<=n; a++){
			dp[a][0] = dp[a-1][1];
			dp[a][9] = dp[a-1][8];
			for(int b=1; b<=8; b++)
				dp[a][b] = dp[a-1][b-1]%1000000000 + dp[a-1][b+1]%1000000000; 
		}
		long sum=0;
		for(int b=0; b<=9; b++){
			sum += dp[n][b];
			sum%=1000000000;
		}
		System.out.println(sum);
	}

}
