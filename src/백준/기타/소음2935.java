//문제 출처 : https://www.acmicpc.net/problem/2935
//제목 : 소음2935

package 백준.기타;

import java.util.Scanner;

public class 소음2935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1 = sc.next();
		char operator = sc.next().charAt(0);
		String n2 = sc.next();
		int numberOfzero1 = n1.length() - 1;
		int numberOfzero2 = n2.length() - 1;
		if(operator == '*'){
			System.out.print("1");
			for(int i = 0; i < numberOfzero2+numberOfzero1; i++)
				System.out.print("0");
			System.out.println();
		}else{
			int it1 = n1.length() - 1;
			int it2 = n2.length() - 1;
			String result = "";
			for(;0 <= it1 && 0 <= it2; it1--, it2--){
				if(n1.charAt(it1) == '0' && n2.charAt(it2) == '0'){
					result = "0" + result;
					continue;
				}else if(n1.charAt(it1) == '1' && n2.charAt(it2) == '0'){
					result = "1" + result;
					for(int i = it2-1; 0<=i; i--)
						result = n2.charAt(i) + result;
				}else if(n2.charAt(it2) == '1' && n1.charAt(it1) == '0'){
					result = "1" + result;
					for(int i = it1-1; 0<=i; i--)
						result = n1.charAt(i) + result;
				}else if(n2.charAt(it2) == '1' && n1.charAt(it1) == '1'){
					result = "2" + result;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
