package 백준.미해결;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test = 1; test <= testcase; test++){
			//입력
			button = new int[10]; 
			for(int i = 0; i < 10; i++)
				button[i] = sc.nextInt();
			resultNum = sc.nextInt();
			
			//dp계산
			dp = new int[resultNum+1];
			
			//1 0 0 5 일 경우
			setDp(resultNum);
			
			//출력
			if(dp[resultNum] == Integer.MAX_VALUE/2)
				System.out.println("#"+test+" -1");
			else
				System.out.println("#"+test+" "+(dp[resultNum] + 1));//결과 버튼 적용하여 출력
		}
	}
	public static int resultNum = 0;
	public static int dp[];
	public static int button[];
	public static void setDp(int k){
		if(k < 0)
			return;
		int min = 0;
		//이어붙이기만으로 수를 구성한 경우
		for(int i = k; 1 <= i; i/=10){
			if(button[i%10] != 1){
				min = Integer.MAX_VALUE/2;
				break;
			}else{
				min++;
			}
		}
		//곱셈으로 나누어 계산할경우의 모든 경우(k를 a*b가 되는 경우로 나누어  a와 b 각각의 최소값을 구함)
		for(int i = 2; i < k;i++){
			if(k%i == 0){//약수이면
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
