//문제 출처 : https://www.acmicpc.net/problem/9465
//제목 : 스티커9465

package 백준.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 스티커9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			int height = 2;
			int width = sc.nextInt();
			int arr[][] = new int[height][width];
			int dp[][] = new int[3][width];//0 위선택/ 1 아래선택/2선택없음
			for (int i = 0; i < height; i++){
				for (int j = 0; j < width; j++)
					arr[i][j] = sc.nextInt();
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[2][0] = 0;
			for(int k = 1; k < width; k++){
				dp[0][k] = Integer.max(dp[1][k-1] + arr[0][k],   dp[2][k-1] + arr[0][k]);
				dp[1][k] = Integer.max(dp[0][k-1] + arr[1][k],   dp[2][k-1] + arr[1][k]);
				dp[2][k] = Integer.max(dp[0][k-1], Integer.max(dp[1][k-1], dp[2][k-1]));
			}
			System.out.println(Integer.max(dp[1][width-1],Integer.max(dp[2][width-1], dp[0][width-1])));
		}
	}
}
