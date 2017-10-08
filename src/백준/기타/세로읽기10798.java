package 백준.기타;

import java.util.Scanner;

public class 세로읽기10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char arr[][]= new char[5][15];
		for(int i = 0; i < 5; i++){
			String str = sc.next();
			for(int j = 0; j < str.length(); j++)
				arr[i][j] = str.charAt(j);
			for(int j = str.length(); j <15; j++)
				arr[i][j] = '^';
		}
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 5; j ++){
				if(arr[j][i] != '^')
					System.out.print(arr[j][i]);
			}
		}
	}
}
