//문제 출처 : https://www.acmicpc.net/problem/9084
//제목 : 동전9084

package 백준.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class 동전9084 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
			for(int  test = 0; test < t; test++){
			int n = sc.nextInt();
			ArrayList<Integer> coin = new ArrayList<Integer>();
			for(int i = 0; i < n; i++)
				coin.add(sc.nextInt());
			int result = sc.nextInt();
			int dp[] = new int[result+1];
			dp[0] = 1;
			for(int i = 0; i <  coin.size(); i++){
				for(int j = coin.get(i); j <= result; j ++)
					dp[j] += dp[j - coin.get(i)];
			}
			System.out.println(dp[result]);
		}
	}
}
