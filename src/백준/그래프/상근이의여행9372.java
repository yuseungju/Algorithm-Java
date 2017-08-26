//���� ��ó : https://www.acmicpc.net/problem/9372
//���� : ������ǿ���9372

package ����.�׷���;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������ǿ���9372 {
	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			int vSize = sc.nextInt() +1;
			int eSize = sc.nextInt();
			//��� �ʱ�ȭ
			ArrayList<Integer> edge[] = new ArrayList[vSize];//�ε���:��������, ��:��������
			for(int i = 1; i < vSize; i++)
				edge[i] = new ArrayList<Integer>();
			//��� �Է� �� ����
			for(int i = 0; i < eSize; i++){
				int start = sc.nextInt();
				int arrive = sc.nextInt();
				edge[start].add(arrive);
				edge[arrive].add(start);
			}
			
			//���� �׷���(������ �̵���δ� �ϳ��� ����) �˻�
			Queue<Integer> qu = new LinkedList<Integer>();
			qu.add(1);
			int visitVertex[] = new int [vSize];//�湮:1/ �̹湮:0
			int airplaneNum = -1;
			while(!qu.isEmpty()){
				int end = qu.peek();
				qu.remove();
				if(visitVertex[end]  == 1)
					continue;
				visitVertex[end] = 1;//�湮ǥ��
				airplaneNum++;
				for(int i = 0; i < edge[end].size(); i++)
					qu.add(edge[end].get(i));//����߰� 
			}
			System.out.println(airplaneNum);
		}
	}
}
