//���� ��ó : https://www.acmicpc.net/problem/1297
//���� : TVũ��1297


package ����.��Ÿ;

import java.util.Scanner;

public class TVũ��1297 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//hRate < wRate
		double hRate = sc.nextInt();
		double wRate = sc.nextInt();
		double w = Math.pow((n*n)/((hRate*hRate)/(wRate*wRate)+1),0.5);
		double h = hRate/wRate*w;
		System.out.println((int)h +" "+ (int)w);
	}
}
