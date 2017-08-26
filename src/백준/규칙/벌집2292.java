//문제 출처 : https://www.acmicpc.net/problem/2292
//제목 : 벌집2292

package 백준.규칙;

import java.io.IOException;
import java.util.Scanner;

public class 벌집2292 {
	//1:/1       1    
	//2:/2-7     6      1 + 6*0
	//3:/8-19    12     2 + 6*1
	//4:/20-37   18     8 + 6*2
	//5:/38-61   24
	public static void main(String[] args) throws IOException {
		System.out.println(getIndex(new Scanner(System.in).nextInt()));
	}
	//수열에서 입력숫자에 해당되는 인덱스를 가져옴
	public static int getIndex(int num){
		if(num == 1)
			return 1;
		int first=1;
		for(int a=2; ; a++){
			first += 6*(a-1);
			if(num <= first)
				return a;
		}
	}
	//인덱스에 해당되는 수열값을 가져옴
	public static int getEndNum(int n){
		int first=1;
		for(int a=2; a<=n; a++){
			first += 6*(a-1);
		}
		return first;
	}
}
