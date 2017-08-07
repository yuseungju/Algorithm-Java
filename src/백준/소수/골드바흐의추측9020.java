//문제 출처 : https://www.acmicpc.net/problem/9020
//제목 : 골드바흐의추측9020
package 백준.소수;

import java.util.ArrayList;
import java.util.Scanner;

public class 골드바흐의추측9020 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static boolean isNum(int  n){
		if(n == 1)
			return false;
		
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
		int t = sc.nextInt();
		int arr[]= new int[t];
		for(int test = 0; test < t; test++)
			arr[test] = sc.nextInt();
		int max = -1;
		for(int a=0; a<t; a++){
			if(max < arr[a])
				max = arr[a];
		}
		
		for(int i = 1; i <= max; i++)
			isNum(i);
		
		for(int test = 0; test < t; test++){
			int l=0, r=0;
			for(int a=0; a<list.size(); a++){
				if(list.get(a) <  arr[test]/2){
					l = a;
				}else if(list.get(a) >  arr[test]/2){
					r = a;
					break;
				}else{
					l = r = a;
					break;
				}
			}
			while(list.get(r) + list.get(l) != arr[test]){
				if(list.get(r) + list.get(l) < arr[test])
					r+=1;
				else if(arr[test] < list.get(r) + list.get(l))
					l-=1;
				else
					break;
			}
			System.out.println(list.get(l) +" "+ list.get(r));
		}
	}
}




