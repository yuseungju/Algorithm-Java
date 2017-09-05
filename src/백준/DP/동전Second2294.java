//���� ��ó : https://www.acmicpc.net/problem/2294
//���� : ����Second2294

package ����.DP;
import java.util.Arrays;
import java.util.Scanner;

public class ����Second2294 {
	public static Scanner sc = new Scanner(System.in);
	public static long dp[];
	public static void main(String[] args) {
		int n  = sc.nextInt();
		int k  = sc.nextInt();
		int dp[]= new int[k+1];//�������Ƚ���� �ּҰ�
		int coin[] = new int[n];
		for(int a=0; a<n; a++)
			coin[a] = sc.nextInt();
		Arrays.sort(coin);
		for(int i = 1; i <= k; i++){
			dp[i] = Integer.MAX_VALUE;
			for(int c = 0; c < n; c++){
				if(0 <= i - coin[c]){
					if(dp[i - coin[c]] < dp[i]){
						dp[i] = dp[i - coin[c]] + 1;
					}
				}
			}
		}
		if(dp[k] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}







