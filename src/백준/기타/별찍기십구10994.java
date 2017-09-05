//문제 출처 : https://www.acmicpc.net/problem/10994
//제목 : 별찍기십구10994

package 백준.기타;

import java.util.Scanner;

public class 별찍기십구10994 {
	public static char arr[][];
	public static int n;
	public static int width = 1;
	public static int height = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt()-1;
		width = n*4 + 1;
		height = n*4 + 1;
		arr = new char[height][width];//max byte : 8 * 10* 10 * 2* 2 byte
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++)
				arr[i][j] = ' ';
		}
		setArr(0,width-1, 0, height-1);
		//결과출력
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
	public static void setArr(int x1, int x2, int y1, int y2){
		if(x1 == x2 && y1== y2){
			arr[y1][x1] = '*';
			return;
		}
		for(int y = y1; y <= y2; y++){
			arr[y][x1]  = '*';
			arr[y][x2]  = '*';
		}
		for(int x = x1; x <= x2; x++){
			arr[y2][x]  = '*';
			arr[y1][x]  = '*';
		}
		setArr(x1+2, x2-2, y1+2, y2-2);
	}
}
