package 백준.DP;

import java.util.Scanner;

public class 이친수2193 {
	public static void main(String[] args) {
		int n = (new Scanner(System.in)).nextInt();
		long dp[][] = new long[n+1][2];// 0: 0으로 끝나는 이친수의 개수  // 1: 1로 끝나는 이친수의 개수
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++){
			dp[i][1] = dp[i-1][0];
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
		}
		System.out.println(dp[n][0] + dp[n][1]);
	}
}
