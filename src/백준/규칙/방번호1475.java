//���� ��ó : https://www.acmicpc.net/problem/1475
//���� : ���ȣ1475

package ����.��Ģ;

import java.util.Scanner;

public class ���ȣ1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int setNumber[] = new int[10]; // 0~9
		String n = sc.next(); 
		for(int a=0; a<n.length(); a++)
			setNumber[Integer.parseInt(n.charAt(a)+"")]++;

		setNumber[6] = setNumber[9] = Math.round((setNumber[6]+ setNumber[9])/2.f);
		int max = Integer.MIN_VALUE;
		for(int a=0; a<10; a++){
			if(max < setNumber[a])
				max = setNumber[a];
		}
		System.out.println(max);
	}
}
