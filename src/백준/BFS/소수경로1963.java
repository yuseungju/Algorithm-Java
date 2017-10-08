//���� ��ó : https://www.acmicpc.net/problem/1963
//���� : �Ҽ����1963

package ����.BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �Ҽ����1963 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static int n;
	public static int m;
	public static boolean isNum(int  n){
		if(n == 1)
			return false;
		
		for(int a=0; a < list.size(); a++){//�˻��� ������ ���� ��(�Ҽ�)��� ������������ Ȯ��
			if(n%list.get(a) == 0)//����������
				return false;//�Ҽ����ƴ�
			if(list.get(a)* list.get(a) < a)//���������� ã�� ������ ũ�� ���̻� ���������� ���� ����(���� ���� �� ũ�Ե�)
				break;
		}
		list.add(n);
		return true;//�Ҽ���
	}
	public static boolean visit[];
	public static boolean possible[];
	public static void main(String[] args) {
		//�Ҽ� ���ɼ��� ����
		possible = new boolean[10000];
		for(int a=1; a<10000; a++)
			isNum(a);
		for(int i = 0; i < list.size(); i++){
			if(1000 <= list.get(i))
				possible[list.get(i)] = true;
		}
		
		int testcase =  sc.nextInt();
		for(int test = 0; test < testcase; test++){
			visit = new boolean[10000];
			n = sc.nextInt();//�ʱ� �Ҽ�
			m = sc.nextInt();//��ǥ �Ҽ�
			Queue<String> que = new LinkedList<String>();
			Queue<Integer> dept = new LinkedList<Integer>();
			//�Ҽ� ó������ ���������� �߰�, ����ó��(dept)�� 0
			dept.add(0);
			visit[n] = true;
			que.add(String.valueOf(n));
			int curDept = 0;
			
			while(!que.isEmpty()){
				//Ž���� �Ҽ��� Ž���� �Ҽ��� �������� ������� ������
				String num = que.peek();
				que.remove();
				curDept = dept.peek();//�����
				dept.remove();
				//�����̸� ����ϰ� ����
				if(num.equals(String.valueOf(m))){
					System.out.println(curDept);
					break;
				}
				//���� ���ʰ� �ɼ� �ִ� �Ҽ����� ��츦 ��α���
				for(int i = 0; i <= 9; i++){//��ü�� �ڸ��� ���� 0~9���� ����
					//���ڸ��� ���� �����Ͽ� Ž��
					String n1 = i + num.substring(1,4);
					String n2 = num.substring(0,1) + i + num.substring(2,4);
					String n3 = num.substring(0,2) + i + num.substring(3,4);
					String n4 = num.substring(0,3) + i;
					
					//�Ҽ��̸鼭 Ž�������� ���ٸ� Ž���� ������ �߰�
					if(!visit[Integer.parseInt(n1)] && possible[Integer.parseInt(n1)]){
						visit[Integer.parseInt(n1)] = true;
						que.add(n1);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n2)]&& possible[Integer.parseInt(n2)]){
						visit[Integer.parseInt(n2)] = true;
						que.add(n2);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n3)]&& possible[Integer.parseInt(n3)]){
						visit[Integer.parseInt(n3)] = true;
						que.add(n3);
						dept.add( curDept + 1);
					}
					if(!visit[Integer.parseInt(n4)]&& possible[Integer.parseInt(n4)]){
						visit[Integer.parseInt(n4)] = true;
						que.add(n4);
						dept.add( curDept + 1);
					}
				}
				
			}
		}
	}
}

