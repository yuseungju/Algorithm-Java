//문제 출처 : https://www.acmicpc.net/problem/1297
//제목 : TV크기1297


package 백준.기타;

import java.util.Scanner;

public class TV크기1297 {
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
