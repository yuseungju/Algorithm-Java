//문제 출처 : https://www.acmicpc.net/problem/1103
//제목 : 게임1103

package 백준.시뮬레이션;
import java.util.Arrays;
import java.util.Scanner;

public class 게임1103 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt() + 2;
		width =  sc.nextInt() + 2; 
		arr =  new int[height][width];
		visit = new boolean[height][width];
		partMax = new int[height][width];
		for (int y = 1; y < height - 1; y++) {
			String str = sc.next();
			for (int x = 1; x < width - 1; x++) 
				if(str.charAt(x-1) != 'H')
					arr[y][x] =Integer.parseInt(str.charAt(x-1) + "");
		}
		//for(int i = 0; i < height; i++){
		//	System.out.println(Arrays.toString(arr[i])); 
		//}
		partMax[1][1] = -1;
		dfs(1,1,0);
		System.out.println(max);
		
	}
	public static int height;
	public static int width;
	public static int arr[][];
	public static boolean visit[][];
	public static int partMax[][];
	public static int max = Integer.MIN_VALUE;
	public static void dfs(int x, int y, int dept){
		if(max == -1)//이미 루프가 존재하는 상황이라면
			return;
		
		//범위를 벗어나거나 공을 구멍에 빠뜨리면
		if(y <= 0 || x <= 0 || height-1 <= y || width-1 <= x || arr[y][x] == 0){
			if(max < dept)
				max = dept;
				return;
		}
		
		if(dept <= partMax[y][x])
			return;
		partMax[y][x] = dept;
		
		//루프가 생기면
		if(visit[y][x] == true){
			max = -1;
			return;
		}
		
		//루프가 없고 새로운 방문 지점으로 계속 탐색이 가능하면
		visit[y][x] = true;
		dfs(x + arr[y][x], y, dept+1);//오른쪽으로 이동
		dfs(x , y + arr[y][x], dept+1);//아래로 이동
		dfs(x , y - arr[y][x], dept+1);//위로 이동
		dfs(x - arr[y][x], y, dept+1);//왼쪽으로 이동
		visit[y][x] = false;
	}
}
