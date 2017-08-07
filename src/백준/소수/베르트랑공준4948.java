//문제 출처 : https://www.acmicpc.net/problem/4948
//제목 : 베르트랑공준4948

package 백준.소수;

import java.util.ArrayList;
import java.util.Scanner;

public class 베르트랑공준4948 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0)
				return false;//소수가아님
			if(list.get(a)* list.get(a) < a)
				break;
		}
		list.add(n);
		return true;//소수임
	}
	public static void main(String[] args) {
		int n;
		int f = 1;
		while(true){
			n = sc.nextInt();
			if(n == 0)
				break;
			for(int i = f; i <= 2*n; i++)
				isNum(i);
			if(f < 2*n + 1)
				f = 2*n + 1;
			
			int result = 0;
			for(int a=0; a < list.size(); a++){
				if(n < list.get(a))
					result++;
				if(2*n <= list.get(a)){
					result--;
					if(2*n == list.get(a))
						result++;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
