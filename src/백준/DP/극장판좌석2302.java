//���� ��ó : https://www.acmicpc.net/problem/2302
//���� : �������¼�2302

package ����.DP;
import java.util.ArrayList;
import java.util.Scanner;

public class �������¼�2302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean arr[]= new boolean[n+1];
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++){
			int index = sc.nextInt();
			arr[index] = true;
		}
		
		int dp[][] = new int[n+1][2];//[][3] -> 0:�տ� 1:�����ڸ�
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int k = 2; k <=n; k++){
			if(arr[k]){//�����ڸ��� �������̸�
				dp[k][0] = 0;
				dp[k][1] = dp[k-1][1] +  dp[k-1][0];//�����ڸ��� ���� ��ġ�� ���
			}else{
				if(!arr[k-1])//���ڸ����� �������� �ƴҰ�쿡��(�������̸� ���ڸ����� �ڿ����� ��� x)
					dp[k][0] = dp[k-1][1];//���ڸ��� ���� ��ġ�Ѱ�� == ���ڸ����� �ڿ� ��ġ�Ѱ��
				dp[k][1] = dp[k-1][1] +  dp[k-1][0];//�����ڸ��� ���� ��ġ�� ���
			}
		}
		System.out.println(dp[n][0] + dp[n][1]);
	}
}
