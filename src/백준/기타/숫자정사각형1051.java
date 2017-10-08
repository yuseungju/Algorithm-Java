//문제 출처 : https://www.acmicpc.net/problem/1051
//제목 : 숫자정사각형1051


package 백준.기타;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;

public class 숫자정사각형1051  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		int arr[][] = new int[height][width];
		for(int i = 0; i < height; i ++){
			String str = sc.next();
			for(int  j = 0; j < width; j++)
				arr[i][j] = str.charAt(j)-48;
		}

		int n = Integer.min(height, width);
		int resutlt = 1;
		for(int side = 1; side <= n; side++) {
			for(int  i = 0; i + side < height; i++){
				for(int  j = 0; j + side < width; j++){
					int x1 = j;
					int x2 = j +side;
					int y1 = i;
					int y2 = i +side;
					if(arr[y1][x1] == arr[y2][x1] && arr[y2][x1] == arr[y2][x2] && arr[y2][x2] == arr[y1][x2]){
						//System.out.println(x1 + "," + x2 + "," + y1 + "," + y2);
						if(resutlt< (side+1)*(side+1))	
							resutlt = (side+1)*(side+1);
					}
				}
			}
		}
		System.out.println(resutlt);
		
	}
}
