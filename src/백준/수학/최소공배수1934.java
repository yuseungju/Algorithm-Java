//문제 출처 : https://www.acmicpc.net/problem/1934
//제목 : 최소공배수1934
//유클리드 호제법

package 백준.수학;
import java.util.Scanner;

public class 최소공배수1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			//n1은 n2보다 크게 설정
			if(n1 < n2){
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			int gdc;
			int n = n1;
			int remainder = n2;
			while(true){
				if(remainder == 0){
					gdc = n;
					break;
				}else{
					int tempRemainder = n%remainder;
					n = remainder;
					remainder = tempRemainder;
				}
			}
			System.out.println(n1 * n2 /gdc);
		}
	}
}
