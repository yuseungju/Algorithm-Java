//���� ��ó : https://www.acmicpc.net/problem/11054
//���� : ����������кκм���11054

package ����.DP;
import java.util.Scanner;

public class ����������кκм���11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i ++)
			arr[i] =sc.nextInt();
		int dp[][] = new int[n+1][2];//0:���� /  1:����
		int result = 0;
		for(int k = 1; k <= n; k++){
			//���� ���� �����ϴ� �κ� �����ϴ� �κ��� �ִ밪 ���ϱ�
			int maxD = 0;
			int maxI = 0;
			for(int b = k-1; 1 <= b; b--){
				if(arr[k] < arr[b]){
					if(maxD < dp[b][0]){
						maxD = dp[b][0];
					}
				}
				if(arr[b] < arr[k]){
					if(maxI < dp[b][1]){
						maxI = dp[b][1];
					}
				}
			}
			dp[k][1] = maxI + 1;
			dp[k][0] = Integer.max(maxI, maxD) + 1;
		}
		for(int i = 0;  i <=n; i++){
			if(result < dp[i][0])
				result = dp[i][0];
		}
		System.out.println(result);
	}
}
