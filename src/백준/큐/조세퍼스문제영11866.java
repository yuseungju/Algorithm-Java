//문제 출처 : https://www.acmicpc.net/problem/11866
//제목 : 조세퍼스문제영 11866

package 백준.큐;

import java.util.ArrayList;
import java.util.Scanner;

public class 조세퍼스문제영11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int step = sc.nextInt() - 1;//삭제되면 다음 삭제할 사람의 인덱스는 앞으로하나이동, 하나적은 증가단위로 설정
		int m = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int  i = 1; i <= n;  i++)
			list.add(i);
		int result[] = new int[n];
		int resultIt = 0;
		while(list.size() != 0){//남아있는 사람이 존재하면 계속 수행
			m += step;
			m %= list.size();//리스트를 원형으로 반복 접근
			result[resultIt++] = list.get(m);//제거될 사람을 기록
			list.remove(m);//사람을 제거
		}
		
		//출력
		System.out.print("<");
		System.out.print(result[0]);
		for(int i = 1; i < n; i++){
			System.out.print(", " + result[i]);
		}
		System.out.println(">");
	}
}
