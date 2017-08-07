//문제 출처 : https://www.acmicpc.net/problem/1932
//제목 : 숫자삼각형1932

package 백준.DP;
import java.util.Scanner;

public class 숫자삼각형1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n+1][n+1];
		int arr[][] = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int b = 0; b < i; b++) {
				arr[i][b] = sc.nextInt();
				dp[i][b] = arr[i][b];
			}
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
			for (int b = 1; b < i-1; b++) {
				dp[i][b] = Math.max(dp[i-1][b-1], dp[i-1][b]) + arr[i][b];
			}
			dp[i][i-1] = dp[i-1][i-2] + arr[i][i - 1];
		}
		int max = -1;
		for (int b = 0; b < n; b++){
			if (max < dp[n][b])
				max = dp[n][b];
		}
		System.out.println(max);
	}
}


/* c++코드
#include<iostream>
#include<algorithm>
using namespace std;
int** dp;
int main() {
	int n;
	cin >> n;
	dp = new int*[n];
	int** arr = new int*[n];
	for (int i = 1; i <= n; i++) {
		arr[i] = new int[i];
		dp[i] = new int[i];
		for (int b = 0; b < i; b++) {
			cin>> arr[i][b];
			dp[i][b] = arr[i][b];
		}
	}
	for (int i = 2; i <= n; i++) {
		dp[i][0] = dp[i-1][0] + arr[i][0];
		for (int b = 1; b < i-1; b++) {
			dp[i][b] = max(dp[i-1][b-1], dp[i-1][b]) + arr[i][b];
		}
		dp[i][i-1] = dp[i-1][i-2] + arr[i][i - 1];
	}
	int max = -1;
	for (int b = 0; b < n; b++){
		if (max < dp[n][b])
			max = dp[n][b];
	}
	cout << max<<endl;
	return 0;
}*/