//���� ��ó : https://www.acmicpc.net/problem/9012
//���� : ��ȣ9012

package ����.����;
import java.util.Scanner;

public class ��ȣ9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int test = 0;  test < testCase; test++){
			String str = sc.next();
			int left = 0;
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) == ')')
					left--;
				else 
					left++;
				if(left < 0){
					left = -1;
					break;
				}
			}
			if(left == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}























