//문제 출처 : https://www.acmicpc.net/problem/7576
//제목 : 토마토7576

package 백준.BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Bfs2{
	class Pos{
		public Pos(int x, int y, int myDept){
			this.x = x; 
			this.y = y;
			this.myDept = myDept;
		}
		public Pos(int x, int y){
			this.x = x; 
			this.y = y;
			this.myDept = -1;
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
		if(que.size()  < 1)
			return false;
		Pos pos = que.peek();
		que.remove();
		deptLevel = pos.myDept  + 1;
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
		visitNum++;
		return true;
	}
	public void processBfs(){
		while(searchAndMarking());
	}
}

public class 토마토2차원7576 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int w = sc.nextInt();//너비
		int h = sc.nextInt();//높이
		Bfs2 bfs = new Bfs2(h,w,0);
		int n;
		for(int a=0; a<h; a++){
			for(int b=0; b<w; b++){
				n = sc.nextInt();
				if(n== 1){//사과가 익었으면
					bfs.setArrPossible(b, a);
					bfs.setStartPoint(b, a);
				}else if(n == 0)
					bfs.setArrPossible(b, a);
				else
					bfs.setArrImpossible(b, a);
				
			}
		}
		bfs.processBfs();
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println(-1);
		else 
			System.out.println(bfs.deptLevel);
	}
}








