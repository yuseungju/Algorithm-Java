//문제 출처 : https://www.acmicpc.net/problem/1938
//제목 : 통나무옮기기1938

package 백준.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 통나무옮기기1938 {
	static class Bfs2{
		public Pos resultPos;
		class Pos{
			public Pos(int x, int y, int myDept, int shape){
				this.x = x; //통나무 중심좌표
				this.y = y; //통나무 중심좌표
				this.shape = shape; //통나무 모양 가로 세로 여부
				this.myDept = myDept;
			}
			public Pos(int x, int y,int shape){
				this.x = x; 
				this.y = y;
				this.shape = shape;
				this.myDept = -1;
			}
			public int x;
			public int y;
			public int shape;
			public int myDept;
		}
		public int arr2[][][];
		public int visitNum = 0;//방문한 지점의 수
		public int possiblePathNum = 0;//이동 가능한 지점의 수
		public int impossiblePathNum = 0;//이동 불가능한 지점의 수
		public int deptLevel = 0;//병렬적으로 동시진행시 수행된 너비탐색의 깊이
		public int height,width;
		public Queue<Pos> que = new LinkedList<Pos>();
		Bfs2(int height, int width){
			this.height = height;
			this.width = width;
			arr2 = new int[height][width][2];
		}
		public void setArrPossible(int x, int y, int shape){
			arr2[y][x][shape] = 1;//이동가능지점
			possiblePathNum++;
		}
		public void setArrImpossible(int x, int y, int shape){
			arr2[y][x][shape] = 0;//이동불가경로
		}
		public void setStartPoint(int x, int y, int shape){
			que.add(new Pos(x ,y, shape));
			arr2[y][x][shape] = -1;//이미 이동경로에 추가된상태
		}
		//도착지점 설정
		public void setResultPoint(int x, int y, int shape){
			resultPos = new Pos(x, y , shape);
			if(shape == 0){
				arr2[y][x-1][0] = 1;//이미 이동경로에 추가된상태
				arr2[y][x][0] = 1;//이미 이동경로에 추가된상태
				arr2[y][x+1][0] = 1;//이미 이동경로에 추가된상태
				arr2[y][x-1][1] = 1;//이미 이동경로에 추가된상태
				arr2[y][x][1] = 1;//이미 이동경로에 추가된상태
				arr2[y][x+1][1] = 1;//이미 이동경로에 추가된상태
			}else if(shape == 1){
				arr2[y-1][x][0] = 1;//이미 이동경로에 추가된상태
				arr2[y][x][0] = 1;//이미 이동경로에 추가된상태
				arr2[y+1][x][0] = 1;//이미 이동경로에 추가된상태
				arr2[y-1][x][1] = 1;//이미 이동경로에 추가된상태
				arr2[y][x][1] = 1;//이미 이동경로에 추가된상태
				arr2[y+1][x][1] = 1;//이미 이동경로에 추가된상태
			}
		}
		//현재위치를 방문불가로 마킹, 현재로부터 이동가능한 위치를 큐에저장
		public boolean searchAndMarking(){
			//print();
			if(que.size() < 1){
				deptLevel = -1;
				return false;
			}
			Pos pos = que.peek();
			que.remove();
			deptLevel = pos.myDept  + 1;
			
			//도착지점이면 종료
			if(resultPos.x == pos.x && resultPos.y == pos.y && resultPos.shape == pos.shape){
				que.clear();
				return false;
			}
			
			//모든 가능성확인
			if(pos.shape == 0){//모양이 가로이면
				/*D 가로배치된 통나무를 아래로 한 칸 옮긴다..*/
				if(pos.y < height-1){
					if(arr2[pos.y+1][pos.x-1][pos.shape] != 0 &&  arr2[pos.y+1][pos.x][pos.shape] == 1 && arr2[pos.y+1][pos.x+1][pos.shape] != 0 ){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x, pos.y+1, deptLevel, pos.shape));
						arr2[pos.y+1][pos.x][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("가로로 아래");
					}
				}
				/*U 가로배치된 통나무를 위로 한 칸 옮긴다.*/
				if(0 < pos.y){
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 &&  arr2[pos.y-1][pos.x][pos.shape] == 1 && arr2[pos.y-1][pos.x+1][pos.shape] != 0 ){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x, pos.y-1, deptLevel, pos.shape));
						arr2[pos.y-1][pos.x][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("가로로 위");
					}
				}
				/*R 가로배치된 통나무를 오른쪽으로 한 칸 옮긴다.*/
				if(pos.x < width-2){
					if(arr2[pos.y][pos.x+2][pos.shape] == 1  && arr2[pos.y][pos.x+1][pos.shape] == 1){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x + 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x+1][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("가로로 오른쪽");
					}
				}
				/*R 가로배치된 통나무를 왼쪽으로 한 칸 옮긴다.*/
				if(1 < pos.x){
					if(arr2[pos.y][pos.x-2][pos.shape] != 0  && arr2[pos.y][pos.x-1][pos.shape] == 1){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x - 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x-1][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("가로로 왼쪽");
					}
				}
				/*T 가로배치된 통나무를 세로로*/
				if(0 < pos.y && pos.y< height-1){//위치변경시 높이를 좌표계에서 벗어나지않으면
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y-1][pos.x][pos.shape] != 0 && arr2[pos.y-1][pos.x+1][pos.shape] != 0 ){//통나무 바로위 세좌표가 이동가능하면
						if(arr2[pos.y+1][pos.x-1][pos.shape] != 0 && arr2[pos.y+1][pos.x][pos.shape] != 0 && arr2[pos.y+1][pos.x+1][pos.shape] != 0 ){//통나무 바로아래 세좌표가 이동가능하면		
							if(arr2[pos.y][pos.x][(pos.shape+1)%2] == 1){//위치변경이 가능하면
								que.add(new Pos(pos.x, pos.y, deptLevel, (pos.shape+1)%2));
								arr2[pos.y][pos.x][(pos.shape+1)%2] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
								//System.out.println("가로에서 세로");
							}
						}
					}
				}
				
			}else{//모양이 세로이면
				/*D 세로배치된 통나무를 아래로 한 칸 옮긴다..*/
				if(pos.y < height-2){
					if(arr2[pos.y+2][pos.x][pos.shape] != 0 && arr2[pos.y+1][pos.x][pos.shape] == 1){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x, pos.y+1, deptLevel, pos.shape));
						arr2[pos.y+1][pos.x][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("세로로 아래");
					}
				}
				/*U 세로배치된 통나무를 위로 한 칸 옮긴다.*/
				if(1 < pos.y){
					if(arr2[pos.y-2][pos.x][pos.shape] != 0  && arr2[pos.y-1][pos.x][pos.shape] == 1){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x, pos.y-1, deptLevel, pos.shape));
						arr2[pos.y-1][pos.x][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("세로로 위");
					}
				}
				/*R 세로배치된 통나무를 오른쪽으로 한 칸 옮긴다.*/
				if(pos.x < width-1){
					if(arr2[pos.y-1][pos.x+1][pos.shape] != 0 && arr2[pos.y][pos.x+1][pos.shape] == 1 && arr2[pos.y+1][pos.x+1][pos.shape] != 0){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x + 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x+1][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("세로로 오른쪽");
					}
				}
				/*R 세로배치된 통나무를 왼쪽으로 한 칸 옮긴다.*/
				if(0 < pos.x){
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y][pos.x-1][pos.shape] == 1 && arr2[pos.y+1][pos.x-1][pos.shape] != 0){//이동가능하면 다음이동경로로 저장
						que.add(new Pos(pos.x - 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x-1][pos.shape] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외
						//System.out.println("세로로 왼쪽");
					}
				}
				/*T 세로배치된 통나무를 가로로*/
				if(0 < pos.x && pos.x< height-1){//위치변경시 너비를 좌표계에서 벗어나지않으면
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y][pos.x-1][pos.shape] != 0 && arr2[pos.y+1][pos.x-1][pos.shape] != 0){//통나무 바로왼쪽 세좌표가 이동가능하면
						if(arr2[pos.y-1][pos.x+1][pos.shape] != 0 && arr2[pos.y][pos.x+1][pos.shape] != 0 && arr2[pos.y+1][pos.x+1][pos.shape] != 0){//통나무 바로오른쪽 세좌표가 이동가능하면		
							if(arr2[pos.y][pos.x][(pos.shape+1)%2] == 1){//위치변경이 가능하면
								arr2[pos.y][pos.x][(pos.shape+1)%2] = -1;//저장했으므로 해당위치는 저장할 대상에서 제외								
								que.add(new Pos(pos.x, pos.y, deptLevel, (pos.shape+1)%2));
								//System.out.println("세로에서 가로");
							}
						}
					}
				}
			}
			visitNum++;
			return true;
		}
		public void processBfs(boolean print){
			while(searchAndMarking());
		}
		public void print(){
			System.out.println("진행후 단계 :"+ deptLevel);
			System.out.println("진행후 까지 방문한 지점 수:"+ visitNum);
			String print[][] = new String[height][width];
			for(int y=0; y<height; y++){
				for(int x=0; x<width; x++){
					if(arr2[y][x][1] == 1 && arr2[y][x][0] == 1){//모두 이동가능한곳
						print[y][x] = "O ";
					}else if(arr2[y][x][1] != 1 && arr2[y][x][0] == 1){//가로로 이동가능한곳
						print[y][x] = "ㄱ ";
					}else if(arr2[y][x][1] == 1 && arr2[y][x][0] != 1){//세로로 이동가능한곳
						print[y][x] = "ㅅ ";
					}
					if(arr2[y][x][1] != 1 && arr2[y][x][0] != 1){//이동불가능한곳
						print[y][x] = "X ";
					}if(arr2[y][x][0] == -1 && arr2[y][x][1] == -1){//이미 모두 이동한곳
						print[y][x] = ". ";
					}else if(arr2[y][x][1] == 1 && arr2[y][x][0] == -1){//이미 가로로 이동한곳
						print[y][x] = "ㅅ ";
					}else if(arr2[y][x][1] == -1 && arr2[y][x][0] == 1){//이미 세로로 이동한곳
						print[y][x] = "ㄱ ";
					}
				}
			}
			int size = que.size();
			Pos pos;
			for(int a=0; a<size; a++){
				pos = que.peek();
				que.add(pos);
				que.remove();
				if(pos.shape == 0)
					print[pos.y][pos.x] = "㉠ ";
				else 
					print[pos.y][pos.x] = "㉦ ";
			}
			for(int y=0; y<height; y++){
				for(int x=0; x<width; x++)
					System.out.print(print[y][x]);
				System.out.println();
			}
			System.out.println();
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//입력
		int w = sc.nextInt();//너비
		int h = w;//높이
		Bfs2 bfs = new Bfs2(h,w);
		char n;
		String str = "";
		int startX[]= new int[3];
		int startY[]= new int[3];
		int endX[]= new int[3];
		int endY[]= new int[3];
		int startIt = 0;
		int endIt = 0;
		int CenterOfX = -1;
		int CenterOfY = -1;
		for(int a=0; a<h; a++){
			str = sc.next();
			for(int b=0; b<w; b++){
				n = str.charAt(b);
				if(n == 'B'){
					startX[startIt] = b;
					startY[startIt++] = a;
				}
				else if(n == 'E'){
					endX[endIt] = b;
					endY[endIt++] = a;
				}
				if(n == '0' || n == 'B'){
					bfs.setArrPossible(b, a, 0);//이동가능한곳
					bfs.setArrPossible(b, a, 1);//이동가능한곳
				}else{
					bfs.setArrImpossible(b, a, 0);//이동 불가능한곳
					bfs.setArrImpossible(b, a, 1);//이동 불가능한곳
				}
			}
		}
		
		//통나무의 시작 중심위치와 모양 을 정함
		CenterOfX = (startX[0] + startX[1] + startX[2])/3;
		CenterOfY = (startY[0] + startY[1] + startY[2])/3;
		if(CenterOfX == startX[0])
			bfs.setStartPoint(CenterOfX, CenterOfY , 1);//시작점으로 설정
		else 
			bfs.setStartPoint(CenterOfX, CenterOfY , 0);//시작점으로 설정

		//통나무의 목적 중심위치와 모양 을 정함
		CenterOfX = (endX[0] + endX[1] + endX[2])/3;
		CenterOfY = (endY[0] + endY[1] + endY[2])/3;
		if(CenterOfX == endX[0])
			bfs.setResultPoint(CenterOfX, CenterOfY , 1);//시작점으로 설정
		else 
			bfs.setResultPoint(CenterOfX, CenterOfY , 0);//시작점으로 설정
		
		//bfs처리
		bfs.processBfs(true);
		if(bfs.deptLevel == -1)
			System.out.println(0);
		else
			System.out.println(bfs.deptLevel);
		/*//결과 출력
		System.out.println("총 수행단계(진행이 멈춤):"+bfs.deptLevel);
		System.out.println("방문했던 좌표수:"+bfs.visitNum);
		System.out.println("방문가능한 좌표수:"+bfs.possiblePathNum);
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println("모든 지점을 방문하는 것이 불가능한 경우에 해당(이동 불가능한 곳으로 둘러쌓여있는경우)");*/
	}
}
