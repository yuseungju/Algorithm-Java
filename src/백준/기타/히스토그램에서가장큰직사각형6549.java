//���� ��ó : https://www.acmicpc.net/problem/6549
//���� : ������׷���������ū���簢��6549

package ����.��Ÿ;
import java.util.Arrays;
import java.util.Scanner;

public class ������׷���������ū���簢��6549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n == 0)
				break;
			int arr[] = new int[n];
			for(int i = 0; i < n;  i++)
				arr[i] = sc.nextInt();
			
			long max = Long.MIN_VALUE;
			for(int i = 0; i < n;  i++){
				int multiple = 1;
				int index = i;
				long area = arr[i];
				for(int j = index+1; j < n; j++){
					if(arr[j] < arr[i])
						break;
					multiple++;
				}
				for(int j = index-1; 0 <= j; j--){
					if(arr[j] < arr[i])
						break;
					multiple++;
				}
				area *= multiple;
				if(max < area)
					max = area; 
			}
			System.out.println(max);
		}
	}
}
