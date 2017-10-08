package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소14502 {
	static class Pos{
		int x;
		int y;
		int dept;
		public Pos(int x, int y, int dept) {
			super();
			this.x = x;
			this.y = y;
			this.dept = dept;
		}
		@Override
		public String toString() {
			return x + ", y=" + y + "( dept: " + dept + ")";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt(); 
		int width = sc.nextInt();
		int arr[][] = new int[height][width];
		int pillarNum =  0;
		ArrayList<Pos> que =  new ArrayList<Pos>();
		for(int i = 0; i < height; i ++){
			for(int w = 0; w < width; w++){
				arr[i][w] = sc.nextInt();
				if(arr[i][w] == 1)
					pillarNum++;
				else if(arr[i][w] == 2)
					que.add(new Pos(w,i,0));
			}
		}
		int maxSafetyNum = 0;
		for(int i = 0; i < height; i ++){
			for(int w = 0; w < width; w++){
				for(int i1 = 0; i1 < height; i1 ++){
					for(int w1 = 0; w1 < width; w1++){
						if(i1*width + w1 <= i*width + w || arr[i1][w1] == 1|| arr[i][w] == 1)
							continue;
						
						for(int i2 = 0; i2 < height; i2 ++){
							for(int w2 = 0; w2 < width; w2++){
								if(i2*width + w2 <= i1*width + w1 || arr[i1][w1] == 1|| arr[i2][w2] == 1)
									continue;
								//새로운 벽을세워놓음
								arr[i][w] = 1;
								arr[i1][w1] = 1;
								arr[i2][w2] = 1;
								
								//하나의 경우에서 바이러스가 되는 영역의 수를 구함
								int birusNum = bfs(arr, que);
								//바이러스수를 제외한 안전한 영역의 최대값을 구함
								if(maxSafetyNum < height * width - pillarNum - birusNum - 3)
									maxSafetyNum = height * width - pillarNum - birusNum - 3;
								
								//세워놓은 벽을다시 제거
								arr[i][w] = 0;
								arr[i1][w1] = 0;
								arr[i2][w2] = 0;
							}
						}
					}
				}
			}
		}
		System.out.println(maxSafetyNum);
	}
	public static int bfs(int arr[][], ArrayList<Pos> start){
		Queue<Pos> que = new LinkedList<Pos>();
		
		boolean visit[][] = new boolean[arr.length][arr[0].length];
		for(int i= 0; i < start.size(); i++){
			visit[start.get(i).y][start.get(i).x] = true;
			que.add(start.get(i));
		}
		int birusNum = 0;
		while(!que.isEmpty()){
			Pos current =  que.peek();
			que.remove();
			int x = current.x;
			int y = current.y;
			int dept = current.dept;
			birusNum++;
			if(0 <= x-1 && !visit[y][x-1] && arr[y][x-1] == 0){
				visit[y][x-1] = true;
				que.add(new Pos(x-1, y , dept +1));
			}
			if(0 <= y-1 && !visit[y-1][x] && arr[y-1][x] == 0){
				visit[y-1][x] = true;
				que.add(new Pos(x, y-1 , dept +1));
			}
			if(x+1 < arr[0].length && !visit[y][x+1] && arr[y][x+1] == 0){
				visit[y][x+1] = true;
				que.add(new Pos(x+1, y , dept +1));
			}
			if(y+1 < arr.length && !visit[y+1][x] && arr[y+1][x] == 0){
				visit[y+1][x] = true;
				que.add(new Pos(x, y+1 , dept +1));
			}
		}
		return birusNum;
	}
}
