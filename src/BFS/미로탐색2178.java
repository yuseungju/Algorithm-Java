//문제 출처 : https://www.acmicpc.net/problem/2178
//제목 : 미로탐색2178

package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 미로탐색2178 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int h = sc.nextInt();
		int w = sc.nextInt();
		Bfs2 bfs = new Bfs2(h,w,0);
		String n;
		int num;
		for(int y = 0; y< h; y++){
			n = sc.next();
			for(int x = 0; x < n.length(); x++){
				 num = Integer.parseInt(n.charAt(x)+"");
				if( num == 1)//이동가능한경로이면
					bfs.setArrPossible(x, y);
				else
					bfs.setArrImpossible(x, y);
			}
		}
		bfs.setStartPoint(0, 0);
		bfs.processBfs();
		System.out.println(bfs.deptLevel);
	}
	
	private static class Bfs2{
		class Pos{
			public Pos(int x, int y, int myDept){
				this.x = x; 
				this.y = y;
				this.myDept = myDept;
			}
			public Pos(int x, int y){
				this.x = x; 
				this.y = y;
				this.myDept = 0;
			}
			public int x;
			public int y;
			public int myDept;
		}
		public int arr2[][];
		public int firstXY;
		public int visitNum = 0;//방문한 지점의 수
		public int possiblePathNum = 0;//이동 가능한 지점의 수
		public int impossiblePathNum = 0;//이동 불가능한 지점의 수
		public int deptLevel = 0;//병렬적으로 동시진행시 수행된 너비탐색의 깊이
		public int height,width;
		public Queue<Pos> que = new LinkedList<Pos>();
		Bfs2(int height, int width, int firstXY){
			this.height = height;
			this.width = width;
			this.firstXY= firstXY;
			arr2 = new int[height+firstXY][width+firstXY];
		}
		public void setArrPossible(int x, int y){
			arr2[y][x] = 1;//이동가능지점
			possiblePathNum++;
		}
		public void setArrImpossible(int x, int y){
			arr2[y][x] = 0;//이동불가경로
		}
		public void setStartPoint(int x, int y){
			que.add(new Pos(x ,y));
			arr2[y][x] = -1;//이미 이동경로에 추가된상태
		}
		//현재위치를 방문불가로 마킹, 현재로부터 이동가능한 위치를 큐에저장
		public boolean searchAndMarking(){
			Pos pos = que.peek();
			que.remove();

			visitNum++;
			deptLevel = pos.myDept  + 1;
			if(pos.y == height-1 && pos.x==width-1)
				return false;
			
			if(firstXY < pos.x){
				if(arr2[pos.y][pos.x-1] == 1){//이동가능하면 다음이동경로로 저장
					que.add(new Pos(pos.x -1, pos.y, deptLevel));
					arr2[pos.y][pos.x-1] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
				}
			}
			if(firstXY < pos.y){
				if(arr2[pos.y-1][pos.x] == 1){//이동가능하면 다음이동경로로 저장
					que.add(new Pos(pos.x, pos.y-1, deptLevel));
					arr2[pos.y-1][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
				}
			}
			if(pos.y < height-1){
				if(arr2[pos.y+1][pos.x] == 1){//이동가능하면 다음이동경로로 저장
					que.add(new Pos(pos.x, pos.y+1, deptLevel));
					arr2[pos.y+1][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
				}
			}
			if(pos.x < width-1){
				if(arr2[pos.y][pos.x+1] == 1){//이동가능하면 다음이동경로로 저장
					que.add(new Pos(pos.x+ 1, pos.y, deptLevel));
					arr2[pos.y][pos.x+1] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
				}
			}
			return true;
		}
		public void processBfs(){
			while(searchAndMarking());
		}
	}
}
