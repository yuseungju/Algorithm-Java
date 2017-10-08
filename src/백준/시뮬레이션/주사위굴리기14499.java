//���� ��ó : https://www.acmicpc.net/problem/14499
//���� : �ֻ���������14499

package ����.�ùķ��̼�;
import java.util.Scanner;

public class �ֻ���������14499 {
	static class Dice{
		int top;//3�������� ��
		int bottom;//3�������� �Ʒ�
		int right;//������
		int left;//����
		int up;//2�������� ��
		int down;//2���������Ʒ�
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
			// ������ 1, ������ 2, ������ 3, ������ 4
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
				//�̵��� ĭ�� �� �ִ� ���� 0�̸�, �ֻ����� �ٴڸ鿡 �� �ִ� ���� ĭ�� ����
				return bottom;
			}else{
				//�̵��� ĭ�� �� �ִ� ���� 0�� �ƴ� ��쿡�� ĭ�� �� �ִ� ���� �ֻ����� �ٴڸ����� ����Ǹ�, ĭ�� �� �ִ� ���� 0�� �ȴ�.
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
		//��ǥ �Է�
		for(int i = 0; i < n; i++){
			//�ֻ����� ���⿡ �°� �̵�
			String moveResult = dice.move(sc.nextInt());
			if(moveResult.length() == 0)
				continue;
			
			board[dice.y][dice.x] = dice.setNumFromBoard(board[dice.y][dice.x]);
			System.out.println(moveResult);
		}
	}
}