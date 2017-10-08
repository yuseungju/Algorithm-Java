//문제 출처 : https://www.acmicpc.net/problem/2302
//제목 : 극장판좌석2302

package 백준.DP;
import java.util.ArrayList;
import java.util.Scanner;

public class 극장판좌석2302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean arr[]= new boolean[n+1];
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++){
			int index = sc.nextInt();
			arr[index] = true;
		}
		
		int dp[][] = new int[n+1][2];//[][3] -> 0:앞에 1:원래자리
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int k = 2; k <=n; k++){
			if(arr[k]){//현재자리가 고정석이면
				dp[k][0] = 0;
				dp[k][1] = dp[k-1][1] +  dp[k-1][0];//원래자리에 수를 배치한 경우
			}else{
				if(!arr[k-1])//앞자리수가 고정석이 아닐경우에만(고정석이면 앞자리수가 뒤에오는 경우 x)
					dp[k][0] = dp[k-1][1];//앞자리에 수를 배치한경우 == 앞자리수를 뒤에 배치한경우
				dp[k][1] = dp[k-1][1] +  dp[k-1][0];//원래자리에 수를 배치한 경우
			}
		}
		System.out.println(dp[n][0] + dp[n][1]);
	}
}
