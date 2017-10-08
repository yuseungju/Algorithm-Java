package ����.���ذ�;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 1; test <= testcase; test++){
			//�Է�
			button = new int[10]; 
			for(int i = 0; i < 10; i++)
				button[i] = sc.nextInt();
			resultNum = sc.nextInt();
			
			//dp���
			dp = new int[resultNum+1];
			
			//1 0 0 5 �� ���
			setDp(resultNum);
			
			//���
			if(dp[resultNum] == Integer.MAX_VALUE/2)
				System.out.println("#"+test+" -1");
			else
				System.out.println("#"+test+" "+(dp[resultNum] + 1));//��� ��ư �����Ͽ� ���
		}
	}
	public static int resultNum = 0;
	public static int dp[];
	public static int button[];
	public static void setDp(int k){
		if(k < 0)
			return;
		int min = 0;
		//�̾���̱⸸���� ���� ������ ���
		for(int i = k; 1 <= i; i/=10){
			if(button[i%10] != 1){
				min = Integer.MAX_VALUE/2;
				break;
			}else{
				min++;
			}
		}
		//�������� ������ ����Ұ���� ��� ���(k�� a*b�� �Ǵ� ���� ������  a�� b ������ �ּҰ��� ����)
		for(int i = 2; i < k;i++){
			if(k%i == 0){//����̸�
				if(dp[k/i] == 0)
					setDp(k/i);
				if(dp[i] == 0)
					setDp(i);
				if(dp[i] + dp[k/i] + 1 < min)
					min =  dp[i] + dp[k/i] + 1;
			}
		}
		dp[k] = min;
	}
}
