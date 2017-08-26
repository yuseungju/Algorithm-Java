//문제 출처 : https://www.acmicpc.net/problem/1865
//제목 : 웜홀1865
//벨먼-포드 알고리즘(음의가중치)

package 백준.그래프;
import java.util.ArrayList;
import java.util.Scanner;

public class 웜홀1865 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 0; test < testcase;  test++){
			int vSize = sc.nextInt() + 1;
			int eSize = sc.nextInt();
			int wSize = sc.nextInt();
			ArrayList<Integer> edge[] = new ArrayList[vSize];
			int pathWeight[][] = new int[vSize][vSize];
			int weightFromAnyPoint[] = new int[vSize];
			for(int i =1 ; i< vSize; i++){
				weightFromAnyPoint[i] =  Integer.MAX_VALUE;
				for(int j=0; j<vSize; j++)
					pathWeight[i][j] =Integer.MAX_VALUE;
			}
			for(int i = 1; i < vSize; i++)
				edge[i] = new ArrayList<Integer>();
			
			//경로이동시 소비시간 설정
			for(int i = 0; i < eSize; i++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				int weight = sc.nextInt();
				if(weight < pathWeight[start][end]){
					pathWeight[start][end] = weight;
					edge[start].add(end);
				}
				if(weight < pathWeight[end][start]){
					pathWeight[end][start] = weight;
					edge[end].add(start);
				}
			}
			//경로이동시 소비시간 설정
			for(int i = 0; i < wSize; i++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				int weight = sc.nextInt()*-1;
				if(weight < pathWeight[start][end]){
					pathWeight[start][end] = weight;
					edge[start].add(end);
				}
			}
	
			for (int n = 1; n < vSize; n++) {
				for (int start = 1; start < vSize; start++) {
					for (int j = 0; j <  edge[start].size(); j++) {
						int arrive =  edge[start].get(j);
						if((long)weightFromAnyPoint[start] +  pathWeight[start][arrive] < weightFromAnyPoint[arrive])
							weightFromAnyPoint[arrive] =  weightFromAnyPoint[start] +  pathWeight[start][arrive];
					}
				}
			}   
			String str = "NO";
			for (int n = 1; n < vSize; n++) {
				for (int start = 1; start < vSize; start++) {
					for (int j = 0; j <  edge[start].size(); j++) {
						int arrive =  edge[start].get(j);
						if((long)weightFromAnyPoint[start] +  pathWeight[start][arrive] < weightFromAnyPoint[arrive])
							str="YES";
					}
				}
			}   
			System.out.println(str);
		}
	}
}







