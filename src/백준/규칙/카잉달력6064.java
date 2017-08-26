//문제 출처 : https://www.acmicpc.net/problem/6064
//제목 : 카잉달력6064

package 백준.규칙;

import java.util.Scanner;

public class 카잉달력6064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int test = 0; test < testCase;  test++){
			int m,n,x,y;
			//범위
			m = sc.nextInt();
			n = sc.nextInt();
			//목표 날짜
			x = sc.nextInt(); 
			y = sc.nextInt(); 
			
			int multipleX = 0;
			int multipleY = 0;
			int xIt = 1;
			int yIt = 1;
			int history = Integer.MIN_VALUE;
			while(true){
				//목표 날짜자리에 있을때 총 이동된 칸을 구함
				xIt = m*multipleX + x;
				yIt = n*multipleY + y;
				//목표지점에서의 x와 y의 차이가 다시 반복된다면 앞으로도 찾지못한다고 판정
				if(history == xIt - yIt){
					xIt = -1;
					break;
				}else if(history == Integer.MIN_VALUE){
					history = xIt - yIt;
				}
				//x와 y의 목표지점에서 각자 이동된 날들을 비교하여 덜 이동된 날짜를 한바퀴 더 진행하여 다시옴
				if(xIt < yIt)
					multipleX++;
				else if(yIt < xIt)
					multipleY++;
				else//목표지점 두좌표 모두 이돌된 날들이 같으면 정답
					break;
			}
			System.out.println(xIt);
		}
	}
}
