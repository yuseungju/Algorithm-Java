//���� ��ó : https://www.acmicpc.net/problem/1938
//���� : �볪���ű��1938

package ����.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �볪���ű��1938 {
	static class Bfs2{
		public Pos resultPos;
		class Pos{
			public Pos(int x, int y, int myDept, int shape){
				this.x = x; //�볪�� �߽���ǥ
				this.y = y; //�볪�� �߽���ǥ
				this.shape = shape; //�볪�� ��� ���� ���� ����
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
		public int visitNum = 0;//�湮�� ������ ��
		public int possiblePathNum = 0;//�̵� ������ ������ ��
		public int impossiblePathNum = 0;//�̵� �Ұ����� ������ ��
		public int deptLevel = 0;//���������� ��������� ����� �ʺ�Ž���� ����
		public int height,width;
		public Queue<Pos> que = new LinkedList<Pos>();
		Bfs2(int height, int width){
			this.height = height;
			this.width = width;
			arr2 = new int[height][width][2];
		}
		public void setArrPossible(int x, int y, int shape){
			arr2[y][x][shape] = 1;//�̵���������
			possiblePathNum++;
		}
		public void setArrImpossible(int x, int y, int shape){
			arr2[y][x][shape] = 0;//�̵��Ұ����
		}
		public void setStartPoint(int x, int y, int shape){
			que.add(new Pos(x ,y, shape));
			arr2[y][x][shape] = -1;//�̹� �̵���ο� �߰��Ȼ���
		}
		//�������� ����
		public void setResultPoint(int x, int y, int shape){
			resultPos = new Pos(x, y , shape);
			if(shape == 0){
				arr2[y][x-1][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x+1][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x-1][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x+1][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
			}else if(shape == 1){
				arr2[y-1][x][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y+1][x][0] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y-1][x][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y][x][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
				arr2[y+1][x][1] = 1;//�̹� �̵���ο� �߰��Ȼ���
			}
		}
		//������ġ�� �湮�Ұ��� ��ŷ, ����κ��� �̵������� ��ġ�� ť������
		public boolean searchAndMarking(){
			//print();
			if(que.size() < 1){
				deptLevel = -1;
				return false;
			}
			Pos pos = que.peek();
			que.remove();
			deptLevel = pos.myDept  + 1;
			
			//���������̸� ����
			if(resultPos.x == pos.x && resultPos.y == pos.y && resultPos.shape == pos.shape){
				que.clear();
				return false;
			}
			
			//��� ���ɼ�Ȯ��
			if(pos.shape == 0){//����� �����̸�
				/*D ���ι�ġ�� �볪���� �Ʒ��� �� ĭ �ű��..*/
				if(pos.y < height-1){
					if(arr2[pos.y+1][pos.x-1][pos.shape] != 0 &&  arr2[pos.y+1][pos.x][pos.shape] == 1 && arr2[pos.y+1][pos.x+1][pos.shape] != 0 ){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x, pos.y+1, deptLevel, pos.shape));
						arr2[pos.y+1][pos.x][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� �Ʒ�");
					}
				}
				/*U ���ι�ġ�� �볪���� ���� �� ĭ �ű��.*/
				if(0 < pos.y){
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 &&  arr2[pos.y-1][pos.x][pos.shape] == 1 && arr2[pos.y-1][pos.x+1][pos.shape] != 0 ){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x, pos.y-1, deptLevel, pos.shape));
						arr2[pos.y-1][pos.x][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ��");
					}
				}
				/*R ���ι�ġ�� �볪���� ���������� �� ĭ �ű��.*/
				if(pos.x < width-2){
					if(arr2[pos.y][pos.x+2][pos.shape] == 1  && arr2[pos.y][pos.x+1][pos.shape] == 1){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x + 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x+1][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ������");
					}
				}
				/*R ���ι�ġ�� �볪���� �������� �� ĭ �ű��.*/
				if(1 < pos.x){
					if(arr2[pos.y][pos.x-2][pos.shape] != 0  && arr2[pos.y][pos.x-1][pos.shape] == 1){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x - 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x-1][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ����");
					}
				}
				/*T ���ι�ġ�� �볪���� ���η�*/
				if(0 < pos.y && pos.y< height-1){//��ġ����� ���̸� ��ǥ�迡�� �����������
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y-1][pos.x][pos.shape] != 0 && arr2[pos.y-1][pos.x+1][pos.shape] != 0 ){//�볪�� �ٷ��� ����ǥ�� �̵������ϸ�
						if(arr2[pos.y+1][pos.x-1][pos.shape] != 0 && arr2[pos.y+1][pos.x][pos.shape] != 0 && arr2[pos.y+1][pos.x+1][pos.shape] != 0 ){//�볪�� �ٷξƷ� ����ǥ�� �̵������ϸ�		
							if(arr2[pos.y][pos.x][(pos.shape+1)%2] == 1){//��ġ������ �����ϸ�
								que.add(new Pos(pos.x, pos.y, deptLevel, (pos.shape+1)%2));
								arr2[pos.y][pos.x][(pos.shape+1)%2] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
								//System.out.println("���ο��� ����");
							}
						}
					}
				}
				
			}else{//����� �����̸�
				/*D ���ι�ġ�� �볪���� �Ʒ��� �� ĭ �ű��..*/
				if(pos.y < height-2){
					if(arr2[pos.y+2][pos.x][pos.shape] != 0 && arr2[pos.y+1][pos.x][pos.shape] == 1){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x, pos.y+1, deptLevel, pos.shape));
						arr2[pos.y+1][pos.x][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� �Ʒ�");
					}
				}
				/*U ���ι�ġ�� �볪���� ���� �� ĭ �ű��.*/
				if(1 < pos.y){
					if(arr2[pos.y-2][pos.x][pos.shape] != 0  && arr2[pos.y-1][pos.x][pos.shape] == 1){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x, pos.y-1, deptLevel, pos.shape));
						arr2[pos.y-1][pos.x][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ��");
					}
				}
				/*R ���ι�ġ�� �볪���� ���������� �� ĭ �ű��.*/
				if(pos.x < width-1){
					if(arr2[pos.y-1][pos.x+1][pos.shape] != 0 && arr2[pos.y][pos.x+1][pos.shape] == 1 && arr2[pos.y+1][pos.x+1][pos.shape] != 0){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x + 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x+1][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ������");
					}
				}
				/*R ���ι�ġ�� �볪���� �������� �� ĭ �ű��.*/
				if(0 < pos.x){
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y][pos.x-1][pos.shape] == 1 && arr2[pos.y+1][pos.x-1][pos.shape] != 0){//�̵������ϸ� �����̵���η� ����
						que.add(new Pos(pos.x - 1, pos.y, deptLevel, pos.shape));
						arr2[pos.y][pos.x-1][pos.shape] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����
						//System.out.println("���η� ����");
					}
				}
				/*T ���ι�ġ�� �볪���� ���η�*/
				if(0 < pos.x && pos.x< height-1){//��ġ����� �ʺ� ��ǥ�迡�� �����������
					if(arr2[pos.y-1][pos.x-1][pos.shape] != 0 && arr2[pos.y][pos.x-1][pos.shape] != 0 && arr2[pos.y+1][pos.x-1][pos.shape] != 0){//�볪�� �ٷο��� ����ǥ�� �̵������ϸ�
						if(arr2[pos.y-1][pos.x+1][pos.shape] != 0 && arr2[pos.y][pos.x+1][pos.shape] != 0 && arr2[pos.y+1][pos.x+1][pos.shape] != 0){//�볪�� �ٷο����� ����ǥ�� �̵������ϸ�		
							if(arr2[pos.y][pos.x][(pos.shape+1)%2] == 1){//��ġ������ �����ϸ�
								arr2[pos.y][pos.x][(pos.shape+1)%2] = -1;//���������Ƿ� �ش���ġ�� ������ ��󿡼� ����								
								que.add(new Pos(pos.x, pos.y, deptLevel, (pos.shape+1)%2));
								//System.out.println("���ο��� ����");
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
			System.out.println("������ �ܰ� :"+ deptLevel);
			System.out.println("������ ���� �湮�� ���� ��:"+ visitNum);
			String print[][] = new String[height][width];
			for(int y=0; y<height; y++){
				for(int x=0; x<width; x++){
					if(arr2[y][x][1] == 1 && arr2[y][x][0] == 1){//��� �̵������Ѱ�
						print[y][x] = "O ";
					}else if(arr2[y][x][1] != 1 && arr2[y][x][0] == 1){//���η� �̵������Ѱ�
						print[y][x] = "�� ";
					}else if(arr2[y][x][1] == 1 && arr2[y][x][0] != 1){//���η� �̵������Ѱ�
						print[y][x] = "�� ";
					}
					if(arr2[y][x][1] != 1 && arr2[y][x][0] != 1){//�̵��Ұ����Ѱ�
						print[y][x] = "X ";
					}if(arr2[y][x][0] == -1 && arr2[y][x][1] == -1){//�̹� ��� �̵��Ѱ�
						print[y][x] = ". ";
					}else if(arr2[y][x][1] == 1 && arr2[y][x][0] == -1){//�̹� ���η� �̵��Ѱ�
						print[y][x] = "�� ";
					}else if(arr2[y][x][1] == -1 && arr2[y][x][0] == 1){//�̹� ���η� �̵��Ѱ�
						print[y][x] = "�� ";
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
					print[pos.y][pos.x] = "�� ";
				else 
					print[pos.y][pos.x] = "�� ";
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
		//�Է�
		int w = sc.nextInt();//�ʺ�
		int h = w;//����
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
					bfs.setArrPossible(b, a, 0);//�̵������Ѱ�
					bfs.setArrPossible(b, a, 1);//�̵������Ѱ�
				}else{
					bfs.setArrImpossible(b, a, 0);//�̵� �Ұ����Ѱ�
					bfs.setArrImpossible(b, a, 1);//�̵� �Ұ����Ѱ�
				}
			}
		}
		
		//�볪���� ���� �߽���ġ�� ��� �� ����
		CenterOfX = (startX[0] + startX[1] + startX[2])/3;
		CenterOfY = (startY[0] + startY[1] + startY[2])/3;
		if(CenterOfX == startX[0])
			bfs.setStartPoint(CenterOfX, CenterOfY , 1);//���������� ����
		else 
			bfs.setStartPoint(CenterOfX, CenterOfY , 0);//���������� ����

		//�볪���� ���� �߽���ġ�� ��� �� ����
		CenterOfX = (endX[0] + endX[1] + endX[2])/3;
		CenterOfY = (endY[0] + endY[1] + endY[2])/3;
		if(CenterOfX == endX[0])
			bfs.setResultPoint(CenterOfX, CenterOfY , 1);//���������� ����
		else 
			bfs.setResultPoint(CenterOfX, CenterOfY , 0);//���������� ����
		
		//bfsó��
		bfs.processBfs(true);
		if(bfs.deptLevel == -1)
			System.out.println(0);
		else
			System.out.println(bfs.deptLevel);
		/*//��� ���
		System.out.println("�� ����ܰ�(������ ����):"+bfs.deptLevel);
		System.out.println("�湮�ߴ� ��ǥ��:"+bfs.visitNum);
		System.out.println("�湮������ ��ǥ��:"+bfs.possiblePathNum);
		if(bfs.possiblePathNum != bfs.visitNum)
			System.out.println("��� ������ �湮�ϴ� ���� �Ұ����� ��쿡 �ش�(�̵� �Ұ����� ������ �ѷ��׿��ִ°��)");*/
	}
}
