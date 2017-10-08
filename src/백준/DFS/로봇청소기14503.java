package 백준.DFS;

import java.util.Scanner;

public class 로봇청소기14503 {
	public static int result = 0;//청소하는 영역의 개수
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
				//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
				direction = toLeftDirection(direction);
				if(toFront(direction))//앞으로 이동했다면 청소후 다시 2를진행(= 1부터진행)
					clean(startY, startX);
				count = 4;
			}else if(count != 0){
				//왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
				count--;
				direction = toLeftDirection(direction);
			}else{//네 방향 모두 청소가 이미 되어있거나 벽이면서
				if(!toBack(direction)){
					//뒤쪽이 벽이라 이동불가이면
					break;
				}
				//뒤쪽이 열려있으면   바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
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
		if(curDirection==0){ //북(위)
			if(0 <= startX-1 && arr[startY][startX-1] == 0)
				return true;
		}
		else if(curDirection==3){ //서(좌)
			if(startY+1 < arr.length  && arr[startY+1][startX] == 0)
				return true;
		}
		else if(curDirection==2){ //남(아래)
			if(startX+1 < arr[0].length  && arr[startY][startX+1] == 0)
				return true;
		}
		else if(curDirection==1){ //동(우)
			if(0 <= startY-1 && arr[startY-1][startX] == 0)
				return true;
		}
		return false;
	}
	public static boolean toBack(int curDirection){
		if(startY+1 < arr.length && curDirection==0 && arr[startY+1][startX] != 1) //북(위)
			startY++;
		else if(startX+1 < arr[0].length && curDirection==3 && arr[startY][startX+1] != 1) //서(좌)
			startX++;
		else if(0 <= startY-1 && curDirection==2 && arr[startY-1][startX] != 1) //남(아래)
			startY--;
		else if(0 <= startX-1  && curDirection==1 && arr[startY][startX-1] != 1) //동(우)
			startX--;
		else
			return false;
		return true;
	}
	public static boolean toFront(int curDirection){
		if(0 <= startY-1 && curDirection==0) //북(위)
			startY--;
		else if(0 <= startX-1  && curDirection==3) //서(좌)
			startX--;
		else if(startY+1 < arr.length  && curDirection==2) //남(아래)
			startY++;
		else if(startX+1 < arr[0].length && curDirection==1) //동(우)
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
		//현재 위치를 청소한다.
		arr[y][x] = 3;
		result ++;
	}
}
