//문제 출처 : https://www.acmicpc.net/problem/10993
//제목 : 별찍기십팔10993

package 백준.기타;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 별찍기십팔10993 {
	public static char arr[][];
	public static int n;
	public static int width = 1;
	public static int height = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 2; i <= n;  i++)
			height = (height*2 + 1);
		width = height * 2 -1;
		arr = new char[height][width];//max byte : 8 * 10* 10 * 2* 2 byte
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++)
				arr[i][j] = ' ';
		}
		if(n%2 == 1)
			setArr(0, 1);
		else
			setArr(height-1, 0);
		//결과출력
		for(int i = 0; i < height; i++){
			for(int j = width-1; 0 <= j ; j--){
				if(arr[i][j] == ' ')
					arr[i][j] = 'e';
				else
					break;
			}
		}
		//결과출력
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(arr[i][j] == 'e')
					break;
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void setArr(int centerY, int direction){
		int x1 = width/2;
		int x2 = width/2;
		int y = centerY;
		while(true){
			if(direction == 1){
				if(y == height-1)
					break;
				if(arr[y][x1-1] == '*')
					break;
				arr[y][x1] = '*';
				arr[y][x2] = '*';
				y++;
				x1--;
				x2++;
			}
			else{
				if(y == 0)
					break;
				if(arr[y][x1-1] == '*')
					break;
				arr[y][x1] = '*';
				arr[y][x2] = '*';
				y--;
				x1--;
				x2++;
			}
		}
		if(x1 == x2){
			arr[y][x1] = '*';
			return;
		}
		
		for(int x = x1; x <= x2;  x++)
			arr[y][x] = '*';
		if(direction == 1)
			y--;
		else
			y++;
		setArr(y, (direction+1)%2);
	}
}
