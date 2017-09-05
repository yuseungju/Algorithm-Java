//문제 출처 : https://www.acmicpc.net/problem/2447
//제목 : 별찍기십2447

package 백준.기타;

import java.util.Scanner;

public class 별찍기십2447 {
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i  =0; i < 2187; i++){
			for(int j  = 0; j < 2187; j++)
				arr[i][j] = ' ';
		}
		print(0,n-1,0,n-1);

		for(int i  =0; i < n; i++){
			for(int j  =0; j < n; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
	public static char arr[][] = new char[2187][2787];
	public static String str ="";
	public static int kindNum = 0;
	public static void print(int x1,  int x2, int y1, int y2){
		int width = x2-x1+1;
		if(width == 1){
			arr[y1][x1] = '*';
			return;
		}
		print(x1, x1 + width/3-1, y1, y1 + width/3-1);
		print(x1 + width/3, x1 + width*2/3-1, y1, y1 + width/3-1);
		print(x1 + width*2/3, x1 + width-1, y1, y1 + width/3-1);
		
		print(x1, x1 + width/3-1, y1 + width/3, y1 + width*2/3-1);
		//print(width/3, width*2/3-1, y1 + width/3, y1 + width*2/3-1);
		print(x1 + width*2/3, x1 + width-1, y1 + width/3, y1 + width*2/3-1);
		
		print(x1, x1 + width/3-1, y1 + width*2/3, y1 + width-1);
		print(x1 + width/3, x1 + width*2/3-1, y1 + width*2/3, y1 + width-1);
		print(x1 + width*2/3, x1 + width-1, y1 + width*2/3, y1 + width-1);
	}
}
