package ����.DP;

import java.util.Scanner;

public class ��ģ��2193 {
	public static void main(String[] args) {
		int n = (new Scanner(System.in)).nextInt();
		long dp[][] = new long[n+1][2];// 0: 0���� ������ ��ģ���� ����  // 1: 1�� ������ ��ģ���� ����
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++){
			dp[i][1] = dp[i-1][0];
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
		}
		System.out.println(dp[n][0] + dp[n][1]);
	}
}
