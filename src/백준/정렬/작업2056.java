//���� ��ó : https://www.acmicpc.net/problem/2056
//���� : �۾�2056
//��������

package ����.����;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �۾�2056 {
	static class Work{
		int time; 
		int vNum;
		public Work(int vNum , int time) {
			super();
			this.time = time;
			this.vNum = vNum;
		}
		@Override
		public String toString() {
			return  vNum+ "�� :" +time ;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int visitCount[] = new int[n];
		int time[] = new int[n];
		ArrayList<Integer> startPath[] = new ArrayList[n];
		for(int i= 0; i < n; i++)
			startPath[i] = new ArrayList<Integer>();
		for(int arrive = 0; arrive < n; arrive++){
			time[arrive] = sc.nextInt();//�ش� ���������� �ҿ� �ð� ����
			int numPrev = sc.nextInt(); //�������������� �������� �����Է�
			visitCount[arrive] = numPrev;//����Ǿ�� �ϴ� ����� �� ����
			//������� -> �������� ��� ���� 
			for(int j =0; j <  numPrev; j++){
				int start = sc.nextInt()-1;//���� �ε��� 1->0 ���� ���� 
				startPath[start].add(arrive);
				
			}
		}
		
		ArrayList<Work> possibleStart = new ArrayList<Work>();
		
		for(int i = 0; i < visitCount.length; i++){
			if(visitCount[i] == 0)
				possibleStart.add(new Work(i, time[i]));
		}
		int result = Integer.MIN_VALUE;
		while(!possibleStart.isEmpty()){
			//������ ������ ���� (�������� �ּҽð��� ������)
			int minIt = 0;
			int minValue = Integer.MAX_VALUE;
			for(int i = 0; i < possibleStart.size();i++){
				if(possibleStart.get(i).time < minValue){
					minValue = possibleStart.get(i).time;
					minIt = i;
				} 
			}
			int selectV = possibleStart.get(minIt).vNum;
			int selectTime = possibleStart.get(minIt).time;
			possibleStart.remove(minIt);//�����ϸ� ���� 
			if(result < selectTime)
				result = selectTime;
			//System.out.println(selectV);
			//�̵� ������ ������ ���� �������� 1����
			for(int i = 0; i < startPath[selectV].size(); i++){
				visitCount[startPath[selectV].get(i)] --;//���������� ����
				if(visitCount[startPath[selectV].get(i)] == 0){//������ ������ ���̻������
					int nextV = startPath[selectV].get(i);
					int nextTime = selectTime + time[nextV];
					possibleStart.add(new Work(nextV, nextTime));//���డ�� ��������� �߰�
				}
			}
		}
		System.out.println(result);
	}
}
