//���� ��ó : https://www.acmicpc.net/problem/������̽�10995
//���� : ������̽�10995

package ����.��Ÿ;

import java.util.Scanner;

public class ������̽�10995 {
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
