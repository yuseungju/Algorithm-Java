//���� ��ó : https://www.acmicpc.net/problem/1212
//���� : ������������1212

package ����.��Ÿ;

import java.util.Scanner;

public class ������������1212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String part[]= {"000", "001" ,"010" ,"011" ,"100" ,"101" ,"110","111"};
		String frontPart[]= {"0", "1" ,"10" ,"11" ,"100" ,"101" ,"110","111"};
		String str = sc.next();
		System.out.print(frontPart[Integer.parseInt(str.charAt(0)+"")]);
		for(int i = 1; i < str.length(); i++)
			System.out.print(part[Integer.parseInt(str.charAt(i)+"")]);
	}
}
