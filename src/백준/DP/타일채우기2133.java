package 백준.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 타일채우기2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i = 0; i < n ; i++){
			for(int  j = 0; j < 3; j ++)
				arr[i][j] = sc.nextInt();
		}
		
		for(int i =0 ;i < n;i++)
			System.out.println(Arrays.toString(arr[i]));
		
		
		
	}
}
