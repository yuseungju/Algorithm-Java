//문제 출처 : https://www.acmicpc.net/problem/2098
//제목 : 외판원순회2098

package 백준.DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 외판원순회2098 {
	public static ArrayList<Integer> path[];
	public static int pathValue[][];
	public static int dp[][];
	public static int visit[];
	public static int visitNum;
	public static int n;
	public static int resultMinExpense = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		pathValue = new int[n][n];
		visit= new int[n];
		dp =  new int[n][(int) Math.pow(2, n)];
		for(int a=0; a<n; a++){
			for(int b=0; b<(int) Math.pow(2, n); b++)
				dp[a][b] = -1;
		}
		for(int i = 0;  i < n; i++){
			for(int j = 0; j< n; j++)
				pathValue[i][j] = sc.nextInt();
		}    
		String set = "0";
		for(int a=0; a<n-1; a++)
			set += "1";
		System.out.println(getMin(0,set));//0번째에서 시작해서 3 를 지나 0으로 오는 최소비용 
	}
	public static int getMin(int start, String set){
		//System.out.println(start + " -> " +  set + " -> "  + 0);
		if(Integer.parseInt(set,2) == 0){
			dp[start][0] = pathValue[start][0];
			return  dp[start][0];
		}
		int min = Integer.MAX_VALUE;
		int val = 0;
		for(int a=0; a< set.length(); a++){
			if(pathValue[start][a] == 0)//경로가 존재하지않으면
				continue;
			if(set.charAt(a) =='1'){
				//System.out.println(set.substring(0, a) + "0"+ set.substring(a+1));
				if(dp[start][Integer.parseInt(set,2)] == -1)
					val  = getMin(a, set.substring(0, a) + "0"+ set.substring(a+1)) + pathValue[start][a];
				else
					val = dp[start][Integer.parseInt(set,2)];
				if(val < min && val != pathValue[start][a])
					min = val;
			}
		}
		if(min == Integer.MAX_VALUE)//경로가 전혀 존재하지않으면 
			min = 0;
		dp[start][Integer.parseInt(set,2)] = min;
		return min;
	}
}




