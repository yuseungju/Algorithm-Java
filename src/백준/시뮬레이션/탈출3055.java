//문제 출처 : https://www.acmicpc.net/problem/3055
//제목 : 탈출3055

package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 탈출3055 {
	static class Pos{
		int x;
		int y;
		char ch;
		int dept;
		public Pos(int x, int y, char ch, int dept) {
			super();
			this.x = x;
			this.y = y;
			this.ch = ch;
			this.dept = dept;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", ch=" + ch + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pos> start = new ArrayList<Pos>();
		int height = sc.nextInt();
		int width = sc.nextInt();
		boolean visit[][] = new boolean[height][width];
		char arr[][]= new char[height][width];
		for(int i = 0; i < height; i++){
			String str = sc.next();
			for(int j = 0; j < width; j++){
				arr[i][j] = str.charAt(j);
				//고슴도치의 시작점과 물의 시작점 추가
				if(arr[i][j] == 'S' )
					start.add(new Pos(j,i,arr[i][j],0));
				else if(arr[i][j] == '*')
					start.add(0,new Pos(j,i,arr[i][j],0));
				//방문 못하는 곳 표시
				if(arr[i][j] != '.')
					visit[i][j] = true;
			}
		}
		int result = -1;
		while(!start.isEmpty()){
			Pos cur = start.get(0);
			start.remove(0);
			if (0 <= cur.x - 1) {
				if(arr[cur.y][cur.x-1] == 'D'&& arr[cur.y][cur.x] == 'S'){
					result = cur.dept + 1;
					break;
				}
				if(!visit[cur.y][cur.x-1]){
					visit[cur.y][cur.x - 1] = true;
					arr[cur.y][cur.x - 1] =  cur.ch;
					start.add(new Pos(cur.x - 1, cur.y, cur.ch, cur.dept + 1));
				}
			}
			if (cur.x + 1 < width) {
				if(arr[cur.y][cur.x+1] == 'D'&& arr[cur.y][cur.x] == 'S'){
					result = cur.dept + 1;
					break;
				}
				if(!visit[cur.y][cur.x+1]){
					visit[cur.y][cur.x + 1] = true;
					arr[cur.y][cur.x + 1] =  cur.ch;
					start.add(new Pos(cur.x + 1, cur.y, cur.ch, cur.dept + 1));
				}
			}
			if (0 <= cur.y - 1) {
				if(arr[cur.y-1][cur.x] == 'D'&& arr[cur.y][cur.x] == 'S'){
					result = cur.dept + 1;
					break;
				}
				if(!visit[cur.y - 1][cur.x]){
					visit[cur.y - 1][cur.x] = true;
					arr[cur.y - 1][cur.x] =  cur.ch;
					start.add(new Pos(cur.x, cur.y - 1, cur.ch, cur.dept + 1));
				}
			}
			if (cur.y + 1 < height) {
				if(arr[cur.y+1][cur.x] == 'D' && arr[cur.y][cur.x] == 'S'){
					result = cur.dept + 1;
					break;
				}
				if(!visit[cur.y + 1][cur.x]){
					visit[cur.y + 1][cur.x] = true;
					arr[cur.y + 1][cur.x] =  cur.ch;
					start.add(new Pos(cur.x, cur.y + 1, cur.ch, cur.dept + 1));
				}
			}
		}
		if(result == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(result);
	}
}
