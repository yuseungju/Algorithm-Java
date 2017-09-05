//문제 출처 : https://www.acmicpc.net/problem/1024
//제목 : 수열의합1024



package 백준.규칙;
import java.util.Scanner;
public class 수열의합1024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		for(long i = m; i <= 100; i++){
			long num = (long)n/i;
			for(long j = num-i; j < num+i; j++){
				if(j < 0)
					continue;
				if((j+(j+i-1))/2.0*i == n){
					for(long k = j; k < j+i; k++)
						System.out.print(k + " ");
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
