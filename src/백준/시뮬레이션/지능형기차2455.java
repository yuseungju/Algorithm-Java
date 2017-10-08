//문제 출처 : https://www.acmicpc.net/problem/2455
//제목 : 지능형기차2455

package 백준.시뮬레이션;

import java.util.Scanner;

public class 지능형기차2455 {
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
