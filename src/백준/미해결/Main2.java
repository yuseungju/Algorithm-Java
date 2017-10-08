package ����.���ذ�;

import java.util.Scanner;

public class Main2 {
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
		int min = Integer.MAX_VALUE/2;
		
		//�����̾���̱� ���� ������ ���
		if(button[k%10] == 1){//������ ������ ���� ��ư�� �����ϸ�
			//������ ���� Ŭ�� �ּҰ��� dp�� �ִٸ� ���
			if(dp[k/10] == 0 && 0 != k/10)
				setDp(k/10);
			if(dp[k/10] + 1 < min)
				min = dp[k/10] + 1;
		}
		dp[k] = min;
		
		//�������� ������ ����Ұ��
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
