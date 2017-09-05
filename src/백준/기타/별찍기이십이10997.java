//문제 출처 : https://www.acmicpc.net/problem/10997
//제목 : 별찍기이십이10997

package 백준.기타;

import java.util.Scanner;

public class 별찍기이십이10997 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1){
			System.out.println("*");
			return;
		}
		int width = 4*n -3;
		int height =  4*n -1;
		char arr[][] = new char[height][width+1];
		for(int i = 0; i < height; i++){
			for(int j = 0; j <= width; j++)
				arr[i][j] = ' ';
		}
		
		int currentX = width/2;
		int currentY = height/2;
		arr[currentY-1][currentX]  = '*';
		arr[currentY][currentX]  = '*';
		arr[currentY+1][currentX]  = '*';
		currentY = currentY-1;
		
		int right = 4;
		int left = 4;
		int up = 6;
		int down = 4;
		for(int i =0; i < n-1; i++){
			for(int j = 0; j < 2; j++){
				currentX++;
				arr[currentY][currentX] = '*';
			}
			for(int j = 0; j < down; j++){
				currentY++;
				arr[currentY][currentX] = '*';
			}
			for(int j = 0; j < left; j++){
				currentX--;
				arr[currentY][currentX] = '*';
			}
			for(int j = 0; j < up; j++){
				currentY--;
				arr[currentY][currentX] = '*';
			}
			for(int j = 0; j < right; j++){
				currentX++;
				arr[currentY][currentX] = '*';
			}
			right+=4;
			left+=4;
			up+=4;
			down+=4;
		}
		for(int i = 0;  i <  height; i++){
			for(int j = width;  0 <= j ; j--){
				if(arr[i][j] == ' ')
					arr[i][j] = 'e';
				else
					break;
			}
		}
		for(int i = 0;  i < height; i++){
			for(int j = 0;  j <= width; j++){
				if(arr[i][j] == 'e')
					break;
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
