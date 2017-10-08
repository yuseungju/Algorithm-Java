//문제 출처 : https://www.acmicpc.net/problem/1695
//제목 : 팰린드롬만들기1695

package 백준.DP;

import java.util.Scanner;

public class 팰린드롬만들기1695 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp =  new int[n][n];
		for(int i =0; i <n; i++)
			arr[i] =  sc.nextInt();
		System.out.println(getMin(0,n-1));
		
	}
	
	public static int n;
	public static int arr[];
	public static int dp[][];
	public static int getMin(int s, int e){
		if(e <= s)
			return 0;
		int min = 0;
		if(arr[s] == arr[e]){
			if(dp[s+1][e-1] == 0)
				dp[s+1][e-1] = getMin(s + 1, e - 1);
			min = dp[s+1][e-1];
		}
		else{
			if(dp[s+1][e] == 0)
				dp[s+1][e] = getMin(s+1, e);
			if(dp[s][e-1] == 0)
				dp[s][e-1] = getMin(s, e-1);
			min = Integer.min(dp[s+1][e]  + 1, dp[s][e-1] + 1);
		}
		return min;
	}
}
