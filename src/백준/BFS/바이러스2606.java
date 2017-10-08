//���� ��ó : https://www.acmicpc.net/problem/2606
//���� : ���̷���2606

package ����.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ���̷���2606 {
	public static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vSize = sc.nextInt();
		int eSzie = sc.nextInt(); 
		boolean visit[]= new boolean[vSize+1];
		ArrayList<Integer> path[] =  new ArrayList[vSize+1];
		for(int  i = 0; i < path.length; i++)
			path[i] =  new ArrayList<Integer>();
		
		for(int i = 0; i < eSzie; i++){
			int v1 =  sc.nextInt(); 
			int v2 =  sc.nextInt();
			path[v1].add(v2);
			path[v2].add(v1);
		}
		Queue<Integer>  que = new LinkedList<Integer>();
		visit[1] = true;
		que.add(1);
		
		while(!que.isEmpty()){
			int curV = que.peek();
			que.remove();
		
			for(int i = 0; i < path[curV].size(); i++){
				if(!visit[path[curV].get(i)]){//�湮������ ������ �߰�
					que.add(path[curV].get(i));
					visit[path[curV].get(i)] = true;//�߰��ϸ鼭 �ٷ� �湮ǥ��
					result++;
				}
			}
		}
		System.out.println(result);
	}
}









