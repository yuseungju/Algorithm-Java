//문제 출처 : https://www.acmicpc.net/problem/1267
//제목 : 핸드폰요금1267

package 백준.수학;
import java.util.ArrayList;
import java.util.Scanner;

public class 핸드폰요금1267 {
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
