//문제 출처 : https://www.acmicpc.net/problem/11054
//제목 : 가장긴바이토닉부분수열11054

package 백준.DP;
import java.util.Scanner;

public class 가장긴바이토닉부분수열11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i ++)
			arr[i] =sc.nextInt();
		int dp[][] = new int[n+1][2];//0:감소 /  1:증가
		int result = 0;
		for(int k = 1; k <= n; k++){
			//이전 값중 감소하는 부분 증가하는 부분의 최대값 구하기
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
