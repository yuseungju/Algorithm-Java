//문제 출처 : https://www.acmicpc.net/problem/10250
//제목 : ACM호텔10250

package 백준.규칙;

import java.util.Scanner;

public class ACM호텔10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		int height;
		int width;
		int n;
		int arr[][] = new int[100][100];
		boolean flag = true;
		for(int test = 0; test < T; test++){
			height = sc.nextInt();
			width = sc.nextInt(); 
			n = sc.nextInt();
			int x = 1;
			int y = 1;
			int nIt = 1;
			flag = true;
			for(x = 1; x <= width; x++){
				for(y = 1 ; y <= height;  y++){
					if(n == nIt){
						flag =false;
						break;
					}
					nIt++;
				}
				if(!flag)
					break;
			}
			String xStr= String.format("%02d", x);
			String yStr = String.format("%d", y);
			System.out.println(yStr+xStr);
		}
	}
}
