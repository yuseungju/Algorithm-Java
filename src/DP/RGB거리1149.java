//巩力 免贸 : https://www.acmicpc.net/problem/1149
//力格 : RGB芭府1149

package DP;
import java.io.IOException;
import java.util.Scanner;

public class RGB芭府1149 {
	static int[] r;
	static int[] g;
	static int[] b;
	static int n;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		r = new int[n];
		g = new int[n];
		b = new int[n];
		for (int c = 0; c < n; c++) {
			r[c] = Integer.parseInt(sc.next());
			g[c] = Integer.parseInt(sc.next());
			b[c] = Integer.parseInt(sc.next());
		}
		int min = Integer.MAX_VALUE;
		int value = minCost(1, 'r');
		if (min > value)
			min = value;
		value = minCost(1, 'b');
		if (min > value)
			min = value;
		value = minCost(1, 'g');
		if (min > value)
			min = value;
		System.out.println(min);
	}

	public static int minCost(int i, char rgb) {
		if (i == n+1)
			return 0;
		int min = Integer.MAX_VALUE;
		int value = 0;
		if (rgb == 'r') {
			value = minCost(i + 1, 'g') + r[i - 1]; 
			if (min > value)
				min = value;
			value = minCost(i + 1, 'b') + r[i - 1];
			if (min > value)
				min = value;
		} else if (rgb == 'g') {
			value = minCost(i + 1, 'r') + g[i - 1];
			if (min > value)
				min = value;
			value = minCost(i + 1, 'b') + g[i - 1];
			if (min > value)
				min = value;
		} else if (rgb == 'b') {
			value = minCost(i + 1, 'g') + b[i - 1];
			if (min > value)
				min = value;
			value = minCost(i + 1, 'r') + b[i - 1];
			if (min > value)
				min = value;
		}
		return min;
	}
}
