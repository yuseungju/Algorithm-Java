package 백준.미해결;

import java.util.Scanner;

public class Main2 {
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
		int min = Integer.MAX_VALUE/2;
		
		//숫자이어붙이기 이전 값으로 계산
		if(button[k%10] == 1){//마지막 누르는 수의 버튼이 존재하면
			//구하지 않은 클릭 최소값의 dp가 있다면 계산
			if(dp[k/10] == 0 && 0 != k/10)
				setDp(k/10);
			if(dp[k/10] + 1 < min)
				min = dp[k/10] + 1;
		}
		dp[k] = min;
		
		//곱셈으로 나누어 계산할경우
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
