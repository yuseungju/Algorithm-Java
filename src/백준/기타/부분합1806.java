//문제 출처 : https://www.acmicpc.net/problem/1806
//제목 : 부분합1806
//two pointer

package 백준.기타;

import java.util.Scanner;

public class 부분합1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min =sc.nextInt();
		int arr[] = new int[n+1];
		int minLength = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		
		int f = 1;
		int e = 1;
		int sum = arr[f];
		while(true){
			if(sum < min){
				e++;
				if(e <= n)
					sum += arr[e];
				else
					break;
			}else{
				sum -= arr[f];
				if(e-f+1 < minLength)
					minLength = e-f+1;
				f++;
			}
			/*for(int i  = f;  i <=e; i++)
				System.out.print(arr[i] + " ");
			System.out.println();*/
		}
		if(minLength == Integer.MAX_VALUE)
			minLength = 0;
		System.out.println(minLength);
	}
}
