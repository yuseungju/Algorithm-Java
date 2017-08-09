//문제 출처 : https://www.acmicpc.net/problem/1260
//제목 : DFS와BFS1260

package 백준.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class DFS와BFS1260 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//정점, 간선, 시작점 설정
		int n = sc.nextInt();//정점수
		int m = sc.nextInt();//간선수
		int start = sc.nextInt();//시작
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
			if(visit[startPoint] == 1)//방문한 지점이면
				 continue;
			visit[startPoint] = 1;//도착할 지점을 방문했다고 기록
			bfsResult.add(startPoint);
			for(int a=arr[startPoint].size()-1; 0 <= a; a--){
				endPoint = arr[startPoint].get(a);//도착지점의 번호
				if(visit[endPoint] != 1){//방문한적이 없으면
					st.add(endPoint);//도착할 지점의 번호를 시작지점으로 큐에 저장
				}
			}
		}
		//DFS로 방문한 순서대로 출력
		for(int a=0; a<bfsResult.size();a++)
			System.out.print(bfsResult.get(a) + " ");
		System.out.println();
		
		//1.BFS로 방문한 순서대로 출력
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
				endPoint = arr[startPoint].get(a);//도착지점의 번호
				if(visit[endPoint] != 1){//방문한적이 없으면
					que.add(endPoint);//도착할 지점의 번호를 시작지점으로 큐에 저장
					visit[endPoint] = 1;//도착할 지점을 방문했다고 기록
				}
			}
		}
		//방문순서대로  출력
		for(int a=0; a<bfsResult.size();a++)
			System.out.print(bfsResult.get(a) + " ");
		System.out.println();
	}
}
