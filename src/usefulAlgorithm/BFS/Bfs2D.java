package usefulAlgorithm.BFS;
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
		if(pos.y < height+firstXY-1){
			if(arr2[pos.y+1][pos.x] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x, pos.y+1, deptLevel));
				arr2[pos.y+1][pos.x] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		if(pos.x < width+firstXY-1){
			if(arr2[pos.y][pos.x+1] == 1){//이동가능하면 다음이동경로로 저장
				que.add(new Pos(pos.x+ 1, pos.y, deptLevel));
				arr2[pos.y][pos.x+1] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
			}
		}
		visitNum++;
		return true;
	}
	public void processBfs(boolean print){
		int curDept = 0;
		while(searchAndMarking()){
			if(print && curDept != this.deptLevel){
				System.out.println("---------------------------------");
				curDept = this.deptLevel;
			}
			print();
		}
	}
	public void print(){
		System.out.println("진행후 단계 :"+ deptLevel);
		System.out.println("진행후 까지 방문한 지점 수:"+ visitNum);
		String print[][] = new String[height+firstXY][width+firstXY];
		for(int y=firstXY; y<height+firstXY; y++){
			for(int x=firstXY; x<width+firstXY; x++){
				if(arr2[y][x] == 1)//이동가능한곳
					print[y][x] = "O ";
				if(arr2[y][x] == 0)//이동불가능한곳
					print[y][x] = "X ";
				if(arr2[y][x] == -1)//이미 이동한곳
					print[y][x] = ". ";
			}
		}
		int size = que.size();
		Pos pos;
		for(int a=0; a<size; a++){
			pos = que.peek();
			que.add(pos);
			que.remove();
			print[pos.y][pos.x] = "a ";
		}
		for(int y=firstXY; y<height+firstXY; y++){
			for(int x=firstXY; x<width+firstXY; x++){
				System.out.print(print[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
public class Bfs2D {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int w = 6;//너비
		int h = 7;//높이
		Bfs2 bfs = new Bfs2(h,w,1);
		int n;
		for(int a=1; a<h+1; a++){
			for(int b=1; b<w+1; b++){
				n = sc.nextInt();
				if(n== 1){//단계별로 진행할때 처음 단계인 좌표 설정(시작지점)
					bfs.setArrPossible(b, a);//시작점은 이동 가능한곳
					bfs.setStartPoint(b, a);//시작점으로 설정
				}else if(n == 0)
					bfs.setArrPossible(b, a);//이동가능한곳
				else
					bfs.setArrImpossible(b, a);//이동 불가능한곳
			}
		}
		bfs.processBfs(true);
		System.out.println("총 수행단계(진행이 멈춤):"+bfs.deptLevel);
		System.out.println("방문했던 지점수:"+bfs.visitNum);
		System.out.println("방문가능한 지점수:"+bfs.possiblePathNum);
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println("모든 지점을 방문하는 것이 불가능한 경우에 해당(이동 불가능한 곳으로 둘러쌓여있는경우)");
	}
}
