//문제 출처 : https://www.acmicpc.net/problem/13460
//제목 : 째로탈출13460

package 백준.기타;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 째로탈출13460 {
	public static class Pos{
		int rx; 
		int ry;
		int bx; 
		int by;
		int dept;
		public Pos(int rx, int ry, int bx, int by, int dept) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.dept = dept;
		}
		@Override
		public String toString() {
			return "Pos [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by
					 + "]\n";
		}
		public void copy(Pos inPos){
			this.rx = inPos.rx;
			this.ry = inPos.ry;
			this.bx = inPos.bx;
			this.by = inPos.by;
			this.dept = inPos.dept;
		}
		public int getRx() {
			return rx;
		}
		public int getDept() {
			return dept;
		}
		public void setDept(int dept) {
			this.dept = dept;
		}
		public void setRx(int rx) {
			this.rx = rx;
		}
		public int getRy() {
			return ry;
		}
		public void setRy(int ry) {
			this.ry = ry;
		}
		public int getBx() {
			return bx;
		}
		public void setBx(int bx) {
			this.bx = bx;
		}
		public int getBy() {
			return by;
		}
		public void setBy(int by) {
			this.by = by;
		}
	}
	public static int height ;
	public static int width;
	public static char board[][];
	public static int visit[][][][];
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		board = new char[height][width];
		visit = new int[height][width][height][width];//[R의 y][R의 x] [B의 y][B의 x] 
		Queue<Pos> que = new LinkedList<Pos>();//BFS의 탐색값
		Pos temp = new Pos(0,0,0,0,0);
		for(int i = 0 ; i < height; i++){
			String str = sc.next();
			for(int j  = 0; j < width; j++){
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'R'){
					temp.setRx(j);
					temp.setRy(i);
				}else if(board[i][j] == 'B'){
					temp.setBx(j);
					temp.setBy(i);
				}
			}
		}
		que.add(temp);
		visit[temp.ry][temp.rx][temp.by][temp.bx] = 1;
		
		/*System.out.println(que);
		for(int i = 0 ; i < height; i++){
			for(int j  = 0; j < width; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}*/
		
		//BFS
		while(!que.isEmpty()){
			//System.out.println(que);
			Pos cur =  que.peek();
			cur.setDept(cur.getDept() + 1);
			que.remove();
			if(10 < cur.getDept())
				continue;
			
			Pos next;
			next = getMovePos('l', cur);
			if(next != null){
				if(next.bx == -1){
					System.out.println(cur.getDept());
					que.clear();
					return;
				}
				if(visit[next.ry][next.rx][next.by][next.bx] == 0){
					que.add(next);
					visit[next.ry][next.rx][next.by][next.bx] = 1;
				}
			}
			next = getMovePos('r', cur);
			if(next != null){
				if(next.bx == -1){
					System.out.println(cur.getDept());
					que.clear();
					return;
				}
				if(visit[next.ry][next.rx][next.by][next.bx] == 0){
					que.add(next);
					visit[next.ry][next.rx][next.by][next.bx] = 1;
				}
			}
			next = getMovePos('d', cur);
			if(next != null){
				if(next.bx == -1){
					System.out.println(cur.getDept());
					que.clear();
					return;
				}
				if(visit[next.ry][next.rx][next.by][next.bx] == 0){
					que.add(next);
					visit[next.ry][next.rx][next.by][next.bx] = 1;
				}
			}
			next = getMovePos('u', cur);
			if(next != null){
				if(next.bx == -1){
					System.out.println(cur.getDept());
					que.clear();
					return;
				}
				if(visit[next.ry][next.rx][next.by][next.bx] == 0){
					que.add(next);
					visit[next.ry][next.rx][next.by][next.bx] = 1;
				}
			}
		}
		System.out.println(-1);
	}
	public static Pos getMovePos(char point, Pos p){
		Pos next = new Pos(0,0,0,0,0);
		next.copy(p);
		boolean moveSuccess = true;
		boolean blueOut = false;
		boolean redOut = false;
		while(moveSuccess){
			moveSuccess = false;
			//구멍에 들어가는 경우체크
			if(board[next.by][next.bx] == 'O')
				blueOut = true;//파랑공이 빠지는 경우 유효x
			if(board[next.ry][next.rx] == 'O')
				redOut = true;//빨강공이 빠지면 정답
		
			//범위내에 속한좌표이면서 벽에 막히지않았으면 이동
			if(point == 'u'){
				if(0 <= next.by-1){
					if(board[next.by-1][next.bx] != '#' && !(next.by-1 == next.ry && next.bx == next.rx && !redOut)){
						next.by--;
						moveSuccess = true;
					}
				}
				if(0 <= next.ry-1){
					if(board[next.ry-1][next.rx] != '#' && !(next.by == next.ry-1 && next.bx == next.rx  && !blueOut)){
						next.ry--;
						moveSuccess = true;
					}
				}
			}else if(point == 'd'){
				if(next.by+1 < height){
					if(board[next.by+1][next.bx] != '#' && !(next.by+1 == next.ry && next.bx == next.rx  && !redOut)){
						next.by++;
						moveSuccess = true;
					}
				}
				if(next.ry+1 < height){
					if(board[next.ry+1][next.rx] != '#' && !(next.by == next.ry+1 && next.bx == next.rx  && !blueOut)){
						next.ry++;
						moveSuccess = true;
					}
				}
			}else if(point == 'r'){
				if(next.bx+1 < width){
					if(board[next.by][next.bx+1] != '#' && !(next.by == next.ry && next.bx+1 == next.rx  && !redOut)){
						next.bx++;
						moveSuccess = true;
					}
				}
				if(next.rx+1 < width){
					if(board[next.ry][next.rx+1] != '#'&& !(next.by == next.ry && next.bx == next.rx+1  && !blueOut)){
						next.rx++;
						moveSuccess = true;
					}
				}
			}else if(point == 'l'){
				if(0 <= next.bx-1){
					if(board[next.by][next.bx-1] != '#'&& !(next.by == next.ry && next.bx-1 == next.rx  && !redOut)){
						next.bx--;
						moveSuccess = true;
					}
				}
				if(0 <= next.rx-1){
					if(board[next.ry][next.rx-1] != '#'&& !(next.by == next.ry && next.bx == next.rx-1  && !blueOut)){
						next.rx--;
						moveSuccess = true;
					}
				}
			}
		}
		if(blueOut)
			return null;
		if(redOut)
			return new Pos(-1,-1,-1,-1,-1);
		return next;
	}
}



