package ����.DP;

import java.util.Arrays;
import java.util.Scanner;

//���� ��ó : https://www.acmicpc.net/problem/1890
//���� : ����1890


public class ����1890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp = new long[n][n];
		dp[0][0] = 1;
		dfs(n-1,n-1);
		System.out.println(dp[n-1][n-1]);
	}
	public static long dp[][];
	public static int arr[][];
	public static int n;

	public static void print(int sd[][], int x,int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(y==i && x == j)
					System.out.print(sd[i][j] + "/");
				else
					System.out.print(sd[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static long dfs(int x, int y){
		long sum = 0;
		for(int i = 9; 0 < i; i--){
			if(0 <= x-i && arr[y][x-i] == i){
				if(dp[y][x-i] == 0)
					sum += dfs(x-i,y);
				else
					sum += dp[y][x-i];
			}
		}
		for(int i = 9; 0 < i; i--){
			if(0 <= y-i && arr[y-i][x] == i){
				if(dp[y-i][x] == 0 )
					sum += dfs(x,y-i);
				else
					sum += dp[y-i][x];
			}
		
		}
		dp[y][x] = sum;
		return sum;
	}
	
}
