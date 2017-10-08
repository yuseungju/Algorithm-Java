//���� ��ó : https://www.acmicpc.net/problem/1547
//���� : ��1547


package ����.�ùķ��̼�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ��1547 {
	static class Swap{
		int n1;
		int n2;
		public Swap(int n1, int n2) {
			super();
			this.n1 = n1;
			this.n2 = n2;
		}
		public String toString() {
			return   n1 + ","+ n2;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Swap>  list = new ArrayList<Swap>();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		pos.add(0);
		pos.add(1);
		pos.add(2);
		pos.add(3);
		for(int i = 0; i < n; i++)
			list.add(new Swap(sc.nextInt(), sc.nextInt()));
		for(int i = 0; i < n; i++)
			Collections.swap(pos, list.get(i).n1, list.get(i).n2);
		
		
		System.out.println(pos.indexOf(1));
		
	}
}
