//문제 출처 : https://www.acmicpc.net/problem/2579
//제목 : 계단오르기2579

package DP;
import java.util.Scanner;

public class 계단오르기2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long dp[][] =  new long[301][2]; //[][0] : 한번 밟은 상태의 최대값/ [][1] : 두번째로 밟은 상태의 최대값
		long arr[] = new long[301];
		int n = sc.nextInt();
		for (int a = 1; a <= n; a++) 
			arr[a] =  sc.nextInt();
		
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = arr[1];
		dp[1][1] = arr[1];

		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + arr[i];
			dp[i][1] = dp[i-1][0] + arr[i];
		}
		System.out.println( Math.max(dp[n][0], dp[n][1]));
	}
}


/*
//c++코드
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
long dp[301][2]; //[][0] : 한번 밟은 상태의 최대값/ [][1] : 두번째로 밟은 상태의 최대값
long arr[301];
int n;
void print() {
	for (int a = 1; a <= n; a++) {
		cout << a << ":" << dp[a][0] << "/ " << dp[a][1] << " ) ";
		cout << endl;
	}
	cout << endl;
}
int main() {
	cin >> n;
	for (int a = 1; a <= n; a++) 
		cin>>arr[a];
	
	dp[0][0] = 0;
	dp[0][1] = 0;
	dp[1][0] = arr[1];
	dp[1][1] = arr[1];

	for (int i = 2; i <= n; i++) {
		dp[i][0] = max(dp[i-2][0], dp[i-2][1]) + arr[i];
		dp[i][1] = dp[i-1][0] + arr[i];
	}

	cout << max(dp[n][0], dp[n][1] )<< endl;
} */