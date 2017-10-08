//문제 출처 : https://www.acmicpc.net/problem/2160
//제목 : 그림비교2160



package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 그림비교2160 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Character[][]> list = new ArrayList<Character[][]>();
		for(int i = 0; i < n; i ++){
			Character arr[][] = new Character[5][7];
			for(int h = 0; h < 5; h++){
				String str = sc.next();
				for(int w = 0; w < 7; w++)
					arr[h][w] = str.charAt(w);
			}
			list.add(arr);
		}
		
		int min = Integer.MAX_VALUE;
		int minV1 = 0;
		int minV2 = 0;
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				Character[][] arr1 = list.get(i);
				Character[][] arr2 = list.get(j);
				//print(arr1);
				//print(arr2);
				int value = 0;
				for(int h = 0; h < arr1.length; h++){
					for(int w = 0; w < arr1[h].length; w++){
						if(arr1[h][w] != arr2[h][w])
							value++;
					}
				}
				if(value < min){
					min = value;
					minV1 = i + 1;
					minV2 = j + 1;
				}
			}
		}
		System.out.println(minV1 + " " + minV2);
	}
	public static void print(Character[][] arr1){
		for(int h = 0; h < arr1.length; h++){
			for(int w = 0; w < arr1[h].length; w++){
				System.out.print(arr1[h][w] + " ");
			}System.out.println();
		}
		System.out.println();
	}
}
