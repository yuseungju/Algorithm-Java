//문제 출처 : https://www.acmicpc.net/problem/1929
//제목 : 소수구하기1929

package 백준.소수;
import java.util.ArrayList;
import java.util.Scanner;

public class 소수구하기1929 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0){
				return false;//소수가아님
			}
			if(list.get(a)* list.get(a) < a){
				break;
			}
		}
		list.add(n);
		return true;//소수임
	}
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int a=1; a<=m; a++){
			isNum(a);
		}
		int a;
		for(a=0; a < list.size(); a++){
			if(n <= list.get(a))
				break;
		}
		for(; a < list.size(); a++)
			System.out.println(list.get(a));
	}
}