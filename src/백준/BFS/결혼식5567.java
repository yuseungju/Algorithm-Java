package 백준.BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 결혼식5567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt() + 1;
		int e = sc.nextInt();
		ArrayList<Integer>[] connection = new ArrayList[v];
		for(int i = 0; i < v; i++)
			connection[i] = new ArrayList<Integer>();
		
		//친구관계 설정
		for(int i = 0; i < e; i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			connection[v1].add(v2);
			connection[v2].add(v1);
		}
		
		//친구관계 검색
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
			if(2 < currentDept || checked[man])//현재 탐색위치가 친구의 친구관계이면 , 또는 이미 고려한 친구이면
				continue;//그 다음의친구관계 검색 x
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
