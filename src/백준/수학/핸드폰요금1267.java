//���� ��ó : https://www.acmicpc.net/problem/1267
//���� : �ڵ������1267

package ����.����;
import java.util.ArrayList;
import java.util.Scanner;

public class �ڵ������1267 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list=  new ArrayList<Integer>();
		for(int i =0; i < n; i++)
			list.add(sc.nextInt());

		int sumM = 0;// 60
		int sumY = 0;// 30
		for (int i = 0; i < n; i++) {
			int time = list.get(i);
			sumY += (time/30 + 1)*10;
			sumM += (time/60 + 1)*15;
		}
		if(sumM < sumY)
			System.out.println("M "+ sumM);
		if(sumM > sumY)
			System.out.println("Y "+ sumY);
		if(sumM == sumY)
			System.out.println("Y M "+ sumM);
	}
}
