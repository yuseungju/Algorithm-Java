//巩力 免贸 : https://www.acmicpc.net/problem/2631
//力格 : 临技快扁2631

package 归霖.DP;
import java.util.Scanner;

public class 临技快扁2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[] =  new int[n];
		for(int i = 0; i < n;  i++)
			arr[i] = sc.nextInt();
		
		dp[0] = 1;
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < n; i++) {
			int  j;
			for(j = i-1; 0 <= j;  j--){
				if(arr[j] < arr[i]){
					if(dp[i] <  dp[j] + 1)
						dp[i] = dp[j] + 1;
				}
			}
			if(dp[i] <  1)
				dp[i] = 1;
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(n - max);
	}
}
