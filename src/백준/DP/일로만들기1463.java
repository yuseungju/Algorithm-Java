//문제 출처 : https://www.acmicpc.net/problem/1463
//제목 : 일로만들기1463

package 백준.DP;
import java.util.Scanner;

public class 일로만들기1463 {
	public static int min(int n1, int n2, int n3) {
		int min = n1;
		if (n2 < min)
			min = n2;
		if (n3 < min)
			min = n3;
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dp[] = new int[1000001]; 
		int n = sc.nextInt();
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 3;

		int n3;
		int n2;
		int n1;
		for (int a = 6; a <= n; a++) {
			n3 = 9999999;
			n2 = 9999999;
			n1 = 9999999;
			if (a % 3 == 0)
				n3 = dp[a / 3];
			if (a % 2 == 0)
				n2 = dp[a / 2];
			n1 = dp[a - 1];
			dp[a] = min(n1, n2, n3) + 1;
		}
		System.out.println(dp[n]);
	}
}

/*
//c++코드
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int dp[1000001]; 
int n;
int cnt = 1000001;
void print() {
	for (int a = 1; a <= n; a++) {
		cout << a << ":" << dp[a];
		cout << endl;
	}
	cout << endl;
}
int min(int n1, int n2, int n3) {
	int min = n1;
	if (n2 < min)
		min = n2;
	if (n3 < min)
		min = n3;
	return min;
}
int main() {
	int n;
	cin >> n;
	dp[0] = 0;
	dp[1] = 0;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 3;


	int n3;
	int n2;
	int n1;
	for (int a = 6; a <= n; a++) {
		n3 = 9999999;
		n2 = 9999999;
		n1 = 9999999;
		if (a % 3 == 0)
			n3 = dp[a / 3];
		if (a % 2 == 0)
			n2 = dp[a / 2];
		n1 = dp[a - 1];
		dp[a] = min(n1, n2, n3) + 1;
	}
	cout  << dp[n] << endl;


} */