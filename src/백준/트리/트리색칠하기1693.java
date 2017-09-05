//문제 출처 : https://www.acmicpc.net/problem/1693
//제목 : 트리색칠하기1693
//동적계획, 일반트리구조

package 백준.트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 트리색칠하기1693 {
	public static int dp[][];
	public static ArrayList<Integer> branch[];
	public static int colorSize = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		colorSize = (int)((Math.log(n)/(Math.log(2))+1));
		dp = new int[n+1][colorSize+1];
		visitRoot = new int[n+1];
		//루트에 해당되는 가지를 의미
		branch =  new ArrayList[n+1];
		for(int i =0; i<= n; i++)
			branch[i] = new ArrayList<Integer>();

		//모든 연결은 양방향으로 설정, 연결수 = 가지수n + 루트1 = n+1
		branch[1].add(0);//1을 루트로 보고 1인 경우, 가지수n에 연결하나를 추가
		for(int i = 1; i <= n-1; i++){
			int root = sc.nextInt();
			int branchIndex = sc.nextInt();
			branch[branchIndex].add(root);
			branch[root].add(branchIndex);
		}
		//dp탐색 (dfs)
		searchPostorder(1, 0);
		//루트에서 색을칠할때의 경우의수중,  최소값을 출력
		Arrays.sort(dp[1]);
		System.out.println(dp[1][1]);
	}
	//후위 탐색
	public static int visitRoot[];
	public static void searchPostorder(int root, int beforeRoot){
		//중복 고려 x
		if(visitRoot[root] == 1)//이미 방문한 연결이면(이미방문 또는 루트연결 이면)
			return;//다음연결을 조사
		visitRoot[root] = 1;//루트 방문표시
		
		//가장하위 노드의 경우 값설정
		if(branch[root].size() == 1){//가지가 존재하지않으면 초기값설정(연결선이 루트밖에 존재안함)
			for(int rootColor = 1; rootColor <= colorSize; rootColor++)//루트가 될수 있는 색의수만큼
				dp[root][rootColor] = rootColor;
			//System.out.println(root+":  "+ Arrays.toString(dp[root]));
			return;
		}
		
		//(루트의 색칠수 + 가지들의 색칠수)의 최소를 고려하여 dp에 저장
		int branchValue;
		int min = 0;
		for(int rootColor = 1; rootColor <= colorSize; rootColor++){//루트가 될수 있는 색의수만큼(dp[5][1], dp[5][2], dp[5][3]...)
			for(int i = 0; i < branch[root].size(); i++){//루트에 존재하는 가지수만큼  
				branchValue = branch[root].get(i);//가지의 값을 가져옴
				if(beforeRoot == branchValue)//가지가 아니라 루트의 연결이면
					continue;//고려대상 제외
				searchPostorder(branchValue, root);//가지의 dp계산
				min = Integer.MAX_VALUE;
				for(int branchColor = 1; branchColor <= colorSize; branchColor++){//가지가 될수 있는 색의 수만큼
					if(rootColor != branchColor){//루트와 가지의 색이 서로다르면
						if(dp[branchValue][branchColor] < min)//가지와 루트가 서로다른색일때 가능한 최소 값을 구함
							min = dp[branchValue][branchColor];
					}
				}
				dp[root][rootColor] += min;//최소가 될수있게 정해진값으로 설정
			}
			dp[root][rootColor]  += rootColor;
			//System.out.println(root+":  "+ Arrays.toString(dp[root]));
		}
	}
}





