//���� ��ó : https://www.acmicpc.net/problem/1107
//���� : ������1107


package ����.DP;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������1107 {
	public static boolean possible[];
	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		int goalNum = sc.nextInt();
		int impossibleSize = sc.nextInt();
		possible = new boolean[10];
		for(int i = 0; i < 10; i++)
			possible[i] = true;
		for(int i = 0; i < impossibleSize; i++)
			possible[sc.nextInt()] = false;
		setDirectNumList();
		
		//������ ä�ι�ȣ�� ������
		int recentNum = getRecent(goalNum);
		
		//������ ä�ι�ȣ�� ���������ϴ� ��İ� ������ +- �� �����̵��ϴ� ����� �ּҰ��� ����
		int min = String.valueOf(recentNum).length() + Math.abs(goalNum - recentNum);
		if(Math.abs(goalNum-100) < min)
			min = Math.abs(goalNum-100);
		
		//���
		System.out.println(min);
	}
	//������ ��ȣ�� ���� �����Ҽ��ִ� ä���� �����Ѵ�.
	public static ArrayList<Integer> possibleList = new ArrayList<Integer>();//�ѹ��� �������ִ� ä�ι�ȣ
	public static void setDirectNumList(){
		Queue<Integer> que = new LinkedList<Integer>();
		for(int len = 1; len <= 6; len++){
			if(len == 1){
				for(int n = 0; n < 10; n++){
					if(possible[n]){
						que.add(n);
						possibleList.add(n);
					}
				}
			}else{
				int size = que.size();
				for(int i = 0; i < size; i++){
					int item = que.peek();
					que.remove();
					for(int n = 0; n < 10; n++){
						if(item != 0){
							if(possible[n]){
								que.add(item*10 + n);
								possibleList.add(item*10 + n);
							}
						}
					}
				}
			}
		}
	}
	//���� �����ϴ� ä���� ��ȣ�� ��´�.
	public static int getRecent(int goalNum){
		int recentNum = Integer.MAX_VALUE/2;
		int minIt = -1;
		for(int i = 0; i < possibleList.size(); i++){
			if(Math.abs(possibleList.get(i) - goalNum) < recentNum){
				recentNum = Math.abs(possibleList.get(i) - goalNum);
				minIt = i;
			}
		}
		if(minIt == -1)
			return Integer.MAX_VALUE/2;
		else
			return possibleList.get(minIt);
	}
}
