//문제 출처 : https://www.acmicpc.net/problem/1389
//제목 : 케빈베이컨의6단계법칙1389
//플로이드워셜 알고리즘

package 백준.그래프;

import java.util.Arrays;
import java.util.Scanner;

public class 케빈베이컨의6단계법칙1389 {
	
	public static void main(String[] args) {
		//초기화 및 입력
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); 
		int e = sc.nextInt();
		int weight[][] = new int[v+1][v+1];
		for(int i = 1; i <= v; i++){
			for(int j = 1; j <= v; j++){
				if(i == j)
					weight[i][j]=0;
				else
					weight[i][j] = 100;
			}
		}
		for(int i = 1; i <= e; i++){
			int start,end;
			start = sc.nextInt();
			end = sc.nextInt();
			weight[end][start] = weight[start][end] = 1;
		}

		//서로간의 케빈베이컨수 계산
		for(int mid=1; mid<=v; mid++){
			for(int start=1; start<=v; start++){
				for(int end=1; end<=v; end++){
					if(weight[start][mid] + weight[mid][end] < weight[start][end])
						weight[start][end] = weight[start][mid] + weight[mid][end];
				}
			}
		}
		
		//사람마다의 케빈베이컨 수 계산
		int result[] = new int[v+1];
		for(int man = 1; man <=v; man++){
			for(int i=1; i<=v; i++)
				result[man] += weight[man][i];
		}
		
		//케빈베이컨수 최소인 사람을 선택
		int min = Integer.MAX_VALUE;
		int minIt = -1;
		for(int i=1; i<=v; i++){
			if(result[i] < min){
				min = result[i];
				minIt = i;
			}
		}
		System.out.println(minIt);
	}
}
