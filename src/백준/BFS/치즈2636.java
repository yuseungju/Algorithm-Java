//���� ��ó : https://www.acmicpc.net/problem/2636
//���� : ġ��2636

package ����.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ġ��2636 {
	//ġ�� ���� ��ġ
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
		//�Է�
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width =  sc.nextInt();
		board = new int[height][width];
		visit = new boolean[height][width];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++)
				board[y][x] = sc.nextInt();
		}
		
		//���� ����0,0 ���� ����
		Queue<Pos> start = new LinkedList<Pos>();
		start.add(new Pos(0,0));
		visit[0][0] = true;
		
		//���⿡ ������ ġ� �Ѱ㾿 bfs�� ����
		int time = 0;
		int count = 0;
		while(true){
			start = bfs(start);//���⿡ ������ �Ѱ��� ġ� ����
			if(start.size() == 0)
				break;
			count = start.size();//���ŵ� ġ���
			//print();
			time++;//�հ㾿 ������ �ð�
		}
		
		System.out.println(time);
		System.out.println(count);
	}
	//���� �ٱ��ʿ� �ִ� ������ġ�� �α� ġ� Ȯ���� ����
	public static Queue<Pos> bfs(Queue<Pos> curStart){
		Queue<Pos> nextStart = new LinkedList<Pos>();//������ ������ ������ġ�� ������
		while(!curStart.isEmpty()){
			Pos current =  curStart.peek();
			curStart.remove();
			int curX = current.x;
			int curY = current.y;
			if(0 <= curX -1){
				if(board[curY][curX-1] == 0 && !visit[curY][curX-1]){//�����̸鼭 üũ����������ġ�̸�
					visit[curY][curX-1] = true;//�湮üũ
					curStart.add(new Pos(curX-1,curY));
				}
				else if(board[curY][curX-1] != 0 && !visit[curY][curX-1]){//ġ���̸鼭 üũ����������ġ�̸�
					board[curY][curX-1] = 0;//ġ������ ����ε�
					visit[curY][curX-1] = true;//üũ�Ͽ� ���ŵ� ġ���ڸ���  ������ ��ġ�� Ž���������ϰ���
					nextStart.add(new Pos(curX-1,curY));//ġ��� �ٷ� ������ ������ ��ġ ����
				}
				
			}
			if(0 <= curY -1){
				if(board[curY-1][curX] == 0 && !visit[curY-1][curX]){//�����̸鼭 üũ����������ġ�̸�
					visit[curY-1][curX] = true;//�湮üũ
					curStart.add(new Pos(curX,curY-1));
				}else if(board[curY-1][curX] != 0 && !visit[curY-1][curX]){//ġ���̸鼭 üũ����������ġ�̸�
					board[curY-1][curX] = 0;//ġ������ ����ε�
					visit[curY-1][curX] = true;//üũ�Ͽ� ���ŵ� ġ���ڸ���  ������ ��ġ�� Ž���������ϰ���
					nextStart.add(new Pos(curX,curY-1));//ġ��� �ٷ� ������ ������ ��ġ ����
				}
			}
			if(curX +1 < width){
				if(board[curY][curX+1] == 0 && !visit[curY][curX+1]){//�����̸鼭 üũ����������ġ�̸�
					visit[curY][curX+1] = true;//�湮üũ
					curStart.add(new Pos(curX+1,curY));
				}else if(board[curY][curX+1] != 0 && !visit[curY][curX+1]){//ġ���̸鼭 üũ����������ġ�̸�
					board[curY][curX+1] = 0;//ġ������ ����ε�
					visit[curY][curX+1] = true;//üũ�Ͽ� ���ŵ� ġ���ڸ���  ������ ��ġ�� Ž���������ϰ���
					nextStart.add(new Pos(curX+1,curY));//ġ��� �ٷ� ������ ������ ��ġ ����
				}
				
			}
			if(curY +1 < height){
				if(board[curY+1][curX] == 0 && !visit[curY+1][curX]){//�����̸鼭 üũ����������ġ�̸�
					visit[curY+1][curX] = true;//�湮üũ
					curStart.add(new Pos(curX,curY+1));
				}else if(board[curY+1][curX] != 0 && !visit[curY+1][curX]){//ġ���̸鼭 üũ����������ġ�̸�
					board[curY+1][curX] = 0;//ġ������ ����ε�
					visit[curY+1][curX] = true;//üũ�Ͽ� ���ŵ� ġ���ڸ���  ������ ��ġ�� Ž���������ϰ���
					nextStart.add(new Pos(curX,curY+1));//ġ��� �ٷ� ������ ������ ��ġ ����
				}
			}
			//print();
		}
		return nextStart;
	}
	//ġ���� �Ѱ����� ������
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
