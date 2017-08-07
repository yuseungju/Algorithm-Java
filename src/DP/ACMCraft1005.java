//巩力 免贸 : https://www.acmicpc.net/problem/1005
//力格 : ACMCraft1005

package DP;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ACMCraft1005 {
	static int N,K;
	static int [][] rule = new int[1001][1001];
	static int [] building = new int[1001];
	static int [] dp = new int[1001];
	public static void main(String[] args) throws ParseException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result[] = new int[T];
		int resultIt = 0;
		for(int test = 0; test < T; test++){
			N = sc.nextInt();
			K = sc.nextInt();
			for(int i=1; i<=N; i++)
				building[i] = sc.nextInt();
			for(int a=1; a< 1001; a++){
				dp[a] = 0;
				for(int b=1; b< 1001; b++)
					rule[a][b]=0;
			}
			for(int i=1; i<=K; i++)
				rule[sc.nextInt()][sc.nextInt()] = 1;
			
			int w = sc.nextInt();
			setDp(w);
			result[resultIt++] = dp[w];
		}
		for(int test = 0; test < T; test++)
			System.out.println(result[test]);
	}
	public static void setDp(int dpIt){
		if(dp[dpIt] != 0)
			return;
		int max = 0;
		for(int i = 1; i <= N; i++){
			if(rule[i][dpIt] == 1){
				setDp(i);
				if(max < dp[i])
					max = dp[i];
			}
		}
		dp[dpIt] = max + building[dpIt];
	}
}
