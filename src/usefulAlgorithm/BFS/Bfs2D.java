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
		if(que.size()  < 1)
			return false;
		Pos pos = que.peek();
		que.remove();
		deptLevel = pos.myDept  + 1;
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
		if(pos.y < height+firstXY-1){
			if(arr2[pos.y+1][pos.x] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x, pos.y+1, deptLevel));
				arr2[pos.y+1][pos.x] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
			}
		}
		if(pos.x < width+firstXY-1){
			if(arr2[pos.y][pos.x+1] == 1){//�̵������ϸ� �����̵���η� ����
				que.add(new Pos(pos.x+ 1, pos.y, deptLevel));
				arr2[pos.y][pos.x+1] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
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
		System.out.println("������ �ܰ� :"+ deptLevel);
		System.out.println("������ ���� �湮�� ���� ��:"+ visitNum);
		String print[][] = new String[height+firstXY][width+firstXY];
		for(int y=firstXY; y<height+firstXY; y++){
			for(int x=firstXY; x<width+firstXY; x++){
				if(arr2[y][x] == 1)//�̵������Ѱ�
					print[y][x] = "O ";
				if(arr2[y][x] == 0)//�̵��Ұ����Ѱ�
					print[y][x] = "X ";
				if(arr2[y][x] == -1)//�̹� �̵��Ѱ�
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
		int w = 6;//�ʺ�
		int h = 7;//����
		Bfs2 bfs = new Bfs2(h,w,1);
		int n;
		for(int a=1; a<h+1; a++){
			for(int b=1; b<w+1; b++){
				n = sc.nextInt();
				if(n== 1){//�ܰ躰�� �����Ҷ� ó�� �ܰ��� ��ǥ ����(��������)
					bfs.setArrPossible(b, a);//�������� �̵� �����Ѱ�
					bfs.setStartPoint(b, a);//���������� ����
				}else if(n == 0)
					bfs.setArrPossible(b, a);//�̵������Ѱ�
				else
					bfs.setArrImpossible(b, a);//�̵� �Ұ����Ѱ�
			}
		}
		bfs.processBfs(true);
		System.out.println("�� ����ܰ�(������ ����):"+bfs.deptLevel);
		System.out.println("�湮�ߴ� ������:"+bfs.visitNum);
		System.out.println("�湮������ ������:"+bfs.possiblePathNum);
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println("��� ������ �湮�ϴ� ���� �Ұ����� ��쿡 �ش�(�̵� �Ұ����� ������ �ѷ��׿��ִ°��)");
	}
}
