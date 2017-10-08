package 백준.미해결;

import java.util.ArrayList;
import java.util.Scanner;

public class 사과세트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int dp[] = new int[n+1];
		int expense[] = new int[n+1];
		for(int a = 1; a <= n;  a++)
			expense[a] = sc.nextInt();
		
		for(int i = 1; i <= n; i++){
			int max = 0;
			for(int e = 1; e <= n;  e++){
				if(0 <= i - e && max < dp[i- e] + expense[e])
					max = dp[i - e] + expense[e];
			}
			dp[i] =  max;
		}
		System.out.println(dp[n]);
	}
}
