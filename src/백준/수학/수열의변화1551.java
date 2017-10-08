//문제 출처 : https://www.acmicpc.net/problem/1551
//제목 : 수열의변화1551

package 백준.수학;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수열의변화1551 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrA[][] = new int[2][sc.nextInt()];
		int n = sc.nextInt();
		String str = sc.next();
		StringTokenizer tk = new StringTokenizer(str, ",");
		for(int i =0 ; tk.hasMoreTokens(); i++)
			arrA[0][i] = Integer.parseInt(tk.nextToken());

		int before =0;
		int current =0;
		for(int c = 0;  c < n; c++){
			before =(c)%2;
			current = (c+1)%2;
			for(int k = 0; k < arrA[0].length-1; k++)
				arrA[current][k] = arrA[before][k+1] - arrA[before][k];
		}
		
		for(int i = 0; i < arrA[0].length-n; i++){
			System.out.print(arrA[current][i]);
			if(i == arrA[0].length-n -1)
				break;
			System.out.print(",");
		}
	}
}
