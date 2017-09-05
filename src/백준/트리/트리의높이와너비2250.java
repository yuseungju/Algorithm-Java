//���� ��ó : https://www.acmicpc.net/problem/2250
//���� : Ʈ���ǳ��̿ͳʺ�2250
//���� Ʈ��

package ����.Ʈ��;
import java.util.Scanner;

public class Ʈ���ǳ��̿ͳʺ�2250 {
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
		int branchArr[] = new int[nodeSize+1];//������ 1, ��Ʈ�� 0
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
		//Ʈ���� �ֻ��� ��Ʈ�� ã��
		int upperRoot = 0;
		for(int i = 1; i <= nodeSize; i++){
			if(branchArr[i] == 0)
				upperRoot = i;
		}
		//System.out.println(upperRoot);
		
		//Ʈ���� ������ �ֿ���, �������� ��ġ�� �ε����� �ǹ�
		rightOfLevel = new int[nodeSize+1];
		leftOfLevel = new int[nodeSize+1];
		//�ֻ�����Ʈ���� �����ؼ� Ʈ��-����Ž������ ������ ������ �ֿ����� �ε����� ����
		
		dfs(upperRoot, 1);
		//System.out.println(Arrays.toString(rightOfLevel));
		//System.out.println(Arrays.toString(leftOfLevel));
		
		//�� ���� �ʺ��� ���� ����ū �ʺ��� ����
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
		if(index == -1 )//���� ������ �������� ������ ���̻� Ž��x
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

