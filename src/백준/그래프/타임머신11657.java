//문제 출처 : https://www.acmicpc.net/problem/11657
//제목 : 타임머신11657
//벨먼-포드 알고리즘(음의가중치)

package 백준.그래프;
import java.util.ArrayList;
import java.util.Scanner;

public class 타임머신11657 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int vSize = sc.nextInt() + 1;
		int eSize = sc.nextInt();
		ArrayList<Integer> edge[] = new ArrayList[vSize];
		int pathWeight[][] = new int[vSize][vSize];
		int weightFromStart[] = new int[vSize];
		for(int i =1 ; i< vSize; i++){
			weightFromStart[i] =  Integer.MAX_VALUE;
			if(i == 1)
				weightFromStart[i] = 0;
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
			if(weight < pathWeight[start][end])
				pathWeight[start][end] = weight;
			edge[start].add(end);
		}
		//시작점으로부터 각지점간의 최소비용을 설정 
		for (int n = 1; n < vSize; n++) {
			for (int start = 1; start < vSize; start++) {
				for (int j = 0; j <  edge[start].size(); j++) {
					int arrive =  edge[start].get(j);
					if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
						weightFromStart[arrive] =  weightFromStart[start] +  pathWeight[start][arrive];
				}
			}
		}   
		//최소비용 모두 설정후에도 계속적으로 적용되는 지점은 사이클형성 -> -무한 처리 
		for (int n = 1; n < vSize; n++) {
			for (int start = 1; start < vSize; start++) {
				for (int j = 0; j <  edge[start].size(); j++) {
					int arrive =  edge[start].get(j);
					if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
						weightFromStart[arrive] =  Integer.MIN_VALUE;
				}
			}
		}   
		//-무한 : 사이클, +무한 : 경로도달 x, 그 외 : 최소비용이 존재
		String result ="";
		int resultNum = 0;
		for(int i = 2;  i < vSize; i++){
			if(weightFromStart[i] == Integer.MAX_VALUE || weightFromStart[i] == Integer.MIN_VALUE){
				result+= "-1\n";
			}else{
				result+= weightFromStart[i] +"\n";
				resultNum++;
			}
		}
		if(resultNum == 0)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}







