//문제 출처 : https://www.acmicpc.net/problem/14499
//제목 : 주사위굴리기14499

package 백준.시뮬레이션;
import java.util.Scanner;

public class 주사위굴리기14499 {
	static class Dice{
		int top;//3차원에서 위
		int bottom;//3차원에서 아래
		int right;//오른쪽
		int left;//왼쪽
		int up;//2차원에서 위
		int down;//2차원에서아래
		int x;
		int y;
		int height;
		int width;
		
		public Dice(int y, int x, int height, int width) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
		}

		String move(int direction){
			// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
			if(direction == 1){
				if(x+1 == width)
					return "";
				int temp = top;
				top = left;
				left = bottom;
				bottom = right;
				right = temp;
				x++;
			}else if(direction == 2){
				if(x-1 == -1)
					return "";
				int temp = top;
				top = right;
				right = bottom;
				bottom = left;
				left = temp;
				x--;
			}else if(direction == 3){
				if(y-1 == -1)
					return "";
				int temp = top;
				top = down;
				down = bottom;
				bottom = up;
				up = temp;
				y--;
			}else if(direction == 4){
				if(y+1 ==  height)
					return "";
				int temp = top;
				top = up;
				up = bottom;
				bottom = down;
				down = temp;
				y++;
			}
			return top+"";
		}
		int setNumFromBoard(int boardNum){
			if(boardNum == 0){
				//이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사
				return bottom;
			}else{
				//이동한 칸에 써 있는 수가 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며, 칸에 써 있는 수는 0이 된다.
				bottom = boardNum;
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		Dice dice = new Dice(sc.nextInt(),sc.nextInt(), height, width);
		int n = sc.nextInt();
		int board[][] = new int[height][width];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++)
				board[y][x] = sc.nextInt();
		}
		//좌표 입력
		for(int i = 0; i < n; i++){
			//주사위를 방향에 맞게 이동
			String moveResult = dice.move(sc.nextInt());
			if(moveResult.length() == 0)
				continue;
			
			board[dice.y][dice.x] = dice.setNumFromBoard(board[dice.y][dice.x]);
			System.out.println(moveResult);
		}
	}
}