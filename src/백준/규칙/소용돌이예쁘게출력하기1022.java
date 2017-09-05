//���� ��ó : https://www.acmicpc.net/problem/1022
//���� : �ҿ뵹�̿��ڰ�����ϱ�1022

package ����.��Ģ;

import java.util.Scanner;

public class �ҿ뵹�̿��ڰ�����ϱ�1022 {
	public static void main(String[] args) {
		//����� ��ǥ ���� �Է�
		Scanner sc = new Scanner(System.in);
		int y1 =  sc.nextInt(); 
		int x1 =  sc.nextInt(); 
		int y2 =  sc.nextInt(); 
		int x2 =  sc.nextInt(); 
		
		//���� ����� ���ϱ����� ���� ū ��ǥ�� ����
		int max;
		max = Math.max(Math.abs(y1), Math.abs(y2));
		max = Math.max(max, Math.abs(x1));
		max = Math.max(max, Math.abs(x2));
		
		//��ǥ�� ����
		int width = max*2+1;
		int height = max*2+1;
		y1 += height/2;
		x1 += width/2;
		y2 += height/2;
		x2 += width/2;
		int boardPart[][] = new int[y2 - y1 + 1][x2 - x1 + 1];
		
		//��ǥ���� ��Ģ�� �°� ä��
		//��Ģ: ��,��,��,��,��  1,1,2,2,2      1,3,4,4,4    1,5,6,6,6   
		int currentX = width/2;
		int currentY = height/2;
		int increase[] = {1,1,2,2,2};
		if(currentY <= y2 && y1 <= currentY && currentX <= x2 && x1 <= currentX)
			boardPart[currentY-y1][currentX-x1] = 1;
		
		//��ü���带 ����ذ��鼭, ��������� ��� ����迭�� ä��
		int place = 0;
		for(int circleIt = 2; circleIt <= height*width;){
			//�ѹ���(�ټ�����)�� ä��
			for(int pos = 0;  pos < 5;  pos++){
				//�ѹ����� ä��
				for(int i = 0; i < increase[pos]; i++){
					if(pos == 0)//������ �������̸�
						currentX++;
					else if(pos == 1)//������ �����̸�
						currentY--;
					else if(pos == 2)//������ ���̸�
						currentX--;
					else if(pos == 3)//������ �Ʒ����̸�
						currentY++;
					else if(pos == 4)//������ �������̸�
						currentX++;
					//��������̸� ���ں���
					if(currentY <= y2 && y1 <= currentY && currentX <= x2 && x1 <= currentX){
						boardPart[currentY-y1][currentX-x1] = circleIt;
						if(place < (int) Math.log10(circleIt)+1)
							place = (int) Math.log10(circleIt)+1;
					}
					circleIt++;
				}
			}
			//���⸶���� ���������� 2���ø�
			increase[1] += 2;
			increase[2] += 2;
			increase[3] += 2;
			increase[4] += 2;
		}
		
		//���� �迭 ���
		for(int  i = 0; i < boardPart.length; i++){
			for(int j = 0; j < boardPart[i].length; j++){
				for(int p = (int) Math.log10(boardPart[i][j])+1; p < place; p++)
					System.out.print(" ");
				System.out.print(boardPart[i][j]+" ");
			}
			System.out.println();
		}
	}
}
