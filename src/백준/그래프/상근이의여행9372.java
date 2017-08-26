//문제 출처 : https://www.acmicpc.net/problem/9372
//제목 : 상근이의여행9372

package 백준.그래프;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상근이의여행9372 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase; test++){
			int vSize = sc.nextInt() +1;
			int eSize = sc.nextInt();
			//경로 초기화
			ArrayList<Integer> edge[] = new ArrayList[vSize];//인덱스:시작정점, 값:도착정점
			for(int i = 1; i < vSize; i++)
				edge[i] = new ArrayList<Integer>();
			//경로 입력 및 연결
			for(int i = 0; i < eSize; i++){
				int start = sc.nextInt();
				int arrive = sc.nextInt();
				edge[start].add(arrive);
				edge[arrive].add(start);
			}
			
			//연결 그래프(정점간 이동경로는 하나만 선택) 검색
			Queue<Integer> qu = new LinkedList<Integer>();
			qu.add(1);
			int visitVertex[] = new int [vSize];//방문:1/ 미방문:0
			int airplaneNum = -1;
			while(!qu.isEmpty()){
				int end = qu.peek();
				qu.remove();
				if(visitVertex[end]  == 1)
					continue;
				visitVertex[end] = 1;//방문표시
				airplaneNum++;
				for(int i = 0; i < edge[end].size(); i++)
					qu.add(edge[end].get(i));//경로추가 
			}
			System.out.println(airplaneNum);
		}
	}
}
