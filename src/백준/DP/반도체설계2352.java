//문제 출처 : https://www.acmicpc.net/problem/2352
//제목 : 반도체설계2352

package 백준.DP;

import java.util.Scanner;

public class 반도체설계2352 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][]= new int[n+1][2];
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++){
			//현재 값을 포함하지않는 최대가지수 계산
			if(dp[i-1][0] < dp[i-1][1])		
				dp[i][0] = dp[i-1][1];
			else
				dp[i][0] = dp[i-1][0];
			for(int j = i-1; 0 <= j; j--){
				//현재값을 포함하는 최대가지수 계산
				if(arr[j] < arr[i]){
					if(dp[i][1] < dp[j][1] + 1)		
						dp[i][1] = dp[j][1] + 1;
				}
			}
		}
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}
