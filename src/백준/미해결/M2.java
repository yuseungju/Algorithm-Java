package ����.���ذ�;

import java.util.Scanner;

public class M2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int allNum = sc.nextInt();
		int personNum = sc.nextInt();
		allNum%= personNum;
		if(allNum == 0){
			System.out.println(0);
			return;
		}
		
		//�� �ҽ����� ��� ����ŭ �������� ���� (ex: 3�� 4�� -> 12����)�Ͽ�  ������ ��� �Ҵ�
		double allCount = allNum*personNum;//���ҽ����� ��� ������
		double allocCount = allCount/personNum;//�ѻ������ �Ҵ�Ǵ� ������
		int currentIt = 0;//�Ҵ�ǰ� �ִ� �ҽ����� �ε���
		double currentPiece = personNum;//���� �ҽ��� ������ ����
		int result = 0;
		while(true){
			//�ѻ������ �Ҵ� ���ٶ� �� ����
			currentPiece -= allocCount;//���� �ҽ����� ������ �Ҵ��Ѹ�ŭ ����
			if(0 != currentPiece)//�ҽ����ϳ��� �Ϻ��ϰ� �Ҵ����� �������� (�߰��� ���� Į��)
				result++;
			if(currentIt == allNum-1 && currentPiece == 0)//�Ҵ�� ������ �ҽ����� �������� 
				break;
			if(currentPiece < allocCount){//���� �ҽ������� ���� ������ �ѻ������ �Ҵ�� ���� ���������� 
				currentPiece += personNum;//���� �ҽ����� �������� ��ħ
				currentIt++;//���� �ҽ����� ����Ŵ
			}
		}
		System.out.println(result);
	}
}
