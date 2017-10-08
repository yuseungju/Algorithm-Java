//巩力 免贸 : https://www.acmicpc.net/problem/2309
//力格 : 老蚌抄里捞2309


package 归霖.DFS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class 老蚌抄里捞2309 {
	public static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i = 0; i < 9; i++)
			arr[i] = sc.nextInt();
		dfs(0, 0);
		Collections.sort(result);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
	public static boolean visit[] = new boolean[9];
	public static ArrayList<Integer> result  = new ArrayList<Integer>();
	public static int dfs(int sum, int dept){
		if(100 < sum)
			return -1; 
		if(dept == 7 && sum == 100)
			return 0;
		if(dept == 7 && sum != 100)
			return -1;
		for(int i = 0; i <  9; i++){
			if(visit[i])
				continue;
			visit[i] = true;
			if(dfs(sum + arr[i], dept+1) != -1){
				result.add(arr[i]);
				return arr[i];
			}
			visit[i] = false;
		}
		return -1;
	}
}
