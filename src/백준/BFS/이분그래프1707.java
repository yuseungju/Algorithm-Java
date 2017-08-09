//���� ��ó : https://www.acmicpc.net/problem/1707
//���� : �̺б׷���1707

package ����.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �̺б׷���1707 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int test =  sc.nextInt();
		for(int t=0; t<test; t++){
			boolean result = true;
			int vNum = sc.nextInt();
			int pNum = sc.nextInt();
			ArrayList<Integer> path[] = new ArrayList[vNum+1];
			for(int a=1; a< path.length; a++)
				path[a] = new ArrayList<Integer>();
			int visit[] = new int[vNum+1];//1�ι湮 , 2�ι湮, 0:�湮��������
			int v1 = 0,v2 = 0;
			Queue<Integer> que= new LinkedList<Integer>();
			Queue<Integer> dept= new LinkedList<Integer>();
			for(int i = 1;  i <= pNum; i++){
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				path[v1].add(v2);
				path[v2].add(v1);
			}
			que.add(v1);
			int deptNum = 1;
			dept.add(deptNum);
			visit[v1] = deptNum%2;
			int area = 0;
			while(0 < que.size()){
				//ã�� ����� �� �ϳ��� ������
				int start =  que.peek();
				deptNum = dept.peek();
				que.remove();
				dept.remove();
				area = deptNum%2 + 1;
				int end;
				for(int a=0; a< path[start].size(); a++){
					end = path[start].get(a);//���������� ��ȣ
					if(visit[end] == 0){//�湮������ ������
						que.add(end);
						dept.add(deptNum+1);
						visit[end] = area;
					}else if(visit[end] != area){
						result = false;
						que.clear();
						dept.clear();
						break;
					}
				}
			}
			if(result)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
}
