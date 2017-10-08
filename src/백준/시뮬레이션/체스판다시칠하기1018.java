//문제 출처 : https://www.acmicpc.net/problem/1018
//제목 : 체스판다시칠하기1018

package 백준.시뮬레이션;
import java.util.*;
import java.math.*;
import java.net.StandardSocketOptions;

public class 체스판다시칠하기1018 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int height =  sc.nextInt();
		int width =  sc.nextInt();
		char arr[][] = new char[height][width];
		for (int i = 0; i < height; i++) {
			String str = sc.next();
			for (int j = 0; j < width; j++) 
				arr[i][j] = str.charAt(j);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i+7 < height; i++) {
			for (int j = 0; j+7 < width; j++) {
				int value = getMinNumFill(arr,j,i);
				//System.out.println(value);
				if(value < min)
					min = value;
			}
		}
		System.out.println(min);
	}
	public static int getMinNumFill(char arr[][], int x, int y){
		int min = 0;
		char curExpress = 'B';
		for (int i = y; i <  y+8; i++) {
			for (int j = x; j < x+8; j++) {
				if(arr[i][j] != curExpress)
					min++;
				if(curExpress == 'B')
					curExpress = 'W';
				else
					curExpress = 'B';
			}
			if(curExpress == 'B')
				curExpress = 'W';
			else
				curExpress = 'B';
		}
		return Integer.min(min, 64-min);
	}
}
