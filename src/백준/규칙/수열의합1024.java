//���� ��ó : https://www.acmicpc.net/problem/1024
//���� : ��������1024



package ����.��Ģ;
import java.util.Scanner;
public class ��������1024 {
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
