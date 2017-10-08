package ����.DFS;

import java.util.Scanner;

public class �κ�û�ұ�14503 {
	public static int result = 0;//û���ϴ� ������ ����
	public static int arr[][];
	public static int startY;
	public static int startX;
	public static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		arr = new int[height][width];
		startY =sc.nextInt(); 
		startX = sc.nextInt();
		int direction = sc.nextInt();
		for(int y = 0; y < height;  y++){
			for(int x = 0; x < width; x++)
				arr[y][x] = sc.nextInt();
		}
		
		clean(startY, startX);
		int count = 4;
		while(true){
			//print();
			if(possibleCleanLeft(direction)){
				//���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
				direction = toLeftDirection(direction);
				if(toFront(direction))//������ �̵��ߴٸ� û���� �ٽ� 2������(= 1��������)
					clean(startY, startX);
				count = 4;
			}else if(count != 0){
				//���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
				count--;
				direction = toLeftDirection(direction);
			}else{//�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭
				if(!toBack(direction)){
					//������ ���̶� �̵��Ұ��̸�
					break;
				}
				//������ ����������   �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
				count = 4;
			}
		}
		System.out.println(result);
	}
	public static void print(){
		for(int i =0 ; i < arr.length; i++){
			for(int  j =0; j < arr[i].length; j++){
					System.out.print(arr[i][j] + " ");
				
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean possibleCleanLeft(int curDirection){
		if(curDirection==0){ //��(��)
			if(0 <= startX-1 && arr[startY][startX-1] == 0)
				return true;
		}
		else if(curDirection==3){ //��(��)
			if(startY+1 < arr.length  && arr[startY+1][startX] == 0)
				return true;
		}
		else if(curDirection==2){ //��(�Ʒ�)
			if(startX+1 < arr[0].length  && arr[startY][startX+1] == 0)
				return true;
		}
		else if(curDirection==1){ //��(��)
			if(0 <= startY-1 && arr[startY-1][startX] == 0)
				return true;
		}
		return false;
	}
	public static boolean toBack(int curDirection){
		if(startY+1 < arr.length && curDirection==0 && arr[startY+1][startX] != 1) //��(��)
			startY++;
		else if(startX+1 < arr[0].length && curDirection==3 && arr[startY][startX+1] != 1) //��(��)
			startX++;
		else if(0 <= startY-1 && curDirection==2 && arr[startY-1][startX] != 1) //��(�Ʒ�)
			startY--;
		else if(0 <= startX-1  && curDirection==1 && arr[startY][startX-1] != 1) //��(��)
			startX--;
		else
			return false;
		return true;
	}
	public static boolean toFront(int curDirection){
		if(0 <= startY-1 && curDirection==0) //��(��)
			startY--;
		else if(0 <= startX-1  && curDirection==3) //��(��)
			startX--;
		else if(startY+1 < arr.length  && curDirection==2) //��(�Ʒ�)
			startY++;
		else if(startX+1 < arr[0].length && curDirection==1) //��(��)
			startX++;
		else 
			return false;
		return true;
	}
	public static int toLeftDirection(int curDirection){
		if(curDirection==0) 
			return 3;
		else if(curDirection==3) 
			return 2;
		else if(curDirection==2) 
			return 1;
		else if(curDirection==1) 
			return 0;
		return -1;
	}
	public static void clean(int y, int x){
		//���� ��ġ�� û���Ѵ�.
		arr[y][x] = 3;
		result ++;
	}
}
