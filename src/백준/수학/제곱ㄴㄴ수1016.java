//문제 출처 : https://www.acmicpc.net/problem/1016
//제목 : 제곱ㄴㄴ수1016

package 백준.수학;
import java.util.Scanner;
public class 제곱ㄴㄴ수1016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = Long.valueOf(sc.next());
		long max = Long.valueOf(sc.next());
		if(max < min){
			System.out.println(0);
			return;
		}
		boolean noNum[] = new boolean[(int)(max - min + 1)];
		for(long i = 2;  i*i <= max; i++){//나눌수있는 제곱수만큼
			for(long j = min/i/i; i*i*j <= max; j++){//제곱수의 배수가 되는 범위내 수만큼
				if(0 <= (i*i*j-min))
					noNum[(int) (i*i*j-min)] = true;
			}
		}
		long result = 0;
		for(int i = 0; i < noNum.length; i++){
			if(!noNum[i])
				result++;
		}
		System.out.println(result);
	}

}