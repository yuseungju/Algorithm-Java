//���� ��ó : https://www.acmicpc.net/problem/13458
//���� : ���谨��13458

package ����.��Ÿ;

import java.util.Arrays;
import java.util.Scanner;

public class ���谨��13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		long result = n;
		long studentNum[] = new long[n];
		for(int i = 0; i < n ; i++)
			studentNum[i] = sc.nextInt();
		
		int manager1 = sc.nextInt();
		int manager2 = sc.nextInt();

		for(int i = 0; i < n; i++)
			studentNum[i] -= manager1;
		
		for(int i = 0; i < n; i++){
			for(;0 < studentNum[i] ;studentNum[i]-=manager2)
				result++;
		}
		System.out.println(result);
	}
}
