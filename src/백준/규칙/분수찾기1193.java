//���� ��ó : https://www.acmicpc.net/problem/1193
//���� : �м�ã��1193
package ����.��Ģ;
import java.util.Scanner;

public class �м�ã��1193 {
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
