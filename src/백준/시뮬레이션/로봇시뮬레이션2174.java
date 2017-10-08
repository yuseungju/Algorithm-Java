//문제 출처 : https://www.acmicpc.net/problem/2174
//제목 : 로봇시뮬레이션2174


package 백준.시뮬레이션;
import java.util.Scanner;

public class 로봇시뮬레이션2174  {
	static class Pos{
		int x;
		int y;
		char direction;  // N,E,W,S
		public Pos(int x, int y, char direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + 
					 ", direction=" + direction + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt() + 1;
		int height = sc.nextInt() + 1;
		int arr[][] = new int[height][width];
		Pos robot[] = new Pos[sc.nextInt() + 1];
		int oprNum =  sc.nextInt();
		for(int i  = 1; i < robot.length; i++){
			robot[i] = new Pos(sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
			arr[robot[i].y][robot[i].x] = i;
		}
		
		for(int i = 0; i < oprNum; i++){
			int currentRobotNum = sc.nextInt();
			Pos current = robot[currentRobotNum];
			char changeDirection = sc.next().charAt(0);
			int count = sc.nextInt();
			for(int  c = 0 ; c < count; c++){
				int x = current.x;
				int y = current.y;
				if(changeDirection == 'R'){
					if(current.direction == 'W')
						current.direction = 'N';
					else if(current.direction == 'E')
						current.direction = 'S';
					else if(current.direction == 'N')
						current.direction  = 'E';
					else if(current.direction  == 'S')
						current.direction  = 'W';
				}else if(changeDirection  == 'L'){
					if(current.direction == 'W')
						current.direction = 'S';
					else if(current.direction == 'E')
						current.direction = 'N';
					else if(current.direction == 'N')
						current.direction  = 'W';
					else if(current.direction  == 'S')
						current.direction  = 'E';
				}else if(changeDirection =='F'){
					if(current.direction == 'W')
						current.x = current.x - 1;
					else if(current.direction == 'E')
						current.x = current.x + 1;
					else if(current.direction == 'N')
						current.y = current.y + 1;
					else if(current.direction  == 'S')
						current.y = current.y -1;
					
					if(current.y < height &&   1 <= current.x && current.x < width && 1 <= current.y && arr[current.y][current.x] == 0){
						arr[current.y][current.x] = currentRobotNum;
						arr[y][x] = 0;
					}else if(!(current.y < height && 1 <= current.x && current.x < width && 1 <= current.y)){
						System.out.println("Robot "+ currentRobotNum +" crashes into the wall");
						return;
					}else if(arr[current.y][current.x] != 0){
						System.out.println("Robot "+currentRobotNum+" crashes into robot "+arr[current.y][current.x]);
						return;
					}
				}
			}
		}
		System.out.println("OK");
	}
}