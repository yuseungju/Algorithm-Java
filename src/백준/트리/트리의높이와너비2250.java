//문제 출처 : https://www.acmicpc.net/problem/2250
//제목 : 트리의높이와너비2250
//이진 트리

package 백준.트리;
import java.util.Scanner;

public class 트리의높이와너비2250 {
	public static int up[];
	public static int lDown[];
	public static int rDown[];
	public static int nodeSize;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nodeSize = sc.nextInt();
		up = new int[nodeSize+1];
		lDown = new int[nodeSize+1];
		rDown = new int[nodeSize+1];

		int root;
		int branch1;
		int branch2;
		int branchArr[] = new int[nodeSize+1];//가지는 1, 루트는 0
		for(int i = 1; i <= nodeSize; i++){
			root = sc.nextInt();
			branch1 = sc.nextInt();
			branch2 = sc.nextInt();
			if(branch1 != -1)
				branchArr[branch1] = 1;
			if(branch2 != -1)
				branchArr[branch2] = 1;
			
			lDown[root] = branch1;
			rDown[root] = branch2;
		}
		//트리의 최상위 루트를 찾음
		int upperRoot = 0;
		for(int i = 1; i <= nodeSize; i++){
			if(branchArr[i] == 0)
				upperRoot = i;
		}
		//System.out.println(upperRoot);
		
		//트리의 층마다 최우측, 최좌측에 위치한 인덱스를 의미
		rightOfLevel = new int[nodeSize+1];
		leftOfLevel = new int[nodeSize+1];
		//최상위루트에서 시작해서 트리-중위탐색으로 각층별 최좌측 최우측의 인덱스를 구함
		
		dfs(upperRoot, 1);
		//System.out.println(Arrays.toString(rightOfLevel));
		//System.out.println(Arrays.toString(leftOfLevel));
		
		//각 층별 너비의 값중 가장큰 너비값을 구함
		int maxWidth = Integer.MIN_VALUE;
		int maxDept  = 1;
		for(int i = 1; i <= allDept; i++){
			if(maxWidth < rightOfLevel[i] - leftOfLevel[i] + 1){
				maxWidth = rightOfLevel[i] - leftOfLevel[i] + 1;
				maxDept = i;
			}
		}
		System.out.println(maxDept);
		System.out.println(maxWidth);
	}
	public static int leftOfLevel[];
	public static int rightOfLevel[];
	public static int allDept = 1;
	public static int count  = 1;
	public static void dfs(int index, int dept){
		if(index == -1 )//다음 가지가 존재하지 않으면 더이상 탐색x
			return;
		dfs(lDown[index], dept+1);
		if(count < leftOfLevel[dept] || leftOfLevel[dept] == 0)
			leftOfLevel[dept] = count;
		if(rightOfLevel[dept] < count || rightOfLevel[dept] == 0)
			rightOfLevel[dept] = count;
		if(allDept < dept)
			allDept = dept;
		count++;
		dfs(rDown[index], dept+1);
	}
}

