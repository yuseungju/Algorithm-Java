package ����.�ùķ��̼�;

import java.util.ArrayList;
import java.util.Scanner;

public class ī��2161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String str ="";
		for (int i = 1; i <= n; i++)
			list.add(i);
		while(1 < list.size()){
			//������
			str+= list.get(0) +" ";
			list.remove(0);
			
			//�ű��
			list.add(list.get(0));
			list.remove(0);
		}
		str += list.get(0);
		System.out.println(str);
	}
}
