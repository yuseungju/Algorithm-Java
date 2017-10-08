//문제 출처 : https://www.acmicpc.net/problem/5397
//제목 : 키로커5397

package 백준.시뮬레이션;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class 키로커5397 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int test = 0; test < testcase; test++) {
			StringBuilder resultText = new StringBuilder();
			String str = sc.next();
			LinkedList<Character> result = new LinkedList<Character>();
			int resultIt = 0;
			for (int i = 0; i < str.length(); i++) {
				char cur = str.charAt(i);
				if (cur == '-') {
					if (0 < resultIt){
						resultIt--;
						result.remove(resultIt);
					}
				} else if (cur == '>') {
					if (resultIt < result.size())
						resultIt++;
				} else if (cur == '<') {
					if (0 < resultIt)
						resultIt--;
				} else {
					result.add(resultIt, cur);
					resultIt++;
				}
			}
			Iterator<Character> itr = result.iterator();
			while (itr.hasNext())
				resultText.append(itr.next());
			System.out.println(resultText);
		}
	}
}
