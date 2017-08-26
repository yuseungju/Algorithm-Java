//���� ��ó : https://www.acmicpc.net/problem/1966
//���� : ������ť1966

package ����.ť;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������ť1966 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			Queue<Integer> qu = new LinkedList<Integer>();
			LinkedList<Integer> priorityList = new LinkedList<Integer>();
			
			int n = sc.nextInt();
			int targetIt = sc.nextInt();//����Ʈ�ؾ��� �μ⹰�� �ڸ�(0���� ����)
			for(int a=0; a<n; a++){
				//�μ⹰���� �߿䵵����(0���� ����)
				int importN = sc.nextInt();
				qu.add(importN);//�μ⹰���� �ڸ��� ���� �߿䵵�� ����
				priorityList.add(importN);//�߿䵵�� ���常��
			}
			Collections.sort(priorityList);
			Collections.reverse(priorityList);//����� ����ū �߿䵵���� ����
			
			int priorityIt = 0;
			int item;
			int priority;
			priority = priorityList.get(priorityIt++);//�μ�ɼ� �ִ� ������ �߿䵵�� �ϳ� ����
			while(true){
				item = qu.peek();//���� �μ⹰�� �߿䵵
				if(targetIt == 0 && priority == item){//Ÿ���� �μⰡ���ϸ�
					break;
				} else if(targetIt == 0){//Ÿ������������ �μ�Ұ��ɽ� ť�ǵڷ��̵�
					targetIt = qu.size(); 
					qu.add(item);
				} else if(priority != item){//�����Ұ� ó���Ҽ� �ִ� ��Ұ� �ƴϸ� �ڿ� �߰�(���߿� �ٽ�ó���ؾߵǹǷ�)
					qu.add(item);
				} else{ //ó���Ǹ�
					priority = priorityList.get(priorityIt++);//���� �μ⹰��ó��������  �߿䵵�� �������� �̵�
				}
				qu.remove();//üũ�� �� ����
				targetIt--;//��ǥ�� ��� �ε����� ť�� ������ ��ĭ �̵�
			}
			System.out.println(priorityIt);
		}
	}
}
