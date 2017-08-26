//문제 출처 : https://www.acmicpc.net/problem/1193
//제목 : 분수찾기1193
package 백준.규칙;
import java.util.Scanner;

public class 분수찾기1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x =1; 
		int y= 1;
		int it = 1;
		int reverse = 0;
		while(n != it){
			if(reverse == 1){
				y++; it++;
				while(n != it){
					x++; y--; it++;
					if(y==1)
						break;
				}
			}else{
				x++; it++;
				while(n != it){
					x--; y++; it++;
					if(x==1)
						break;
				}
			}
			reverse = (reverse+1)%2;
		}
		System.out.println(y+"/"+x);
	}
}
