//���� ��ó : https://www.acmicpc.net/problem/11866
//���� : �����۽������� 11866

package ����.ť;

import java.util.ArrayList;
import java.util.Scanner;

public class �����۽�������11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int step = sc.nextInt() - 1;//�����Ǹ� ���� ������ ����� �ε����� �������ϳ��̵�, �ϳ����� ���������� ����
		int m = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int  i = 1; i <= n;  i++)
			list.add(i);
		int result[] = new int[n];
		int resultIt = 0;
		while(list.size() != 0){//�����ִ� ����� �����ϸ� ��� ����
			m += step;
			m %= list.size();//����Ʈ�� �������� �ݺ� ����
			result[resultIt++] = list.get(m);//���ŵ� ����� ���
			list.remove(m);//����� ����
		}
		
		//���
		System.out.print("<");
		System.out.print(result[0]);
		for(int i = 1; i < n; i++){
			System.out.print(", " + result[i]);
		}
		System.out.println(">");
	}
}
