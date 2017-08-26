//문제 출처 : https://www.acmicpc.net/problem/1261
//제목 : 알고스팟1261
//우선순위큐, BFS

package 백준.그래프;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 알고스팟1261 {
	public static class QuePath implements Comparable<QuePath>{
		int x;
		int y;
		int weight;
		public QuePath(int x,int y,int weight) {
			super();
			this.weight = weight;
			this.x = x;
			this.y = y;
		}
		@Override
	    public int compareTo(QuePath target) {
	        if (this.weight > target.weight) {
	            return 1;
	        } else if (this.weight < target.weight) {
	            return -1;
	        }
	        return 0;
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int board[][] = new int[height][width];
		int history[][] = new int[height][width];
		for(int i = 0; i < height; i++){
			String str = sc.next();
			for(int j = 0; j < width; j++)
				board[i][j] = Integer.parseInt(""+str.charAt(j));
		}

		PriorityQueue<QuePath> searchQue = new PriorityQueue<QuePath>();
		searchQue.add(new QuePath(0,0,0));
		
		while(0 < searchQue.size()){
			QuePath item = searchQue.peek();
			searchQue.remove();
			int x  = item.x;
			int y  = item.y;
			int w = item.weight;
			if(history[y][x] == 1)
				continue;
			history[y][x] = 1;
			if(x+1 == width && y+1 == height){
				System.out.println(w);
				break;
			}
			if(0 <= x-1){
				if(history[y][x-1] != 1)
					searchQue.add(new QuePath(x-1,y,w + board[y][x-1]));
			}
			if(x+1 < width){
				if(history[y][x+1] != 1)
				searchQue.add(new QuePath(x+1,y,w + board[y][x+1]));
			}
			if(0 <= y-1){
				if(history[y-1][x] != 1)
				searchQue.add(new QuePath(x,y-1,w + board[y-1][x]));
			}
			if(y+1 < height){
				if(history[y+1][x] != 1)
				searchQue.add(new QuePath(x,y+1,w+board[y+1][x]));
			}
		}
	}
}
