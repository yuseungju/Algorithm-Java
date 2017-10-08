package 백준.기타;

import java.util.Arrays;
import java.util.Scanner;

public class 보물1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arrA[] = new int[n];
		int arrB[] = new int[n];
		for (int i = 0; i < n; i++)
			arrA[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			arrB[i] = sc.nextInt();
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += (arrA[n - i - 1] * arrB[i]);
		System.out.println(sum);
	}
}
