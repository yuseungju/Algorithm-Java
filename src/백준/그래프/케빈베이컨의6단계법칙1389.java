//���� ��ó : https://www.acmicpc.net/problem/1389
//���� : �ɺ�������6�ܰ��Ģ1389
//�÷��̵���� �˰���

package ����.�׷���;

import java.util.Arrays;
import java.util.Scanner;

public class �ɺ�������6�ܰ��Ģ1389 {
	
	public static void main(String[] args) {
		//�ʱ�ȭ �� �Է�
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); 
		int e = sc.nextInt();
		int weight[][] = new int[v+1][v+1];
		for(int i = 1; i <= v; i++){
			for(int j = 1; j <= v; j++){
				if(i == j)
					weight[i][j]=0;
				else
					weight[i][j] = 100;
			}
		}
		for(int i = 1; i <= e; i++){
			int start,end;
			start = sc.nextInt();
			end = sc.nextInt();
			weight[end][start] = weight[start][end] = 1;
		}

		//���ΰ��� �ɺ������� ���
		for(int mid=1; mid<=v; mid++){
			for(int start=1; start<=v; start++){
				for(int end=1; end<=v; end++){
					if(weight[start][mid] + weight[mid][end] < weight[start][end])
						weight[start][end] = weight[start][mid] + weight[mid][end];
				}
			}
		}
		
		//��������� �ɺ����� �� ���
		int result[] = new int[v+1];
		for(int man = 1; man <=v; man++){
			for(int i=1; i<=v; i++)
				result[man] += weight[man][i];
		}
		
		//�ɺ������� �ּ��� ����� ����
		int min = Integer.MAX_VALUE;
		int minIt = -1;
		for(int i=1; i<=v; i++){
			if(result[i] < min){
				min = result[i];
				minIt = i;
			}
		}
		System.out.println(minIt);
	}
}
