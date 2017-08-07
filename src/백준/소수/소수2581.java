//���� ��ó : https://www.acmicpc.net/problem/2581
//���� : �Ҽ�2581

package ����.�Ҽ�;
import java.util.Scanner;

public class �Ҽ�2581 {
	public static Scanner sc = new Scanner(System.in);
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=2; a <= n/2; a++){
			if(n%a == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int num = 0;
		for(int i=m; i<=n; i++){
			if(isNum(i)){
				num +=i;
				if(i < min){
					min = i;
				}
			}
		}
		if(min == Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(num);
			System.out.println(min);
		}
	}
}


		




