//���� ��ó : https://www.acmicpc.net/problem/2178
//���� : �̷�Ž��2178

package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class �̷�Ž��2178 {
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
				if( num == 1)//�̵������Ѱ���̸�
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
		public int visitNum = 0;//�湮�� ������ ��
		public int possiblePathNum = 0;//�̵� ������ ������ ��
		public int impossiblePathNum = 0;//�̵� �Ұ����� ������ ��
		public int deptLevel = 0;//���������� ��������� ����� �ʺ�Ž���� ����
		public int height,width;
		public Queue<Pos> que = new LinkedList<Pos>();
		Bfs2(int height, int width, int firstXY){
			this.height = height;
			this.width = width;
			this.firstXY= firstXY;
			arr2 = new int[height+firstXY][width+firstXY];
		}
		public void setArrPossible(int x, int y){
			arr2[y][x] = 1;//�̵���������
			possiblePathNum++;
		}
		public void setArrImpossible(int x, int y){
			arr2[y][x] = 0;//�̵��Ұ����
		}
		public void setStartPoint(int x, int y){
			que.add(new Pos(x ,y));
			arr2[y][x] = -1;//�̹� �̵���ο� �߰��Ȼ���
		}
		//������ġ�� �湮�Ұ��� ��ŷ, ����κ��� �̵������� ��ġ�� ť������
		public boolean searchAndMarking(){
			Pos pos = que.peek();
			que.remove();

			visitNum++;
			deptLevel = pos.myDept  + 1;
			if(pos.y == height-1 && pos.x==width-1)
				return false;
			
			if(firstXY < pos.x){
				if(arr2[pos.y][pos.x-1] == 1){//�̵������ϸ� �����̵���η� ����
					que.add(new Pos(pos.x -1, pos.y, deptLevel));
					arr2[pos.y][pos.x-1] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
				}
			}
			if(firstXY < pos.y){
				if(arr2[pos.y-1][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
					que.add(new Pos(pos.x, pos.y-1, deptLevel));
					arr2[pos.y-1][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
				}
			}
			if(pos.y < height-1){
				if(arr2[pos.y+1][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
					que.add(new Pos(pos.x, pos.y+1, deptLevel));
					arr2[pos.y+1][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
				}
			}
			if(pos.x < width-1){
				if(arr2[pos.y][pos.x+1] == 1){//�̵������ϸ� �����̵���η� ����
					que.add(new Pos(pos.x+ 1, pos.y, deptLevel));
					arr2[pos.y][pos.x+1] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
				}
			}
			return true;
		}
		public void processBfs(){
			while(searchAndMarking());
		}
	}
}
