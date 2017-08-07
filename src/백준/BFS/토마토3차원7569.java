//���� ��ó : https://www.acmicpc.net/problem/7569
//���� : �丶��7569

package ����.BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		Pos(int x, int y, int z){
			this.x = x; 
			this.y = y;
			this.z = z;
			this.myDept = -1;
		}
	}
	int arr3[][][];
	int firstXY;
	public int visitNum = 0;//�湮�� ������ ��
	public int possiblePathNum = 0;//�̵� ������ ������ ��
	public int impossiblePathNum = 0;//�̵� �Ұ����� ������ ��
	public int deptLevel = 0;//���������� ��������� ����� �ʺ�Ž���� ����
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
		arr3[z][y][x] = 1;//�̵���������
		possiblePathNum++;
	}
	public void setArrImpossible(int x, int y, int z){
		arr3[z][y][x] = 0;//�̵��Ұ����
	}
	public void setStartPoint(int x, int y, int z){
		que.add(new Pos(x ,y, z));
		arr3[z][y][x] = -1;//�̹� �̵���ο� �߰��Ȼ���
	}
	//������ġ�� �湮�Ұ��� ��ŷ, ����κ��� �̵������� ��ġ�� ť������
	public boolean searchAndMarking(){
		if(que.size()  < 1)
			return false;
		Pos pos = que.peek();
		que.remove();
		deptLevel = pos.myDept  + 1;
		if(firstXY < pos.x){
			if(arr3[pos.z][pos.y][pos.x-1] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x-1, pos.y, pos.z, deptLevel));
				arr3[pos.z][pos.y][pos.x-1] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(firstXY < pos.y){
			if(arr3[pos.z][pos.y-1][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x, pos.y-1, pos.z, deptLevel));
				arr3[pos.z][pos.y-1][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(firstXY < pos.z){
			if(arr3[pos.z-1][pos.y][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x, pos.y, pos.z-1, deptLevel));
				arr3[pos.z-1][pos.y][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(pos.y < height+firstXY-1){
			if(arr3[pos.z][pos.y+1][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x, pos.y+1,  pos.z, deptLevel));
				arr3[pos.z][pos.y+1][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(pos.x < width+firstXY-1){
			if(arr3[pos.z][pos.y][pos.x+1] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x+ 1, pos.y, pos.z, deptLevel));
				arr3[pos.z][pos.y][pos.x+1] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(pos.z < dept+firstXY-1){
			if(arr3[pos.z+1][pos.y][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x, pos.y, pos.z +1, deptLevel));
				arr3[pos.z+1][pos.y][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		visitNum++;
		return true;
	}
	public void processBfs(){
		while(searchAndMarking());
	}
}
public class �丶��3����7569 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int w = sc.nextInt();//����
		int h = sc.nextInt();//����
		int d = sc.nextInt();//����
		Bfs3 bfs = new Bfs3(d,h,w,0);
		int n;
		for(int c=0; c<d; c++){
			for(int a=0; a<h; a++){
				for(int b=0; b<w; b++){
					n = sc.nextInt();
					if(n == 1){//����� �;�����
						bfs.setArrPossible(b, a, c);
						bfs.setStartPoint(b, a, c);
					}else if(n == 0)
						bfs.setArrPossible(b, a, c);
					else
						bfs.setArrImpossible(b, a, c);
				}
			}
		}
		bfs.processBfs();
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println(-1);
		else 
			System.out.println(bfs.deptLevel);
	}
}
