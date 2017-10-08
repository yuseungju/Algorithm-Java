package 백준.미해결;

import java.util.ArrayList;
import java.util.Scanner;

public class 도트이미지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int board[][] = new int[n][n];
		for(int i = 0; i < n ; i++){
			for(int  j = 0; j < n; j++){
				board[i][j] =  sc.nextInt();
			}
		}
		int number = 1;
		for(int y = 0; y < n; y++){
			for(int x = 0; x < n; x++){
				if(board[y][x] == 1){
					number++;
					ArrayList<Integer> xQ =  new ArrayList<Integer>();
					ArrayList<Integer> yQ =  new ArrayList<Integer>();
					xQ.add(x);
					yQ.add(y);
					board[y][x] = number;
					while(0 < yQ.size()){
						int curX = xQ.get(0);
						int curY = yQ.get(0);
						yQ.remove(0);
						xQ.remove(0);
						if(0 <= curX-1){
							if( board[curY][curX-1] == 1){
								xQ.add(curX-1);
								yQ.add(curY);
								board[curY][curX-1] = number;
							}
						}
						if(curX+1 < n){
							if(board[curY][curX+1] == 1){
								xQ.add(curX+1);
								yQ.add(curY);
								board[curY][curX+1] = number;
							}
						}
						if(0 <= curY-1){
							if(board[curY-1][curX] == 1){
								xQ.add(curX);
								yQ.add(curY-1);
								board[curY-1][curX] = number;
							}
						}
						if(curY+1 < n){
							if(board[curY+1][curX] == 1){
								xQ.add(curX);
								yQ.add(curY+1);
								board[curY+1][curX] = number;
							}
						}
					}
				}
			}
		}
		number--;
		System.out.println(number);
	}
}
