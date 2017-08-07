package usefulAlgorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import usefulAlgorithm.BFS.Bfs2.Pos;

class Bfs3{
	class Pos{
		public int x;
		public int y;
		public int z;
		public int myDept;
		Pos(int x, int y, int z, int myDept){
			this.x = x;
			this.y = y;
			this.z = z;
			this.myDept = myDept;
		}
		public Pos(int x, int y, int z){
			this.x = x; 
			this.y = y;
			this.z = z;
			this.myDept = -1;
		}
	}
	int arr3[][][];
	int firstXY;
	public int visitNum = 0;//방문한 지점의 수
	public int possiblePathNum = 0;//이동 가능한 지점의 수
	public int impossiblePathNum = 0;//이동 불가능한 지점의 수
	public int deptLevel = 0;//병렬적으로 동시진행시 수행된 너비탐색의 깊이
	int height,width,dept;
	Queue<Pos> que = new LinkedList<Pos>();
	Bfs3(int dept, int height, int width, int firstXY){
		this.height = height;
		this.width = width;
		this.dept = dept;
		this.firstXY= firstXY;
		arr3 = new int[dept+firstXY][height+firstXY][width+firstXY];
	}
	public void setArrPossible(int x, int y, int z){
		arr3[z][y][x] = 1;//이동가능지점
		possiblePathNum++;
	}
	public void setArrImpossible(int x, int y, int z){
		arr3[z][y][x] = 0;//이동불가경로
	}
	public void setStartPoint(int x, int y, int z){
		que.add(new Pos(x ,y, z));
		arr3[z][y][x] = -1;//이미 이동경로에 추가된상태
	}
	//현재위치를 방문불가로 마킹, 현재로부터 이동가능한 위치를 큐에저장
	public boolean searchAndMarking(){
		if(que.size()  < 1)
			return false;
		Pos pos = que.peek();
		que.remove();
		deptLevel = pos.myDept  + 1;
		if(firstXY < pos.x){
			if(arr3[pos.z][pos.y][pos.x-1] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x-1, pos.y, pos.z, deptLevel));
				arr3[pos.z][pos.y][pos.x-1] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(firstXY < pos.y){
			if(arr3[pos.z][pos.y-1][pos.x] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x, pos.y-1, pos.z, deptLevel));
				arr3[pos.z][pos.y-1][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(firstXY < pos.z){
			if(arr3[pos.z-1][pos.y][pos.x] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x, pos.y, pos.z-1, deptLevel));
				arr3[pos.z-1][pos.y][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(pos.y < height+firstXY-1){
			if(arr3[pos.z][pos.y+1][pos.x] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x, pos.y+1,  pos.z, deptLevel));
				arr3[pos.z][pos.y+1][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(pos.x < width+firstXY-1){
			if(arr3[pos.z][pos.y][pos.x+1] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x+ 1, pos.y, pos.z, deptLevel));
				arr3[pos.z][pos.y][pos.x+1] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(pos.z < dept+firstXY-1){
			if(arr3[pos.z+1][pos.y][pos.x] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x, pos.y, pos.z +1, deptLevel));
				arr3[pos.z+1][pos.y][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		visitNum++;
		return true;
	}
	public void processBfs(){
		while(searchAndMarking());
	}
}
public class Bfs3D {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int w = 6;//가로
		int h = 7;//세로
		int d = 1;//높이
		Bfs3 bfs = new Bfs3(d, h,w,1);
		int n;
		for(int c=1; c<d+1; c++){
			for(int a=1; a<h+1; a++){
				for(int b=1; b<w+1; b++){
					n = sc.nextInt();
					if(n== 1){//단계별로 진행할때 처음 단계인 좌표 설정(시작지점)
						bfs.setArrPossible(b, a, d);//시작점은 이동 가능한곳
						bfs.setStartPoint(b, a, d);//시작점으로 설정
					}else if(n == 0)
						bfs.setArrPossible(b, a, d);//이동가능한곳
					else
						bfs.setArrImpossible(b, a, d);//이동 불가능한곳
				}
			}
		}
		bfs.processBfs();
		System.out.println("총 수행단계(진행이 멈춤):"+bfs.deptLevel);
		System.out.println("방문했던 지점수:"+bfs.visitNum);
		System.out.println("방문가능한 지점수:"+bfs.possiblePathNum);
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println("모든 지점을 방문하는 것이 불가능한 경우에 해당(이동 불가능한 곳으로 둘러쌓여있는경우)");
	}
}
