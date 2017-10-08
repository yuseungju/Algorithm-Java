//문제 출처 : https://www.acmicpc.net/problem/11049
//제목 : 행렬곱셈순서11049

package 백준.DP;

import java.util.Scanner;

public class 행렬곱셈순서11049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[][] = new long[n][2];
		long dp[][] = new long[n][n];
		for(int  i = 0; i < n; i++){
			arr[i][0] = sc.nextInt(); 
			arr[i][1] = sc.nextInt(); 
		}
		for(int len = 2; len <= n; len++){//구간 길이
			int end =   n -len;
			for(int partStart = 0; partStart <= end; partStart++){
				int partEnd = partStart + len - 1;
				for(int k = partStart; k < partStart + len -1; k++){
					dp[partStart][partEnd] =  
							min(dp[partStart][k] + dp[k+1][partEnd] + (arr[partStart][0] * arr[k][1] * arr[partEnd][1]), 
							dp[partStart][partEnd]);
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}
	public static long min(long num1, long num2){
		if(num1 == 0)
			return num2;
		else if(num2 == 0)
			return num1;
		else if(num1 < num2)
			return num1;
		else 
			return num2;
	}
}
