//���� ��ó : https://www.acmicpc.net/problem/1260
//���� : DFS��BFS1260

package ����.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class DFS��BFS1260 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//����, ����, ������ ����
		int n = sc.nextInt();//������
		int m = sc.nextInt();//������
		int start = sc.nextInt();//����
		List<Integer> arr[] = new ArrayList[n+1];
		int visit[];
		for(int a=1; a< arr.length; a++)
			arr[a] = new ArrayList<Integer>();
		ArrayList<Integer> bfsResult;
		
		int v1, v2;
		for(int a=1; a<=m; a++){
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			arr[v1].add(v2);
			arr[v2].add(v1);
		}
		for(int a=1; a<=n; a++)
	        Collections.sort(arr[a]);
		
		//2.DFS
		Stack<Integer> st = new Stack<Integer>();
		int startPoint = start;
		int endPoint;
		st.add(startPoint);
		visit = new int[n+1];
		bfsResult = new ArrayList<Integer>();
		while(0 < st.size()){
			startPoint = st.peek();
			st.pop();
			if(visit[startPoint] == 1)//�湮�� �����̸�
				 continue;
			visit[startPoint] = 1;//������ ������ �湮�ߴٰ� ���
			bfsResult.add(startPoint);
			for(int a=arr[startPoint].size()-1; 0 <= a; a--){
				endPoint = arr[startPoint].get(a);//���������� ��ȣ
				if(visit[endPoint] != 1){//�湮������ ������
					st.add(endPoint);//������ ������ ��ȣ�� ������������ ť�� ����
				}
			}
		}
		//DFS�� �湮�� ������� ���
		for(int a=0; a<bfsResult.size();a++)
			System.out.print(bfsResult.get(a) + " ");
		System.out.println();
		
		//1.BFS�� �湮�� ������� ���
		Queue<Integer> que = new LinkedList<Integer>();
		startPoint = start;
		que.add(startPoint);
		visit = new int[n+1];
		visit[startPoint] = 1;
		bfsResult = new ArrayList<Integer>();
		while(0 < que.size()){
			startPoint = que.peek();
			que.remove();
			bfsResult.add(startPoint);
			for(int a=0; a< arr[startPoint].size(); a++){
				endPoint = arr[startPoint].get(a);//���������� ��ȣ
				if(visit[endPoint] != 1){//�湮������ ������
					que.add(endPoint);//������ ������ ��ȣ�� ������������ ť�� ����
					visit[endPoint] = 1;//������ ������ �湮�ߴٰ� ���
				}
			}
		}
		//�湮�������  ���
		for(int a=0; a<bfsResult.size();a++)
			System.out.print(bfsResult.get(a) + " ");
		System.out.println();
	}
}
