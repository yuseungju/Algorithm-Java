//���� ��ó : https://www.acmicpc.net/problem/4948
//���� : ����Ʈ������4948

package ����.�Ҽ�;

import java.util.ArrayList;
import java.util.Scanner;

public class ����Ʈ������4948 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0)
				return false;//�Ҽ����ƴ�
			if(list.get(a)* list.get(a) < a)
				break;
		}
		list.add(n);
		return true;//�Ҽ���
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
