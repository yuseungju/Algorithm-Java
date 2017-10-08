package 백준.수학.순열;

import java.util.Scanner;

public class 모든순열10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		visit = new boolean[n+1];
		dfs(1,n,0,"");
	}
	public static boolean visit[];
	public static void dfs(int min, int max, int dept, String str){
		if(dept == max)
			System.out.println(str);
		for(int i = 1; i <= max; i++){
			if(!visit[i]){
				visit[i] = true;
				dfs(i, max , dept + 1, str + i + " ");
				visit[i] = false;
			}
		}
	}
}
