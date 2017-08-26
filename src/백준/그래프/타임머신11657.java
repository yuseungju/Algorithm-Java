//���� ��ó : https://www.acmicpc.net/problem/11657
//���� : Ÿ�Ӹӽ�11657
//����-���� �˰���(���ǰ���ġ)

package ����.�׷���;
import java.util.ArrayList;
import java.util.Scanner;

public class Ÿ�Ӹӽ�11657 {
	public static void main(String[] args) {
		//�Է�
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
		
		//����̵��� �Һ�ð� ����
		for(int i = 0; i < eSize; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			if(weight < pathWeight[start][end])
				pathWeight[start][end] = weight;
			edge[start].add(end);
		}
		//���������κ��� ���������� �ּҺ���� ���� 
		for (int n = 1; n < vSize; n++) {
			for (int start = 1; start < vSize; start++) {
				for (int j = 0; j <  edge[start].size(); j++) {
					int arrive =  edge[start].get(j);
					if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
						weightFromStart[arrive] =  weightFromStart[start] +  pathWeight[start][arrive];
				}
			}
		}   
		//�ּҺ�� ��� �����Ŀ��� ��������� ����Ǵ� ������ ����Ŭ���� -> -���� ó�� 
		for (int n = 1; n < vSize; n++) {
			for (int start = 1; start < vSize; start++) {
				for (int j = 0; j <  edge[start].size(); j++) {
					int arrive =  edge[start].get(j);
					if((long)weightFromStart[start] +  pathWeight[start][arrive] < weightFromStart[arrive])
						weightFromStart[arrive] =  Integer.MIN_VALUE;
				}
			}
		}   
		//-���� : ����Ŭ, +���� : ��ε��� x, �� �� : �ּҺ���� ����
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







