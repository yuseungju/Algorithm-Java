//���� ��ó : https://www.acmicpc.net/problem/6064
//���� : ī�״޷�6064

package ����.��Ģ;

import java.util.Scanner;

public class ī�״޷�6064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int test = 0; test < testCase;  test++){
			int m,n,x,y;
			//����
			m = sc.nextInt();
			n = sc.nextInt();
			//��ǥ ��¥
			x = sc.nextInt(); 
			y = sc.nextInt(); 
			
			int multipleX = 0;
			int multipleY = 0;
			int xIt = 1;
			int yIt = 1;
			int history = Integer.MIN_VALUE;
			while(true){
				//��ǥ ��¥�ڸ��� ������ �� �̵��� ĭ�� ����
				xIt = m*multipleX + x;
				yIt = n*multipleY + y;
				//��ǥ���������� x�� y�� ���̰� �ٽ� �ݺ��ȴٸ� �����ε� ã�����Ѵٰ� ����
				if(history == xIt - yIt){
					xIt = -1;
					break;
				}else if(history == Integer.MIN_VALUE){
					history = xIt - yIt;
				}
				//x�� y�� ��ǥ�������� ���� �̵��� ������ ���Ͽ� �� �̵��� ��¥�� �ѹ��� �� �����Ͽ� �ٽÿ�
				if(xIt < yIt)
					multipleX++;
				else if(yIt < xIt)
					multipleY++;
				else//��ǥ���� ����ǥ ��� �̵��� ������ ������ ����
					break;
			}
			System.out.println(xIt);
		}
	}
}
