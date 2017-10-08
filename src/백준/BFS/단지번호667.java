package 백준.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호667 {
	static class Pos{
		int x; 
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ") ";
		} 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i = 0; i < n ; i++){
			String str = sc.next();
			for(int  j = 0; j < n; j++)
				arr[i][j] = str.charAt(j)-48;
		}
		int labelNum = 1;
		ArrayList<Integer> cnt =  new ArrayList<Integer>();
		for(int y = 0; y < n; y++){
			for(int x = 0; x < n; x++){
				if(arr[y][x] != 1)
					continue;
				labelNum++;
				Queue<Pos> que =  new LinkedList<Pos>();
				que.add(new Pos(x,y));
				arr[y][x] = labelNum;
				int cntValue = 0;
				while(!que.isEmpty()){
					int curX = que.peek().x;
					int curY = que.peek().y;
					que.remove();
					cntValue++;
					if(0 <= curX-1 && arr[curY][curX-1] == 1){
						que.add(new Pos(curX-1, curY));
						arr[curY][curX-1] = labelNum;
					}
					if(0 <= curY-1 && arr[curY-1][curX] == 1){
						que.add(new Pos(curX, curY-1));
						arr[curY-1][curX] = labelNum;
					}
					if(curY+1 < n && arr[curY+1][curX] == 1){
						que.add(new Pos(curX, curY+1));
						arr[curY+1][curX] = labelNum;
					}
					if(curX+1 < n && arr[curY][curX+1] == 1){
						que.add(new Pos(curX+1, curY));
						arr[curY][curX+1] = labelNum;
					}
				}
				cnt.add(cntValue);
			}
		}

		System.out.println(labelNum -1);
		Collections.sort(cnt);
		for(int i = 0; i < cnt.size(); i++)
			System.out.println(cnt.get(i));
	}
}
