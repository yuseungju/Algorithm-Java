//���� ��ó : https://www.acmicpc.net/problem/2775
//���� : �γ�ȸ���̵��׾�2775

package ����.��Ģ;
import java.util.Scanner;

public class �γ�ȸ���̵��׾�2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[15][15];
		for(int a=1; a<15; a++)
			arr[0][a] = a;
		for(int floor = 1; floor <=14; floor++){
			for(int ho = 1; ho <= 14; ho++){
				for(int c=1; c<=ho; c++)
					arr[floor][ho] += arr[floor-1][c];
			}
		}
		int t = sc.nextInt();
		for(int test = 0; test < t; test++){
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(arr[k][n]);
		}
	}
}
