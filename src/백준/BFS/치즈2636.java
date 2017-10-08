//문제 출처 : https://www.acmicpc.net/problem/2636
//제목 : 치즈2636

package 백준.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈2636 {
	//치즈 판의 위치
	public static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static int board[][];
	public static boolean visit[][];
	public static int height;
	public static int width;
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width =  sc.nextInt();
		board = new int[height][width];
		visit = new boolean[height][width];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++)
				board[y][x] = sc.nextInt();
		}
		
		//조사 지점0,0 부터 시작
		Queue<Pos> start = new LinkedList<Pos>();
		start.add(new Pos(0,0));
		visit[0][0] = true;
		
		//공기에 인접한 치즈를 한겹씩 bfs로 제거
		int time = 0;
		int count = 0;
		while(true){
			start = bfs(start);//공기에 인접한 한겹의 치즈를 제거
			if(start.size() == 0)
				break;
			count = start.size();//제거된 치즈수
			//print();
			time++;//합겹씩 제거한 시간
		}
		
		System.out.println(time);
		System.out.println(count);
	}
	//가장 바깥쪽에 있는 공기위치로 인근 치즈를 확인후 제거
	public static Queue<Pos> bfs(Queue<Pos> curStart){
		Queue<Pos> nextStart = new LinkedList<Pos>();//다음에 조사할 기준위치를 보관함
		while(!curStart.isEmpty()){
			Pos current =  curStart.peek();
			curStart.remove();
			int curX = current.x;
			int curY = current.y;
			if(0 <= curX -1){
				if(board[curY][curX-1] == 0 && !visit[curY][curX-1]){//공기이면서 체크하지못한위치이면
					visit[curY][curX-1] = true;//방문체크
					curStart.add(new Pos(curX-1,curY));
				}
				else if(board[curY][curX-1] != 0 && !visit[curY][curX-1]){//치즈이면서 체크하지못한위치이면
					board[curY][curX-1] = 0;//치즈제거 공기로둠
					visit[curY][curX-1] = true;//체크하여 제거된 치즈자리를  공기의 위치로 탐색하지못하게함
					nextStart.add(new Pos(curX-1,curY));//치즈와 바로 인접한 공기의 위치 보관
				}
				
			}
			if(0 <= curY -1){
				if(board[curY-1][curX] == 0 && !visit[curY-1][curX]){//공기이면서 체크하지못한위치이면
					visit[curY-1][curX] = true;//방문체크
					curStart.add(new Pos(curX,curY-1));
				}else if(board[curY-1][curX] != 0 && !visit[curY-1][curX]){//치즈이면서 체크하지못한위치이면
					board[curY-1][curX] = 0;//치즈제거 공기로둠
					visit[curY-1][curX] = true;//체크하여 제거된 치즈자리를  공기의 위치로 탐색하지못하게함
					nextStart.add(new Pos(curX,curY-1));//치즈와 바로 인접한 공기의 위치 보관
				}
			}
			if(curX +1 < width){
				if(board[curY][curX+1] == 0 && !visit[curY][curX+1]){//공기이면서 체크하지못한위치이면
					visit[curY][curX+1] = true;//방문체크
					curStart.add(new Pos(curX+1,curY));
				}else if(board[curY][curX+1] != 0 && !visit[curY][curX+1]){//치즈이면서 체크하지못한위치이면
					board[curY][curX+1] = 0;//치즈제거 공기로둠
					visit[curY][curX+1] = true;//체크하여 제거된 치즈자리를  공기의 위치로 탐색하지못하게함
					nextStart.add(new Pos(curX+1,curY));//치즈와 바로 인접한 공기의 위치 보관
				}
				
			}
			if(curY +1 < height){
				if(board[curY+1][curX] == 0 && !visit[curY+1][curX]){//공기이면서 체크하지못한위치이면
					visit[curY+1][curX] = true;//방문체크
					curStart.add(new Pos(curX,curY+1));
				}else if(board[curY+1][curX] != 0 && !visit[curY+1][curX]){//치즈이면서 체크하지못한위치이면
					board[curY+1][curX] = 0;//치즈제거 공기로둠
					visit[curY+1][curX] = true;//체크하여 제거된 치즈자리를  공기의 위치로 탐색하지못하게함
					nextStart.add(new Pos(curX,curY+1));//치즈와 바로 인접한 공기의 위치 보관
				}
			}
			//print();
		}
		return nextStart;
	}
	//치즈의 총개수를 가져옴
	public static int getCheeseCount(){
		int cheeseCount = 0;
		for(int  i =0 ; i < board.length;  i++){
			for(int j =0; j < board[i].length; j++){
				if(board[i][j] == 1)
					cheeseCount++;
			}
		}
		return cheeseCount;
	}
	public static void print(){
		for(int  i =0 ; i < board.length;  i++){
			for(int j =0; j < board[i].length; j++){
				if(visit[i][j])
					System.out.print("v ");
				else
					System.out.print(board[i][j] + " ");
			}System.out.println();
		}
		System.out.println();
	}
}
