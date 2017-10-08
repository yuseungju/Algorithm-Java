//문제 출처 : https://www.acmicpc.net/problem/2629
//제목 : 양팔저울2629

package 백준.DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 양팔저울2629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size1 = sc.nextInt();
		int src[] = new int[size1];
		int diSize = 1;
		for(int i = 0; i < size1; i++){
			src[i] = sc.nextInt();
			diSize += src[i];
		}
		
		int dp[] = new int[diSize];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		dp[0] = 1;
		for(int i = 0; i < size1; i++){
			int refItem = src[i];
			int listSize =  list.size();
			for(int l = 0; l < listSize; l++){
				int basicItem = list.get(l);
				int newItem = Math.abs(refItem - basicItem);
				if(dp[newItem] == 0){
					list.add(newItem);
					dp[newItem] = 1;
				}
				newItem = refItem + basicItem;
				if(dp[newItem] == 0){
					list.add(newItem);
					dp[newItem] = 1;
				}
				//System.out.println(list);
			}
		}
		
		int size2 = sc.nextInt();
		for(int  i = 0; i < size2; i++){
			int it = sc.nextInt();
			if(dp.length <= it)
				System.out.print("N ");
			else if(dp[it] == 0 )
				System.out.print("N ");
			else
				System.out.print("Y ");
		}
	}
}




