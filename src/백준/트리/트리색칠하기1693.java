//���� ��ó : https://www.acmicpc.net/problem/1693
//���� : Ʈ����ĥ�ϱ�1693
//������ȹ, �Ϲ�Ʈ������

package ����.Ʈ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ʈ����ĥ�ϱ�1693 {
	public static int dp[][];
	public static ArrayList<Integer> branch[];
	public static int colorSize = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		colorSize = (int)((Math.log(n)/(Math.log(2))+1));
		dp = new int[n+1][colorSize+1];
		visitRoot = new int[n+1];
		//��Ʈ�� �ش�Ǵ� ������ �ǹ�
		branch =  new ArrayList[n+1];
		for(int i =0; i<= n; i++)
			branch[i] = new ArrayList<Integer>();

		//��� ������ ��������� ����, ����� = ������n + ��Ʈ1 = n+1
		branch[1].add(0);//1�� ��Ʈ�� ���� 1�� ���, ������n�� �����ϳ��� �߰�
		for(int i = 1; i <= n-1; i++){
			int root = sc.nextInt();
			int branchIndex = sc.nextInt();
			branch[branchIndex].add(root);
			branch[root].add(branchIndex);
		}
		//dpŽ�� (dfs)
		searchPostorder(1, 0);
		//��Ʈ���� ����ĥ�Ҷ��� ����Ǽ���,  �ּҰ��� ���
		Arrays.sort(dp[1]);
		System.out.println(dp[1][1]);
	}
	//���� Ž��
	public static int visitRoot[];
	public static void searchPostorder(int root, int beforeRoot){
		//�ߺ� ��� x
		if(visitRoot[root] == 1)//�̹� �湮�� �����̸�(�̹̹湮 �Ǵ� ��Ʈ���� �̸�)
			return;//���������� ����
		visitRoot[root] = 1;//��Ʈ �湮ǥ��
		
		//�������� ����� ��� ������
		if(branch[root].size() == 1){//������ �������������� �ʱⰪ����(���ἱ�� ��Ʈ�ۿ� �������)
			for(int rootColor = 1; rootColor <= colorSize; rootColor++)//��Ʈ�� �ɼ� �ִ� ���Ǽ���ŭ
				dp[root][rootColor] = rootColor;
			//System.out.println(root+":  "+ Arrays.toString(dp[root]));
			return;
		}
		
		//(��Ʈ�� ��ĥ�� + �������� ��ĥ��)�� �ּҸ� ����Ͽ� dp�� ����
		int branchValue;
		int min = 0;
		for(int rootColor = 1; rootColor <= colorSize; rootColor++){//��Ʈ�� �ɼ� �ִ� ���Ǽ���ŭ(dp[5][1], dp[5][2], dp[5][3]...)
			for(int i = 0; i < branch[root].size(); i++){//��Ʈ�� �����ϴ� ��������ŭ  
				branchValue = branch[root].get(i);//������ ���� ������
				if(beforeRoot == branchValue)//������ �ƴ϶� ��Ʈ�� �����̸�
					continue;//������ ����
				searchPostorder(branchValue, root);//������ dp���
				min = Integer.MAX_VALUE;
				for(int branchColor = 1; branchColor <= colorSize; branchColor++){//������ �ɼ� �ִ� ���� ����ŭ
					if(rootColor != branchColor){//��Ʈ�� ������ ���� ���δٸ���
						if(dp[branchValue][branchColor] < min)//������ ��Ʈ�� ���δٸ����϶� ������ �ּ� ���� ����
							min = dp[branchValue][branchColor];
					}
				}
				dp[root][rootColor] += min;//�ּҰ� �ɼ��ְ� ������������ ����
			}
			dp[root][rootColor]  += rootColor;
			//System.out.println(root+":  "+ Arrays.toString(dp[root]));
		}
	}
}





