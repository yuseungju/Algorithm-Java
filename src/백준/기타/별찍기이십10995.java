//문제 출처 : https://www.acmicpc.net/problem/별찍기이십10995
//제목 : 별찍기이십10995

package 백준.기타;

import java.util.Scanner;

public class 별찍기이십10995 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		for(int i =1; i <=n; i++){
			if(i%2 == 0)
				System.out.print(" ");
			for(int j =1; j <=n; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
}
