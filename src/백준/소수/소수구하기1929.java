//���� ��ó : https://www.acmicpc.net/problem/1929
//���� : �Ҽ����ϱ�1929

package ����.�Ҽ�;
import java.util.ArrayList;
import java.util.Scanner;

public class �Ҽ����ϱ�1929 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static boolean isNum(int  n){
		if(n == 1){
			return false;
		}
		for(int a=0; a < list.size(); a++){
			if(n%list.get(a) == 0){
				return false;//�Ҽ����ƴ�
			}
			if(list.get(a)* list.get(a) < a){
				break;
			}
		}
		list.add(n);
		return true;//�Ҽ���
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