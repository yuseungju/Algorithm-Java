package ����.��Ÿ;

import java.util.Scanner;

public class ����ū�ݹμ� {
	public static void main(String[] args) {
		int n = (new Scanner(System.in)).nextInt();
		int result = 4;
		for(int i = 4; i <= n; i++){
			boolean ch = true;
			for(int  j = i; 1<=j && ch; j/=10){
				if(j%10 != 4 && j%10 != 7)
					ch = false;
			}
			if(ch)
				result =i;
		}
		System.out.println(result);
	}
}
