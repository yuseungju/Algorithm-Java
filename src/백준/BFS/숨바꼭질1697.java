//문제 출처 : https://www.acmicpc.net/problem/1697
//제목 : 숨바꼭질1697

package 백준.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 숨바꼭질1697 {
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int visit[] = new int[100001];
		Queue<Integer> q =  new LinkedList<Integer>();
		Queue<Integer> deptNum =  new LinkedList<Integer>();
		q.add(n);
		deptNum.add(0);
		visit[n] = 1;
		int currentDept = 0;
		while(n!=k){
			n = q.peek();
			q.remove();
			currentDept = deptNum.peek();
			deptNum.remove();
			if(n == k)
				break;
			if(n+1 <= 100000){
				if(visit[n+1] == 0){
					q.add(n+1);
					deptNum.add(currentDept+1);
					visit[n+1] = 1;
				}
			}
			if(0 <= n-1){
				if(visit[n-1] == 0){
				q.add(n-1);
				deptNum.add(currentDept+1);
				visit[n-1] = 1;
				}
			}
			if(n*2 <= 100000){
				if(visit[n*2] == 0){
					q.add(n*2);
					deptNum.add(currentDept+1);
					visit[n*2] = 1;
				}
			}
		}
		System.out.println(currentDept);
	}
}
