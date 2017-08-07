//문제 출처 : https://www.acmicpc.net/problem/1003
//제목 : 피보나치함수1003

package DP;
import java.io.IOException;
import java.util.Scanner;

public class 피보나치함수1003 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		String[] result = new String[t];
		for(int a=0; a<t; a++){
			String str="";
			int i = Integer.parseInt(sc.next());
			if(i == 0)
				str = 1 +" " + 0;
			else if(i == 1)
				str = 0 +" " + 1;
			else 
				str =  fibonacci(i -1) +" " + fibonacci(i ) ;
			result[a] = str;
		}
		for(int a=0; a<t; a++){
			System.out.println(result[a]);
		}
	}
	public static int fibonacci(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}

