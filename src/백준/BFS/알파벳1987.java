//���� ��ó : https://www.acmicpc.net/problem/1987
//���� : ���ĺ�1987

package ����.BFS;
import java.util.Scanner;

public class ���ĺ�1987 {
	static class Pos {
		public int x;
		public int y;
		public int dept;

		public Pos(int x, int y, int dept) {
			this.dept = dept;
			this.x = x;
			this.y = y;
		}
	}

	public static int height;
	public static int width;
	public static int arr[][];
	public static boolean alpha[]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();// ����
		width = sc.nextInt();// ����
		arr = new int[height + 1][width + 1];// [����][����]
		alpha = new boolean[26];// [����][����]
		for (int i = 1; i <= height; i++) {
			String str = sc.next();
			for (int j = 1; j <= width; j++)
				arr[i][j] = str.charAt(j - 1) - 65;
		}
		dfs(1, 1, 0);
		System.out.println(max);
	}
	public static int max =Integer.MIN_VALUE;
	public static void dfs(int x, int y, int dept){
		if(alpha[arr[y][x]]){
			if(max < dept)
				max = dept;
			return; 
		}
		//System.out.println(dept + " : " + x + ","  + y);
		alpha[arr[y][x]] = true;
		if(1 <= x-1)
			dfs(x-1, y, dept+1);
		if(x+1 <= width)
			dfs(x+1, y, dept+1);
		if(1 <= y-1)
			dfs(x, y-1, dept+1);
		if(y+1 <= height)
			dfs(x, y+1, dept+1);
		alpha[arr[y][x]] = false;
	}
	
}







