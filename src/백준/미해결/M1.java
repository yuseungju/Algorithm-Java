package 백준.미해결;

import java.util.Scanner;

public class M1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char arr[][] = new char[5][str.length()*4 + 1];
		char board[][] = {
				{'.','.','#','.','.' },
				{'.','#','.','#','.' },
				{'#','.','c','.','#' },
				{'.','#','.','#','.' },
				{'.','.','#','.','.' }
		};
		
		int startX = 0;
		for(int  i = 0; i < str.length(); i++, startX+=4){
			for(int y = 0; y < 5; y++){
				for(int  x = 0; x < 5; x++){
					if(board[y][x] == 'c')
						arr[y][x + startX] = str.charAt(i);
					else
						arr[y][x + startX] = board[y][x];
				}
			}
		}
		startX = 0;
		for(int  i = 0; i < str.length(); i++, startX+=4){
			if((i+1)%3 != 0)
				continue;
			for(int y = 0; y < 5; y++){
				for(int  x = 0; x < 5; x++){
					if(board[y][x] == 'c')
						arr[y][x + startX] = str.charAt(i);
					else if(board[y][x] == '#')
						arr[y][x + startX] = '*';
					else
						arr[y][x + startX] = board[y][x];
				}
			}
		}
		for(int y = 0; y < arr.length; y++){
			for(int  x = 0; x < arr[0].length; x++)
				System.out.print(arr[y][x]);
			System.out.println();
		}
	}
}
