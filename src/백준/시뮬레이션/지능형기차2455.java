//���� ��ó : https://www.acmicpc.net/problem/2455
//���� : ����������2455

package ����.�ùķ��̼�;

import java.util.Scanner;

public class ����������2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int allCount = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			int out = sc.nextInt();
			allCount -= out;
			int in = sc.nextInt();
			allCount  += in;
			if(max < allCount)
				max = allCount; 
			//System.out.println(allCount);
		}
		System.out.println(max);
	}
}
