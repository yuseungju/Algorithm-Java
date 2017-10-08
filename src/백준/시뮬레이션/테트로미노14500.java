//문제 출처 : https://www.acmicpc.net/problem/14500
//제목 : 테트로미노14500

package 백준.시뮬레이션;
import java.util.Scanner;

public class 테트로미노14500 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		int arr[][] = new int[height][width];
		visit = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) 
				arr[i][j] = sc.nextInt();
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int value = DFS(arr, j, i, 0, 0);
				if(max < value)
					max = value;
			}
		}
		System.out.println(max);
	}
	public static boolean visit[][];
	static int max = Integer.MIN_VALUE;
	public static int DFS(int arr[][], int x, int y, int dept, int num){
		//System.out.println(x+","+y+":"+ num);
		int max = Integer.MIN_VALUE;
		int value;
		dept +=1;
		if(dept == 4)
			return arr[y][x];
		if(dept == 2){
			if(0 <= x-1 && !visit[y][x-1] && 0 <= y-1 && !visit[y-1][x]){
				value = arr[y][x-1] + arr[y-1][x];
				if(max < value)
					max = value;
			}
			if(x+1 < arr[0].length && !visit[y][x+1] && 0 <= y-1 && !visit[y-1][x]){
				value = arr[y][x+1] +  arr[y-1][x];
				if(max < value)
					max = value;
			}
			if(y+1 < arr.length && !visit[y+1][x] && 0 <= x-1 && !visit[y][x-1]){
				value = arr[y+1][x] +  arr[y][x-1];
				if(max < value)
					max = value;
			}
			if(y+1 < arr.length && !visit[y+1][x] && x+1 < arr[0].length && !visit[y][x+1]){
				value = arr[y+1][x] +  arr[y][x+1];
				if(max < value)
					max = value;
			}
		}
		visit[y][x] = true;
		if(0 <= x-1 && !visit[y][x-1]){
			value = DFS(arr, x-1, y, dept, num);
			if(max < value)
				max = value;
		}
		if(0 <= y-1 && !visit[y-1][x]){
			value = DFS(arr, x, y-1, dept, num);
			if(max < value)
				max = value;
		}
		if(y+1 < arr.length && !visit[y+1][x]){
			value = DFS(arr, x, y+1, dept, num);
			if(max < value)
				max = value;
		}
		if(x+1 < arr[0].length && !visit[y][x+1]){
			value = DFS(arr, x+1, y, dept, num);
			if(max < value)
				max = value;
		}
		visit[y][x] = false;
		return max + arr[y][x];
	}
	
}




