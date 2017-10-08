package 백준.미해결;

import java.util.ArrayList;
import java.util.Scanner;

public class qwd {
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
		int min = Integer.MAX_VALUE/2;
		if(k < 0)
			return;
		//곱셈 이전 값으로 계산
		for(int i = 2; i < 10; i++){//곱셈의미가 있는 수만큼
			//이전에 눌렀던 (곱셈)수의 조건: 정확히 나누어지는 숫자 && 1보다 큰수  && 버튼이 작동함
			if(k%i == 0 && 1 < k/i && button[i] == 1){
				//구하지 않은 클릭 최소값의 dp가 있다면 계산
				if(dp[k/i] == 0 && 0 != k/i)
					setDp(k/i);
				if(dp[k/i] + 2 < min)
					min = dp[k/i] + 2;
			}
		}
		//숫자이어붙이기 이전 값으로 계산
		if(button[k%10] == 1){//마지막 누르는 수의 버튼이 존재하면
			//구하지 않은 클릭 최소값의 dp가 있다면 계산
			if(dp[k/10] == 0 && 0 != k/10)
				setDp(k/10);
			if(dp[k/10] + 1 < min)
				min = dp[k/10] + 1;
		}
		dp[k] = min;
	}
}
