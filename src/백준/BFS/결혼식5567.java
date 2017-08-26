package ����.BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ��ȥ��5567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt() + 1;
		int e = sc.nextInt();
		ArrayList<Integer>[] connection = new ArrayList[v];
		for(int i = 0; i < v; i++)
			connection[i] = new ArrayList<Integer>();
		
		//ģ������ ����
		for(int i = 0; i < e; i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			connection[v1].add(v2);
			connection[v2].add(v1);
		}
		
		//ģ������ �˻�
		Queue<Integer> q =  new LinkedList<Integer>();
		Queue<Integer> dept =  new LinkedList<Integer>();
		q.add(1);
		dept.add(0);
		boolean checked[] = new boolean[v];
		int cnt = -1;
		while(!q.isEmpty()){
			int man = q.peek();
			int currentDept = dept.peek();
			q.remove(); dept.remove();
			if(2 < currentDept || checked[man])//���� Ž����ġ�� ģ���� ģ�������̸� , �Ǵ� �̹� ����� ģ���̸�
				continue;//�� ������ģ������ �˻� x
			checked[man] = true;
			cnt ++;
			for(int i=0; i<connection[man].size(); i++){
				if(!checked[connection[man].get(i)]){
					q.add(connection[man].get(i));
					dept.add(currentDept + 1);
				}
			}
		}
		System.out.println(cnt);
	}
}
