package 백준.미해결;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class 사과나무 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int height = 101; 
		int width = 101;
		arr = new int[101][101];
		int treeSize = sc.nextInt();
		int num = sc.nextInt();
		for(int i = 0; i < treeSize;  i++)
			arr[sc.nextInt()][sc.nextInt()] = num;

		for(int i = 0; i < 5;  i++)
			//System.out.println(Arrays.toString(arr[i]));
		dfs(0,0,num, 0);
		System.out.println(max);
	}
	public static int arr[][];
	public static int max = 0;
	public static void dfs(int x, int y , int dept , int getNum) {
		if(dept == 0){
			if(max< getNum)
				max = getNum;
			return;
		}
		if(arr[y][x] != 0)
			getNum+= dept;
		if(0 <= x-1)
			dfs(x-1,y, dept-1, getNum);
		
		if(0 <= y-1)
			dfs(x,y-1, dept-1, getNum);
		
		if(y+1 <= 100)
			dfs(x,y+1, dept-1, getNum);
		
		if(x+1 <= 100)
			dfs(x+1,y, dept-1, getNum);
		
	}
}
